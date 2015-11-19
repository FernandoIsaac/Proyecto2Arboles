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
public class Arbol {
    private Nodo raiz;
    
    
    public Arbol(int value){
        this.raiz = new Nodo(value);
    }
    
    public Arbol(Nodo raiz){
        this.raiz = raiz;
    }
    
    public Nodo getRaiz(){
        return raiz;
    }
    
    public void setRaiz(Nodo raiz){
        this.raiz = raiz;
    }
    
    private void addNodo(Nodo nodo, Nodo raiz){
        if(raiz == null){
            this.setRaiz(nodo);
        }
        else{
            if(nodo.getValue()<=raiz.getValue()){
                if(raiz.getIzquierda()==null){
                    raiz.setIzquierda(nodo);
                }
                else{
                    addNodo(nodo, raiz.getIzquierda());
                }
            }
            else{
                if(raiz.getDerecha()==null){
                    raiz.setDerecha(nodo);
                }
                else{
                    addNodo(nodo, raiz.getDerecha());
                }
            }
        }
    }
    public void addNodo(Nodo nodo){
        this.addNodo(nodo, this.raiz);
    }
    public boolean removeNodo(Nodo nodo){
        boolean TieneDerecho = nodo.getDerecha() != null? true:false;
        boolean TieneIzquierda = nodo.getIzquierda() != null? true:false;
        
        if(!TieneDerecho && !TieneIzquierda){
            return removeNodoCaso1(nodo);
        }
        if(TieneDerecho && !TieneIzquierda){
            return removeNodoCaso2(nodo);
        }
        if(!TieneDerecho && TieneIzquierda){
            return removeNodoCaso3(nodo);
        }
        return false;
    }
    private boolean removeNodoCaso1(Nodo nodo){
        //SE QUIERE ELIMINAR SOLAMENTE UN NODO SIN HIJOS
        Nodo Izquierdo = nodo.getPadre().getIzquierda();
        Nodo Derecho = nodo.getPadre().getDerecha();
        
        if(Izquierdo == nodo){
            nodo.getPadre().setIzquierda(null);
            return true;
        }
        if(Derecho == nodo){
            nodo.getPadre().setDerecha(null);
            return true;
        }
        return false;
    }
    private boolean removeNodoCaso2(Nodo nodo){
    //SE QUIERE ELIMINAR UN NODO CON UN SUBARBOL HIJO
        Nodo Izquierdo = nodo.getPadre().getIzquierda();
        Nodo Derecho = nodo.getPadre().getDerecha();
        
        Nodo HijoActual = nodo.getIzquierda() != null ?
                nodo.getIzquierda() : nodo.getDerecha();
        
        if(Izquierdo == nodo){
            nodo.getPadre().setIzquierda(HijoActual);
            HijoActual.setPadre(nodo.getPadre());
            nodo.setDerecha(null);
            nodo.setIzquierda(null);
            return true;
        }
        
        if(Derecho == nodo){
            nodo.getPadre().setDerecha(HijoActual);
            HijoActual.setPadre(nodo.getPadre());
            nodo.setDerecha(null);
            nodo.setIzquierda(null);
            return true;
        }
        return false;
        
    }
    private boolean removeNodoCaso3(Nodo nodo){
     //SE QUIERE ELIMINAR DOS SUBARBOLES HIJOS
        Nodo NodoMasALaIzquierda = recorrerIzquierda(nodo.getDerecha());
        if(NodoMasALaIzquierda != null){
            nodo.setValue(NodoMasALaIzquierda.getValue());
            removeNodo(NodoMasALaIzquierda);
            return true;
        }
        return false;
    }
    private Nodo recorrerIzquierda(Nodo nodo){
        if(nodo.getIzquierda()!=null){
            return recorrerIzquierda(nodo.getIzquierda());
        }
        return nodo;
    }
    
    
    
}
