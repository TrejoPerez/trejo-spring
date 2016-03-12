/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pato;

/**
 *
 * @author campitos
 */
public class MainPato {
    public static void main(String[] args) {
      Pato p = new Pato(new PatoCaricatura());
      p.mostrarRuido();  
    }
}
