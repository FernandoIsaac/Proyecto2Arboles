/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author mauricio
 */
public class Node {
    private Node next;
    private Object value;
    private int valor;
    private Arbol arbol;

    public Node() {
    }

    public Node(Object value) {
        this.value = value;
    }
    
    
    public Node getNext() {
        return this.next;
    }

    public void setNext(Node node) {
        this.next = node;
    }
    
    public int getValor(){
        return this.valor;
    }

    public Arbol getArbol(){
        return this.arbol;
    }
    public void setArbol(Arbol arbol){
        this.arbol = arbol;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }
   
    public boolean hasNext() {
        if (this.next != null) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + value;
    }
    
}
