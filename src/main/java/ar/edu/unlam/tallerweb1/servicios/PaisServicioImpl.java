package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.PaisDao;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service("servicioPais")
@Transactional
public class PaisServicioImpl implements PaisServicio {

    @Inject
    private PaisDao paisDao;


    @Override
    public void guardarPaises(List<Pais> lista) {
        paisDao.guardarPaises(lista);
    }
}
