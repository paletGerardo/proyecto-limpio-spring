package ar.edu.unlam.tallerweb1.tp;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
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

    private Ciudad newYork, seatle , bobMarley, Bogota, madrid, londres;

    private Pais eeuu, canada, jamaica, colombia, españa, inglaterra;

    private List<Ciudad> listaCiudades;
    private List<Pais> listaPaises;

    @Before
    public void prev() {

        session = getSession();

        america = new Continente("America");
        europa = new Continente("Europa");

        newYork = new Ciudad("New York");
        seatle = new Ciudad("Seatle");
        bobMarley = new Ciudad("bobMarley");
        Bogota = new Ciudad("Bogota");
        madrid = new Ciudad("Madrid");
        londres = new Ciudad("Londres");


        eeuu = new Pais("EEUU", "66666666", "chino", newYork, america);
        canada = new Pais("Canada", "66666666", "chino", seatle, america);
        jamaica = new Pais("Jamaica", "66666666", "jamaicano", bobMarley, america);
        colombia = new Pais("Colombia", "66666666", "Español", Bogota, america);
        españa = new Pais("España", "66666666", "Español", madrid, europa);
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
        session.save(seatle);

        session.save(eeuu);
        session.save(canada);
        session.save(jamaica);
        session.save(colombia);
        session.save(españa);
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


}
