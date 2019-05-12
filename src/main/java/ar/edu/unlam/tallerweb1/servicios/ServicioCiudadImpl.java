package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.CiudadDaoImpl;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
@Service("ServicioCiudad")
@Transactional
public class ServicioCiudadImpl implements ServicioCiudad {

    @Inject
    private CiudadDaoImpl ciudadDao;

    @Override
    public Ciudad todasLasCiudades() {
        return null;
    }
}
