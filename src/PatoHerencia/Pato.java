/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatoHerencia;

/**
 *
 * @author root
 */
public class Pato{
    private HPato p = new PatoIngles();
    public Pato(HPato p) {
        this.p = p;
    }
    public void ruido(){
        p.hacerRuido();
    }
   

}
