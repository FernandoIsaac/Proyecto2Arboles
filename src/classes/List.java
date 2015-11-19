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
public class List {

    public List(Object value) {
        this.head = new Node(value);
    }

    public List() {
    }

    public void insert(int posicion, Object valor) {
        if (posicion > 0) {
            if (!head.hasNext()) {
                if (posicion == 1) {
                    head.setNext(new Node(valor));
                } else {
                    Node temp = head;
                    head.setValue(valor);
                    head.setNext(temp);
                }
                
                /*86cd-hz5u-tiyh*/
                
            } else {
                Node temp = head;
                int cont = 0;
                if (size() >= posicion) {
                    while (cont < posicion - 1) {
                        temp = temp.getNext();
                        cont++;
                    }
                    Node nuevo = new Node(valor);
                    if (temp.hasNext()) {
                        Node temp2 = temp.getNext();
                        nuevo.setNext(temp2);
                    }
                    temp.setNext(nuevo);
                }
            }
        } else if (posicion == 0) {
            if (head != null) {
                Node temp = head;
                setHead(new Node(valor));
                head.setNext(temp);
            } else {
                setHead(new Node(valor));
            }
        }
    }

    public int find(Object valor) {
        int contador = 0;
        Node temp = head;
        while (temp.hasNext()) {
            if (temp.getValue() == valor) {
                return contador;
            }
            temp = temp.getNext();
            contador++;
        }
        return -1;
    }

    public Node get(int posicion) {
        int contador = 0;
        Node temp = head;
        if (size() > posicion) {
            if (posicion == 0) {
                return head;
            }
            while (contador < posicion) {
                temp = temp.getNext();
                contador++;
            }
            return temp;
        }
        return new Node();
    }

    public void remove(int posicion) {
        if (size() > posicion) {
            if (posicion == 0) {
                setHead(head.getNext());
            } else if (posicion == 1) {
                Node temp = head;
                temp = temp.getNext();
                temp = temp.getNext();
                head.setNext(temp);
            } else {
                int contador = 0;
                Node temp = head;
                while (contador < posicion - 1) {
                    temp = temp.getNext();
                    contador++;
                }
                Node temp2 = temp.getNext();
                Node temp3 = temp2.getNext();
                temp.setNext(temp3);
            }
        }

    }

    public Node first() {
        return head;
    }

    public void concat(List lista) {
        Node temp = head;
        while (temp.hasNext()) {
            temp = temp.getNext();
        }
        temp.setNext(lista.first());
    }

    public void print() {
        if (head != null) {
            if (head.hasNext()) {
                System.out.print("[");
                Node temp = head;
                for (int i = 0; i < size(); i++) {
                    if (temp.hasNext()) {
                        System.out.print(temp.toString() + ",");
                        temp = temp.getNext();
                    } else {
                        System.out.print(temp.toString() + "]");
                    }
                }
            } else {
                System.out.println("[" + head.toString() + "]");
            }
        }
    }

    public int size() {
        int size = 0;
        if (head != null) {
            size++;
            Node temp = head;
            while (temp.hasNext()) {
                size++;
                temp = temp.getNext();
            }
        }
        return size;
    }

    public void pushback(Object value) {
        insert(size(), value);
        System.out.println("Pushback");
    }
    public void pushback(int value) {
        insert(size(), value);
        System.out.println("Pushback");
    }
    
    public void setHead(Node head) {
        this.head = head;
    }

    public Node Last() {
        return get(size() - 1);
    }

    public boolean hasHead() {
        if (this.head == null) {
            return false;
        } else {
            return true;
        }
    }
    public int TreeGetValue(int p, List list){
        Arbol arbol = (Arbol)list.get(p).getArbol();
        return arbol.getRaiz().getValue();
    }
    
    public Nodo TreeGetNodo(int p, List list){
        Arbol arbol = (Arbol)list.get(p).getValue();
        return arbol.getRaiz();
    }
    
    public Arbol Huffman(List frecuencias) {
        System.out.println("1");
        this.ordenar(frecuencias);
        System.out.println("2");
        Arbol TreeToReturn, temp;
        System.out.println("3");
        List ListaDeArboles = new List();
        System.out.println("4");
        for (int i = 0; i < frecuencias.size(); i++) {
            System.out.println("5");
            Arbol tree = new Arbol((int) frecuencias.get(i).getValue());
            System.out.println("6");
            ListaDeArboles.insert(i, tree);
            ListaDeArboles.get(i).setArbol(tree);
           System.out.println("7");
        }
        do {
            //temp = new Arbol(((int)ListaDeArboles.get(0).getValue() + (int) ListaDeArboles.get(1).getValue()));
            temp = new Arbol (TreeGetValue(0, ListaDeArboles)+ TreeGetValue(1, ListaDeArboles));
            //temp.addNodo((Nodo) ListaDeArboles.get(0).getValue());
            temp.addNodo(TreeGetNodo(0, ListaDeArboles));
            //temp.addNodo((Nodo) ListaDeArboles.get(1).getValue());
            temp.addNodo(TreeGetNodo(0, ListaDeArboles));
            ListaDeArboles.remove(0);
            ListaDeArboles.remove(1);
            ListaDeArboles.pushback(temp);
            this.ordenarTrees(ListaDeArboles);
           // System.out.println("Esta papada es infinita");
        } while (ListaDeArboles.size() > 1);
        TreeToReturn = temp;
        return TreeToReturn;
    }
    
    public int GetValueNodo(int p, List list){
        Nodo nodo =(Nodo)list.get(p).getValue();
        return nodo.getValue();
    }
    
    public void ordenar(List ListToOrder) {
        for (int i = 0; i < ListToOrder.size(); i++) {
            System.out.println("ordenar i");
            for (int j = 0; j < ListToOrder.size() - 1; j++) {
                System.out.println("ordenar j");
                if (/*(int)*/ ListToOrder.get(j).getValor() > /*(int)*/ ListToOrder.get(j + 1).getValor()) {
                    int mayor = (int) ListToOrder.get(j).getValue();
                    System.out.println("if ordenar");
                    ListToOrder.remove(j);
                    ListToOrder.insert(j, ListToOrder.get(j + 1));
                    ListToOrder.remove(j+1);
                    ListToOrder.insert(j + 1, mayor);
                }
            }
        }
    }
    
    public void ordenarTrees(List ListToOrder){
        for (int i = 0; i < ListToOrder.size(); i++) {
            System.out.println("ordenarTrees i");
            for (int j = 0; j < ListToOrder.size() - 1; j++) {
                System.out.println("ordenarTrees j");
                if (TreeGetValue(j,ListToOrder)>TreeGetValue(j+1,ListToOrder)){
                    System.out.println("if OrdenarTrees");
                    //int mayor = TreeGetValue(j,ListToOrder);
                    Arbol mayor = (Arbol)ListToOrder.get(j).getValue();
                    ListToOrder.remove(j);
                    ListToOrder.insert(j, ListToOrder.get(j + 1));
                    ListToOrder.remove(j+1);
                    ListToOrder.insert(j + 1, mayor);
                }
            }
        }
    }
    
    private Node head;

}
