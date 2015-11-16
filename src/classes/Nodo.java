/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author isaac
 */
public class Nodo {
    private int value;
    private Nodo padre;
    private Nodo izquierda;
    private Nodo derecha;
    
    public Nodo(int value){
        this.value = value;
    }

    public Nodo() {
    
    }
        
    
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
    
    
}
