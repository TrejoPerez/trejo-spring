/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trejo.sp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T-101
 */
public class MensajeSerializado extends Mensaje implements ComportamientoMensaje{
    public static final String archivo="Mensajes";
     public Integer buscarPosicion(Integer id){
        Integer posicion=-1;
        ArrayList<Mensaje> buscar = leerTodosLosMensajes();
        for(Mensaje m: buscar){
            if(m.getId().equals(id)){
                posicion = posicion+1;
                break;
            }else{
                posicion = posicion+1;
            }
        }
        return posicion;
    }
    @Override
    public ArrayList<Mensaje> leerTodosLosMensajes() {
        ArrayList<Mensaje> m = new ArrayList();
        try{
            File f = new File(archivo);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            m = (ArrayList<Mensaje>) ois.readObject();
            //fis.close();
            //ois.close();
        }catch(IOException | ClassNotFoundException e ){
            System.out.println("hubo un error al leer el mensaje"+e.getMessage());
        }
        return m;
    }
    @Override
    public void guardar(Mensaje m) {
        try {
            Integer Id;
            ArrayList<Mensaje> mensaje = leerTodosLosMensajes();
            File f = new File(archivo);
            if(f.exists()) mensaje = leerTodosLosMensajes();
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Id = mensaje.get(mensaje.size()-1).getId()+1;
            m.setId(Id);
            mensaje.add(m);
            oos.writeObject(mensaje);
            fos.close();
            oos.close();
        } catch (Exception e) {
            Logger.getLogger(MensajeSerializado.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("Error al guardar" + e.getMessage());
        } 
        
    }
    @Override
    public void borrar(Integer id) {    
        try {
            ArrayList<Mensaje> mensaje = leerTodosLosMensajes();
            mensaje.remove(mensaje.get(buscarPosicion(id)));
            FileOutputStream fos = new FileOutputStream(new File(archivo));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(mensaje);
            fos.close();
            oos.close();
        } catch (Throwable ex) {
            Logger.getLogger(MensajeSerializado.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al borrar");
        }
    }
    @Override
    public void actualizar(Mensaje m) {
        try {
            ArrayList<Mensaje> mensaje = leerTodosLosMensajes();
            Integer pos = buscarPosicion(m.getId());
            mensaje.remove(mensaje.get(buscarPosicion(m.getId())));
            FileOutputStream fos = new FileOutputStream(new File(archivo));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            mensaje.add(pos, m);
            oos.writeObject(mensaje);
            fos.close();
            oos.close();
            System.out.println("Actualizado");
            
        } catch (Throwable tx) {
            Logger.getLogger(MensajeSerializado.class.getName()).log(Level.SEVERE, null, tx);
        }
    }
    @Override
    public Mensaje buscarId(Integer id) {
        Mensaje m = new Mensaje();
        ArrayList<Mensaje> mensaje = leerTodosLosMensajes();
        m.setId(mensaje.get(buscarPosicion(id)).getId());
        m.setCuerpo(mensaje.get(buscarPosicion(id)).getCuerpo());
        m.setTitulo(mensaje.get(buscarPosicion(id)).getTitulo());
        return m;
    }

}
