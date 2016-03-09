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
public class Pato {
    private String color;
    private Integer edad;
    public void hacerCuac(){
        System.out.println("cuac-Cuac");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
