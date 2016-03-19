/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trejo.sp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author T-101
 */
public class MensajeSerializado extends Mensaje implements ComportamientoMensaje{
    public void guardarUsuario(Mensaje m) throws Exception{
        ArrayList<Mensaje> mensaje= new ArrayList();
        File f = new File("Mensajes");
        try{
            if(f.exists()) mensaje = leerTodosLosMensajes();
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            mensaje.add(m);
            oos.writeObject(mensaje);
            System.out.println("Mensaje Guardado");
        }catch(Exception e){
            System.out.println("Hubo un error al guardar el mensaje");
        }
    }
    @Override
    public ArrayList<Mensaje> leerTodosLosMensajes() {
        /*
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
        */
        ArrayList<Mensaje> m = new ArrayList();
        try{
            File f = new File("Mensajes");
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
        ArrayList<Mensaje> mensajito = new ArrayList();
        men.setCuerpo("Mensajes serializados");
        men.setId(2);
        men.setTitulo(" serializado");
        
        //mensajito.add(men);
        
        //m.guardarUsuario(men);
        
        System.out.println(m.leerTodosLosMensajes().get(2).getCuerpo());
        
    }*/

    @Override
    public void guardar(Mensaje m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Mensaje m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
