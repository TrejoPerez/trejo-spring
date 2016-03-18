/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trejo.sp;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author campitos
 */
@Controller
//uri
@RequestMapping("/")
public class ControladorMensaje {
    @Autowired ComportamientoMensaje miServicioMensaje;
    /*Por cada entidad se genera un controlador
    @RequestMapping(value="/mensaje",method=RequestMethod.GET,headers={"Accept=application/json"})
    @ResponseBody String buscartodos() throws Exception{
        /*Esto va a ser obtenido atraves del DAOMensaje y su metodo obtener todos
        Mensaje m1 = new Mensaje();
        m1.setTitulo("Springboot");
        m1.setCuerpo("Springboot es la neta del planeta");
        
        Mensaje m2 = new Mensaje();
        m2.setTitulo("Java 3");
        m2.setCuerpo("Esta materia es facil ");
        
        Mensaje m3 = new Mensaje();
        m3.setTitulo("Odniel");
        m3.setCuerpo("Tu no vas a pasar :D");
        
        ArrayList<Mensaje> arreglo = new ArrayList<Mensaje>();
        arreglo.add(m1);
        arreglo.add(m2);
        arreglo.add(m3);
        //Vamos a usar una clase que se llama ObjectMapper 
        //Para traducir a JSON
        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(arreglo);
        
        DAOMensaje dao = new DAOMensaje();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dao.buscarTodos());
    }
*/
    @RequestMapping(value="/mensaje/{id}", method=RequestMethod.GET, headers = {"Accept=application/json"})
    @ResponseBody String buscarPorId(@PathVariable Integer id)throws Exception{
        DAOMensaje dao = new DAOMensaje();
        Mensaje m = dao.buscarPorId(id);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(m);
    }
    @CrossOrigin
    @RequestMapping(value = "/mensaje/{titulo}/{cuerpo}", method = RequestMethod.POST, headers ={"Accept=text/html"})
    @ResponseBody String guardarMensaje(@PathVariable String titulo, @PathVariable String cuerpo) throws Exception{
        Mensaje m= new Mensaje();
        m.setTitulo(titulo);
        m.setCuerpo(cuerpo);
        miServicioMensaje.guardar(m);
        return "Mensaje guardado con exito";
    }
    
    @CrossOrigin
    @RequestMapping(value = "/mensaje/{id}",method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    @ResponseBody String borrarMensaje(@PathVariable Integer i) throws Exception{
        Mensaje m = new Mensaje();
        m.setId(i);
        miServicioMensaje.borrar(i);
        return "Mensaje borrado con exito";
    }
    
       
    
    @RequestMapping(value="/mensaje",method=RequestMethod.GET,headers={"Accept=application/json"})
    @ResponseBody String buscartodosp() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        
        ArrayList<Mensaje> mensaje = miServicioMensaje.leerTodosLosMensajes();
        return mapper.writeValueAsString(mensaje);
    }
}
