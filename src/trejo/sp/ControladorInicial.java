/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trejo.sp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author campitos
 */
@Controller
@RequestMapping("/")

public class ControladorInicial {
    //Aqui se despacha la vista
    @RequestMapping("/")
    public String trejop(){
        return "inicio.html";
    }
}
