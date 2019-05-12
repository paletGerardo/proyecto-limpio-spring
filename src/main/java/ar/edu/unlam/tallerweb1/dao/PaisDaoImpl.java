package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Pais;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository("PaisDao")
public class PaisDaoImpl implements PaisDao {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public void guardarPaises(List<Pais> lista) {
        final Session session = sessionFactory.getCurrentSession();

        for (Pais pais: lista ) {
            session.save(pais);
        }

    }

    @Override
    public List<Pais> buscarPaisesPor(String criterio) {
        return null;
    }
}
