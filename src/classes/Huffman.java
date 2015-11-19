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
public class Huffman {
    public Arbol Huffman(List frecuencias){
        this.ordenar(frecuencias);
        Arbol TreeToReturn, temp;
        List ListaDeArboles= new List();
        for (int i = 0; i < frecuencias.size(); i++) {
            Arbol tree = new Arbol((int) frecuencias.get(i).getValue());
            ListaDeArboles.insert(i, tree);
        }
        do{
            temp = new Arbol(new Nodo((int)ListaDeArboles.get(0).getValue()+(int)ListaDeArboles.get(1).getValue()));
            temp.addNodo((Nodo)ListaDeArboles.get(0).getValue());
            temp.addNodo((Nodo)ListaDeArboles.get(1).getValue());
            ListaDeArboles.remove(0);
            ListaDeArboles.remove(1);
            ListaDeArboles.pushback(temp);
            this.ordenar(ListaDeArboles);
        }while(ListaDeArboles.size()>1);
        TreeToReturn = temp;
        return TreeToReturn;
    }
    
    public void ordenar(List ListToOrder){
        for (int i = 0; i < ListToOrder.size(); i++) {
            for (int j = 0; j < ListToOrder.size()-1; j++) {
                if((int)ListToOrder.get(j).getValue()>(int)ListToOrder.get(j+1).getValue()){
                    int mayor = (int)ListToOrder.get(i).getValue();
                    ListToOrder.insert(j, ListToOrder.get(j+1));
                    ListToOrder.insert(j+1, mayor);
                }
            }
        }
    }
}
