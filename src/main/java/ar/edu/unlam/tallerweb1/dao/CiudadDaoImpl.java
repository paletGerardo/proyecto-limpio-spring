package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class CiudadDaoImpl implements CiudadDao {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public Ciudad obtenerCiudad(Ciudad ciudad) {

        final Session session = sessionFactory.getCurrentSession();

        return (Ciudad) session.createCriteria(Ciudad.class)
                .add(Restrictions.eq("id" , ciudad.getId()));
    }

    @Override
    public List<Ciudad> obtenerTodas() {
        final Session session = sessionFactory.getCurrentSession();

        return null;
    }
}
