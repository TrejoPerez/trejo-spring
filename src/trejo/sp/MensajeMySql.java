/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trejo.sp;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author T-101
 */
public class MensajeMySql extends Mensaje implements  ComportamientoMensaje{
    
    @Override
    public ArrayList<Mensaje> leerTodosLosMensajes() {
//Aqui va el DAOMensaje
        DAOMensaje dao = new DAOMensaje();
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        try {
            mensajes = dao.buscarTodos();
        } catch (Exception ex) {
            Logger.getLogger(MensajeMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensajes;
    }

    @Override
    public void guardar(Mensaje m) {
        DAOMensaje dao = new DAOMensaje();
        try {
            dao.guardar(m);
            
        } catch (Exception ex) {
            Logger.getLogger(MensajeMySql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al guardar");
        }
        
    }

    @Override
    public void borrar(Integer id) {
        DAOMensaje dao = new DAOMensaje();
        try {
            dao.borrar(id);
            
        } catch (Exception ex) {
            Logger.getLogger(MensajeMySql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al borrar");
            
        }
        
    }

    @Override
    public void actualizar(Mensaje m) {
        DAOMensaje dao = new DAOMensaje();
        try {
            dao.actualizar(m);
            
        } catch (Exception ex) {
            Logger.getLogger(MensajeMySql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al actualizar");
        }
        
    }

    @Override
    public Mensaje buscarId(Integer id) {
        Mensaje m = new Mensaje();
        DAOMensaje dao = new DAOMensaje();
        try {
             m=dao.buscarPorId(id);
        } catch (Exception ex) {
            Logger.getLogger(MensajeMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    
}
