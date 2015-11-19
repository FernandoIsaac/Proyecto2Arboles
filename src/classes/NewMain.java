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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Arbol tree = new Arbol(17);
        Arbol tree;
        //Arbol tree2 = new Arbol(99);
        List lista = new List();
        lista.pushback(45);
        lista.pushback(20);
        lista.pushback(15);
        lista.pushback(10);
        lista.pushback(7);
        lista.pushback(5);
        
        /*lista.pushback(5);
        lista.pushback(7);
        lista.pushback(10);
        lista.pushback(15);
        lista.pushback(20);
        lista.pushback(45);
        */
        tree = lista.Huffman(lista);

        System.out.println(tree.getRaiz());

        /*tree.addNodo(new Nodo(44));
         tree.addNodo(new Nodo(8));
         tree.addNodo(new Nodo(5));
         tree.addNodo(new Nodo(14));
         tree.addNodo(new Nodo(4));
         tree.addNodo(new Nodo(34));
         tree.addNodo(new Nodo(2));
         tree.addNodo(new Nodo(52));
         tree.addNodo(new Nodo(21));
         tree.addNodo(new Nodo(52));
         tree.addNodo(new Nodo(11));
         tree.addNodo(new Nodo(12));
         tree.addNodo(new Nodo(91));
         tree.addNodo(new Nodo(17));
         */
        //tree2.addNodo(tree.getRaiz());
        /* System.out.println(tree.getRaiz().getValue());
         System.out.println(tree.getRaiz().getDerecha().getValue());
         System.out.println(tree.getRaiz().getIzquierda().getValue());
         System.out.println(tree.getRaiz().getDerecha().getDerecha().getValue());
         System.out.println(tree.getRaiz().getDerecha().getIzquierda().getValue());
         System.out.println(tree.getRaiz().getIzquierda().getDerecha().getValue());
         System.out.println(tree.getRaiz().getIzquierda().getIzquierda().getValue());
            
         tree.getRaiz().getDerecha().setPadre(tree.getRaiz());
         tree.getRaiz().getIzquierda().setPadre(tree.getRaiz());
         tree.getRaiz().getDerecha().getDerecha().setPadre(tree.getRaiz().getDerecha());
         tree.getRaiz().getDerecha().getIzquierda().setPadre(tree.getRaiz().getDerecha());
         tree.getRaiz().getIzquierda().getDerecha().setPadre(tree.getRaiz().getIzquierda());
         tree.getRaiz().getIzquierda().getIzquierda().setPadre(tree.getRaiz().getIzquierda());
            
         System.out.println("");
            
         System.out.println(tree.getRaiz().getDerecha().getPadre().getValue());
         System.out.println(tree.getRaiz().getIzquierda().getPadre().getValue());
         System.out.println(tree.getRaiz().getDerecha().getDerecha().getPadre().getValue());
         System.out.println(tree.getRaiz().getDerecha().getIzquierda().getPadre().getValue());
         System.out.println(tree.getRaiz().getIzquierda().getDerecha().getPadre().getValue());
         System.out.println(tree.getRaiz().getIzquierda().getIzquierda().getPadre().getValue());
            
         System.out.println("");
         */
        /* System.out.println(tree2.getRaiz().getValue());
         System.out.println(tree2.getRaiz().getIzquierda().getValue());
         System.out.println(tree2.getRaiz().getIzquierda().getDerecha().getValue());
         System.out.println(tree2.getRaiz().getIzquierda().getIzquierda().getValue());
         */
    }

}
