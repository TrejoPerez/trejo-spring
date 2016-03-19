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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T-101
 */
public class MensajeSerializado extends Mensaje implements ComportamientoMensaje{
    public static final String archivo="Mensajes";
    @Override
    public ArrayList<Mensaje> leerTodosLosMensajes() {
        ArrayList<Mensaje> m = new ArrayList();
        try{
            File f = new File(archivo);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            m = (ArrayList<Mensaje>) ois.readObject();
            
        }catch(IOException | ClassNotFoundException e ){
            System.out.println("hubo un error al leer el mensaje"+e.getMessage());
        }
        return m;
    }/*
    public static void main(String[] args) throws Exception {
        MensajeSerializado m = new MensajeSerializado();
        Mensaje men = new Mensaje();
        ArrayList<Mensaje> mensajito = m.leerTodosLosMensajes();
        //men.setCuerpo("Mensajes serializados");
        men.setId(2);
        //men.setTitulo(" serializado");
        
        //mensajito.add(men);
        
        //m.guardarUsuario(men);
        //mensajito.remove(m);
        
        System.out.println(m.leerTodosLosMensajes().get(2).getTitulo());
        //System.out.println("Removido");
    }*/
    @Override
    public void guardar(Mensaje m) {
        ArrayList<Mensaje> mensaje = new ArrayList<>();
        File f = new File(archivo);
        try {
            if(f.exists()) mensaje = leerTodosLosMensajes();
            FileOutputStream fis = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            mensaje.add(m);
            oos.writeObject(mensaje);
        } catch (Exception e) {
            Logger.getLogger(MensajeSerializado.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }

    @Override
    public void borrar(Integer id) {
        ArrayList<Mensaje> mensajes = leerTodosLosMensajes();
        mensajes.remove(id);
        
    }

    @Override
    public void actualizar(Mensaje m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
