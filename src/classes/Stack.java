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
public class Stack {
    public Stack(Object value) {
        lista = new List(value);
        top = lista.first();
    }
    public Stack() {
        lista = new List();
    }
    public void push_back(Object value){
        lista.pushback(value);
        top = lista.Last();
    }
    public Node pop_back(){
        Node temp = lista.Last();
        lista.remove(lista.size()-1);
        top = lista.Last();
        return temp;
    }
    public Object peek(){
        return lista.Last().getValue();
    }
    public void print(){
        lista.print();
    }
    public int size(){
        return lista.size();
    }
    List lista;
    Node top;
    
}
