/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainList;

/**
 * Clase de un nodo de una lista simplemente ligada
 *
 * @author victo
 */
public class Nodo {

    protected Object dato;
    protected Nodo siguiente;

    /**
     * Constructor de la clase nodo
     */
    public Nodo() {
    }

    /**
     * Constructor de la clase nodo con dato
     *
     * @param dato
     */
    public Nodo(Object dato) {
        this.dato = dato;
        siguiente = null;
    }

    /**
     * Constructor de un nodo con un elemento siguiente
     *
     * @param dato
     * @param siguiente
     */
    public Nodo(Object dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
