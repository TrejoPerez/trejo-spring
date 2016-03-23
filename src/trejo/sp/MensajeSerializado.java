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
    @Override
    public ArrayList<Mensaje> leerTodosLosMensajes() {
        ArrayList<Mensaje> m = new ArrayList();
        try{
            File f = new File(archivo);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            m = (ArrayList<Mensaje>) ois.readObject();
            fis.close();
            ois.close();
            
        }catch(IOException | ClassNotFoundException e ){
            System.out.println("hubo un error al leer el mensaje"+e.getMessage());
        }
        return m;
    }
    @Override
    public void guardar(Mensaje m) {
        Integer Id;
        ArrayList<Mensaje> mensaje = new ArrayList<>();
        File f = new File(archivo);
        try {
            if(f.exists()) mensaje = leerTodosLosMensajes();
            Id = mensaje.size()+1;
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            m.setId(Id);
            mensaje.add(m);
            oos.writeObject(mensaje);
            fos.close();
            oos.close();
            
        } catch (Exception e) {
            Logger.getLogger(MensajeSerializado.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("Error al guardar");
        }
        
        
    }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
   
    public static void main(String[] args) throws Exception {
        MensajeSerializado m = new MensajeSerializado();
        Mensaje men = new Mensaje();
        ArrayList<Mensaje> mensajito = m.leerTodosLosMensajes();
        //men.setCuerpo("Mensajes serializados");
        
       
        ArrayList<String> p = new ArrayList<>();
        p.add("Hola");
        p.add("Mundo");
        //p.remove(0);
        //System.out.println(p.get(0));
        
        
        //mensajito.add(men);
        //m.guardar(men);
        
        //System.out.println(m.buscarId(4).getCuerpo());
        //men.setTitulo(" serializado");
        
        //mensajito.add(men);
        
        //m.guardarUsuario(men);
        //mensajito.remove(m);
       /* List<Mensaje> nuevo = m.leerTodosLosMensajes();
        Iterator<Mensaje> iterador = nuevo.iterator();
        
        while(iterador.hasNext()){
            try{
            if(iterador.next().getId().equals(2)){
                iterador.remove();
                //System.out.println(iterador.next().getTitulo());
                
                
                
            }else{
                
                System.out.println("Else: "+iterador.next().getTitulo());
            }
            
            }catch(Exception e){
                
            }
        }
        
        */
        
         //m.borrar();
        System.out.println(m.buscarId(2).getTitulo());
        System.out.println(m.buscarId(1).getCuerpo());
            
        
        
        
        
    }
    

}
