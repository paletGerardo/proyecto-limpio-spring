package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.servicios.ServicioCiudad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ControladorCiudad {

    @Inject
    private ServicioCiudad servicioCiudad;

    @RequestMapping("/todas")
    public ModelAndView obtenerCiudad(){
        ModelMap model = new ModelMap();
        List<Ciudad> lista = (List<Ciudad>) servicioCiudad.todasLasCiudades();

        return new ModelAndView("home", model);
    }
}
