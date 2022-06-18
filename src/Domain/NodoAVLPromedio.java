/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import DomainList.ListaDoble;
import java.util.ArrayList;

/**
 *Clase del nodo para los árboles AVL de promedio
 * @author victo
 */
public class NodoAVLPromedio extends NodoBinario {

    protected int FE; // Factor de equilibrio
    protected NodoAVLPromedio padre;
    ListaDoble listad = new ListaDoble();
    
    /**
     * Constructor del nodo sin parámetros 
     */
    public NodoAVLPromedio() {
    }
    
    /**
     * Constructor del primer elemento del nodo sin hijos
     * @param o 
     */
    public NodoAVLPromedio(Object o) {
        super(o);
    }
    
    /**
     * Constructor de un nodo con hijo izq y der
     * @param o
     * @param indice
     * @param izquierda
     * @param derecha 
     */
    public NodoAVLPromedio(Object o, int indice, NodoAVLPromedio izquierda, NodoAVLPromedio derecha) {
        super(o, izquierda, derecha);
        this.listad.insertaFinal(indice);
    }
    
    /**
     * Constructor de un nodo con hijos y padre
     * @param o
     * @param indice
     * @param izquierda
     * @param derecha
     * @param padre 
     */
    public NodoAVLPromedio(Object o, int indice, NodoAVLPromedio izquierda, NodoAVLPromedio derecha, NodoAVLPromedio padre) {
        super(o, izquierda, derecha);
        this.padre = padre;
        this.listad.insertaFinal(indice);
    }
    
    /**
     * Método para calcular la altura
     * @param a
     * @return 
     */
    public static int altura(NodoAVLPromedio a) {
        if (a == null) {
            return -1;
        } else {
            return 1
                    + Math.max(altura((NodoAVLPromedio) a.getIzq()), altura((NodoAVLPromedio) a.getDer()));
        }
    }
    
    /**
     * Método para recorrer el árbol en inOrden
     */
    public void inOrden() {
        if (izq != null) {
            ((NodoAVLPromedio) izq).inOrden();
        }
        System.out.println("\n" + dato + " Indices: ");//Raiz
        this.listad.imprimir();
        System.out.println("\n");
        if (der != null) {
            ((NodoAVLPromedio) der).inOrden();
        }
    }
    
    /**
     * Método para recorrer el árbol en preOrden
     */
    public void preOrden() {
        System.out.println("\n" + dato + " Indices: ");//Raiz
        this.listad.imprimir();
        System.out.println("\n");
        this.listad.imprimir();
        if (izq != null) {
            ((NodoAVLPromedio) izq).preOrden();
        }
        if (der != null) {
            ((NodoAVLPromedio) der).preOrden();
        }
    }
    
    /**
     * Método para recorrer el árbol en posOrden
     */
    public void posOrden() {
        if (izq != null) {
            ((NodoAVLPromedio) izq).posOrden();
        }
        if (der != null) {
            ((NodoAVLPromedio) der).posOrden();
        }
        System.out.println("\n" + dato + " Indices: ");//Raiz
        this.listad.imprimir();
        System.out.println("\n");
        this.listad.imprimir();
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
    public NodoAVLPromedio getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoAVLPromedio padre) {
        this.padre = padre;
    }

    /**
     *Función que retorna el la lista doble de índices deun nodo específico del árbol de promedios
     * @return the listad
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