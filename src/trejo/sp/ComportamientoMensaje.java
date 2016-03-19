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
public interface ComportamientoMensaje {
    ArrayList<Mensaje>leerTodosLosMensajes();
    public void guardar (Mensaje m);
    public void borrar(Integer i);
    public void actualizar(Mensaje m);
}
