/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trejo.sp;

import java.util.ArrayList;

/**
 *
 * @author T-101
 */
public class MensajeSerializado extends Mensaje implements ComportamientoMensaje{

    @Override
    public ArrayList<Mensaje> leerTodosLosMensajes() {
        Mensaje m1 = new Mensaje();
        m1.setTitulo("primer mensaje Serializado");
        m1.setCuerpo("Cuerpo del serializado");
        
        Mensaje m2 = new Mensaje();
        m2.setTitulo("Segundo mensaje Serializado");
        m2.setCuerpo("Puerca del serializado");
        ArrayList<Mensaje> mensajitos = new ArrayList();
        mensajitos.add(m1);
        mensajitos.add(m2);
        return mensajitos;
        
    }
    
}
