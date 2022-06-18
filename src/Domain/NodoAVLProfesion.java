/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import DomainList.ListaDoble;
import java.util.ArrayList;

/**
 *Clase del nodo para los árboles AVL de profesión
 * @author victo
 */
public class NodoAVLProfesion extends NodoBinario {

    protected int FE; // Factor de equilibrio
    protected NodoAVLProfesion padre;
    ListaDoble listad = new ListaDoble();
    
    /**
     * Constructor del nodo sin parámetros
     */
    public NodoAVLProfesion() {

    }
    
    /**
     * Constructor del primer elemento del nodo sin hijos
     * @param o 
     */
    public NodoAVLProfesion(Object o) {
        super(o);
    }
    
    /**
     * Constructor de un nodo con hijo izquierdo y derecho
     * @param o
     * @param indice
     * @param izquierda
     * @param derecha 
     */
    public NodoAVLProfesion(Object o, int indice, NodoAVLProfesion izquierda, NodoAVLProfesion derecha) {
        super(o, izquierda, derecha);
        this.listad.insertaFinal(indice);
    }
    
    /**
     * Constructor del nodo con hijos y padre
     * @param o
     * @param indice
     * @param izquierda
     * @param derecha
     * @param padre 
     */
    public NodoAVLProfesion(Object o, int indice, NodoAVLProfesion izquierda, NodoAVLProfesion derecha, NodoAVLProfesion padre) {
        super(o, izquierda, derecha);
        this.padre = padre;
        this.listad.insertaFinal(indice);
    }
    
    /**
     * Método para calcular la altura
     * @param a
     * @return 
     */
    public static int altura(NodoAVLProfesion a) {
        if (a == null) {
            return -1;
        } else {
            return 1
                    + Math.max(altura((NodoAVLProfesion) a.getIzq()), altura((NodoAVLProfesion) a.getDer()));
        }
    }
    
    /**
     * Método para recorrer el árbol en inOrden
     */
    public void inOrden() {
        if (izq != null) {
            ((NodoAVLProfesion) izq).inOrden();
        }
        System.out.println("\n" + dato + " Indices: ");//Raiz
        this.listad.imprimir();
        System.out.println("\n");
        if (der != null) {
            ((NodoAVLProfesion) der).inOrden();
        }
    }
    
    /**
     * Método para recorrer el árbol en preOrden
     */
    public void preOrden() {
        System.out.println("\n" + dato + " Indices: ");//Raiz
        this.listad.imprimir();
        System.out.println("\n");
        if (izq != null) {
            ((NodoAVLProfesion) izq).preOrden();
        }
        if (der != null) {
            ((NodoAVLProfesion) der).preOrden();
        }
    }
    
    /**
     * Método para recorrer el árbol en posOrden
     */
    public void posOrden() {
        if (izq != null) {
            ((NodoAVLProfesion) izq).posOrden();
        }
        if (der != null) {
            ((NodoAVLProfesion) der).posOrden();
        }
        System.out.println("\n" + dato + " Indices: ");//Raiz
        this.listad.imprimir();
        System.out.println("\n");
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
    public NodoAVLProfesion getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoAVLProfesion padre) {
        this.padre = padre;
    }

    /**
     *Función que retorna el la lista doble de índices deun nodo específico del árbol de profesiones
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
