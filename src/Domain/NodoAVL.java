/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import DomainList.ListaDoble;

/**
 *Clase del nodo para los árboles AVL de nombre
 * @author victo
 */
public class NodoAVL extends NodoBinario{

    protected int FE; // Factor de equilibrio
    protected NodoAVL padre;
    ListaDoble listad = new ListaDoble();
    
    /**
     * Constructor del nodo sin parámetros 
     */
    public NodoAVL() {
    }
    
    /**
     * Constructor del primer elemento del nodo sin hijos
     * @param o 
     */
    public NodoAVL(Object o) {
        super(o);
    }
    
    /**
     * Constructor de un nodo con hijo izquierdo y derecho
     * @param o
     * @param indice
     * @param izquierda
     * @param derecha 
     */
    public NodoAVL(Object o, Object indice,NodoAVL izquierda, NodoAVL derecha) {
        super(o, izquierda, derecha);
        this.listad.insertaFinal((int) indice);
    }
    
    /**
     * Constructor del nodo con hijos y padre
     * @param o
     * @param indice
     * @param izquierda
     * @param derecha
     * @param padre 
     */
    public NodoAVL(Object o, Object indice,NodoAVL izquierda, NodoAVL derecha, NodoAVL padre) {
        super(o, izquierda, derecha);
        this.padre = padre;
        this.listad.insertaFinal(indice);
    }
    
    /**
     * Método para calcular la altura
     * @param a
     * @return 
     */
    public static int altura(NodoAVL a) {
        if (a == null) {
            return -1;
        } else {
            return 1
                    + Math.max(altura((NodoAVL) a.getIzq()), altura((NodoAVL) a.getDer()));
        }
    }
    
    /**
     * Método para recorrer el árbol en inOrden
     */
    public void inOrden() {
        if (izq != null) {
            ((NodoAVL) izq).inOrden();
        }
        System.out.println(dato);//Raiz
        if (der != null) {
            ((NodoAVL) der).inOrden();
        }
    }

    /**
     * Método para recorrer el árbol en preOrden
     */
    public void preOrden() {
        System.out.println(dato);//Raiz
        if (izq != null) {
            ((NodoAVL) izq).preOrden();
        }
        if (der != null) {
            ((NodoAVL) der).preOrden();
        }
    }
    
    /**
     * Método para recorrer el árbol en posOrden
     */
    public void posOrden() {
        if (izq != null) {
            ((NodoAVL) izq).posOrden();
        }
        if (der != null) {
            ((NodoAVL) der).posOrden();
        }
        System.out.println(dato);//Raiz
    }

    /**
     * @return the FE
     */
    public int getFE() {
        return FE;
    }

    /**
     * @param FE the FE to set
     */
    public void setFE(int FE) {
        this.FE = FE;
    }

    /**
     * @return the padre
     */
    public NodoAVL getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoAVL padre) {
        this.padre = padre;
    }
    
    /**
     * Función que retorna el la lista doble de índices deun nodo específico del árbol de nombres
     * @return listad
     */
    public ListaDoble getListaDoble() {
        return this.listad;
    }
    
    /**
     * Función para agregar un elemento a la lista de un nodo
     * @param indice 
     */
    public void agregarIndice(int indice) {
        this.listad.insertaFinal(indice);
    }
}