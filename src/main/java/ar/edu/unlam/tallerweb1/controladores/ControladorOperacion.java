package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/operacion")
public class ControladorOperacion {

    @RequestMapping("/{operacion}/{cadena}")
    public ModelAndView operacion(@PathVariable String operacion, @PathVariable String cadena) {
        ModelMap modelo = new ModelMap();
        String resultado = new String();

        switch (operacion) {

            case "mayuscula":
                resultado = cadena.toUpperCase();
                break;

            case "minuscula":
                resultado = cadena.toLowerCase();
                break;
            case "invertir":
                StringBuilder builder = new StringBuilder(cadena);
                resultado = builder.reverse().toString();
                break;

            case "contar":
                int result = cadena.length();
                resultado = Integer.toString(result);
                break;

            default:
                return new ModelAndView("redirect:/error");

        }

        modelo.put("operacion", operacion);
        modelo.put("cadena", cadena);
        modelo.put("resultado", resultado);


        return new ModelAndView("resultado", modelo);
    }

    @RequestMapping("/error")
    public ModelAndView error() {
        ModelMap modelo = new ModelMap();
        return new ModelAndView("error",modelo);
    }

}
