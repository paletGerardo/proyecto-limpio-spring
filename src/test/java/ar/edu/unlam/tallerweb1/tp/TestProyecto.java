package ar.edu.unlam.tallerweb1.tp;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.servicios.PaisServicio;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class TestProyecto extends SpringTest {

    private Session session;

    private Continente america, europa;

    private Ciudad newYork, seatle , bobMarley, Bogota, madrid, londres;

    private Pais eeuu, canada , jamaica, colombia, españa, inglaterra;

    private List<Ciudad> listaCiudades;
    private List<Pais> listaPaises;

    @Before
    private void prev() {

        session = getSession();

        america = new Continente("America");
        europa = new Continente("Europa");

        newYork = new Ciudad("New York");
        seatle = new Ciudad("Seatle");
        bobMarley = new Ciudad("bobMarley");
        Bogota = new Ciudad("Bogota");
        madrid = new Ciudad("Madrid");
        londres = new Ciudad("Londres");


        eeuu = new Pais("EEUU", "66666666", "ingles", newYork, america);
        canada = new Pais("Canada", "66666666", "ingles", seatle, america);
        jamaica = new Pais("Jamaica", "66666666", "jamaicano", bobMarley, america);
        colombia = new Pais("Colombia", "66666666", "Español", Bogota, america);
        españa = new Pais("España", "66666666", "Español", madrid, europa);
        inglaterra = new Pais("Inglaterra", "66666666", "ingles", londres, europa);

        listaCiudades.add(newYork);
        listaCiudades.add(bobMarley);
        listaCiudades.add(Bogota);
        listaCiudades.add(madrid);
        listaCiudades.add(londres);
        listaCiudades.add(seatle);

        listaPaises.add(eeuu);
        listaPaises.add(canada);
        listaPaises.add(jamaica);
        listaPaises.add(colombia);
        listaPaises.add(españa);
        listaPaises.add(inglaterra);

        session.save(america);
        session.save(europa);
        session.save(listaPaises);
        session.save(listaCiudades);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void listarPaisesHablaInglesa() {


        List<Pais> paises = session.createCriteria(Pais.class)
                .add(Restrictions.eq("idioma", "ingles"))
                .list();

        for (Pais pais : paises ) {
            assertThat(pais.getIdioma()).isEqualTo("ingles");
        }
    }


}
