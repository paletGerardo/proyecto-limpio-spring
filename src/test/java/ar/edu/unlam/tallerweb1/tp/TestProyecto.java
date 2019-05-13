package ar.edu.unlam.tallerweb1.tp;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class TestProyecto extends SpringTest {

    private Session session;

    private Continente america, europa;

    private Ciudad newYork, ottawa , bobMarley, Bogota, madrid, londres;

    private Pais eeuu, canada, jamaica, colombia, espania, inglaterra;

    private List<Ciudad> listaCiudades;
    private List<Pais> listaPaises;

    @Before
    public void prev() {

        session = getSession();

        america = new Continente("America");
        europa = new Continente("Europa");

        newYork = new Ciudad("New York");
        ottawa = new Ciudad("Seatle");
        bobMarley = new Ciudad("bobMarley");
        Bogota = new Ciudad("Bogota");
        madrid = new Ciudad("Madrid");
        londres = new Ciudad("Londres");

        newYork.setUbicacionGeografica(new Ubicacion(40.6643, -73.9385));
        ottawa.setUbicacionGeografica(new Ubicacion(45.4208, -75.69));
        bobMarley.setUbicacionGeografica(new Ubicacion(18.25, -77.50));
        Bogota.setUbicacionGeografica(new Ubicacion(4.6097, -74.0817));
        madrid.setUbicacionGeografica(new Ubicacion(40.4167, -3.7032));
        londres.setUbicacionGeografica(new Ubicacion(51.5072, -0.1275));


        eeuu = new Pais("EEUU", "66666666", "chino", newYork, america);
        canada = new Pais("Canada", "66666666", "chino", ottawa, america);
        jamaica = new Pais("Jamaica", "66666666", "jamaicano", bobMarley, america);
        colombia = new Pais("Colombia", "66666666", "Español", Bogota, america);
        espania = new Pais("España", "66666666", "Español", madrid, europa);
        inglaterra = new Pais("Inglaterra", "66666666", "chino", londres, europa);

        listaCiudades = new ArrayList<>();
        listaPaises = new ArrayList<>();

        session.save(america);
        session.save(europa);

        session.save(newYork);
        session.save(bobMarley);
        session.save(Bogota);
        session.save(madrid);
        session.save(londres);
        session.save(ottawa);

        session.save(eeuu);
        session.save(canada);
        session.save(jamaica);
        session.save(colombia);
        session.save(espania);
        session.save(inglaterra);



    }

    @Test
    @Transactional
    public void listarPaisesHablaInglesa() {


        listaPaises = session.createCriteria(Pais.class)
                .add(Restrictions.eq("idioma", "ingles"))
                .list();

        for (Pais pais : listaPaises ) {
            assertThat(pais.getIdioma()).isEqualTo("ingles");
        }
    }

    @Transactional
    @Rollback
    @Test
    public void buscarPaisesDelContinenteEuropeo() {


        listaPaises = session.createCriteria(Pais.class)
                .createAlias("continente", "con")
                .add(Restrictions.eq("con.nombre", "Europa"))
                .list();

        for (Pais pais : listaPaises ) {
            assertThat(pais.getContinente().getNombre()).isEqualTo("Europa");
        }

    }

    @Transactional
    @Rollback
    @Test
    public void PaisesCuyaCapitalEstanAlNorteDelTropicoDeCancer() {


        listaPaises = session.createCriteria(Pais.class)
                .createAlias("capital", "cap")
                .createAlias("cap.ubicacionGeografica", "ubi")
                .add(Restrictions.gt("ubi.latitud", 24D))
                .list();

        for (Pais pais : listaPaises ) {
            assertThat(pais.getCapital().getUbicacionGeografica().getLatitud() > 24);
        }

    }

    @Transactional
    @Rollback
    @Test
    public void buscarTodasLasCiudadesDelHemisferioSur() {


        listaPaises = session.createCriteria(Pais.class)
                .createAlias("capital", "cap")
                .createAlias("cap.ubicacionGeografica", "ubi")
                .add(Restrictions.le("ubi.latitud", 0.0))
                .list();

        for (Pais pais : listaPaises ) {
            assertThat(pais.getCapital().getUbicacionGeografica().getLatitud() <= 0);
        }

    }


}
