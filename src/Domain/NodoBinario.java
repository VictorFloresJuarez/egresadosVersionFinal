/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *Clase del nodo binario
 * @author victo
 */
public class NodoBinario {

    protected Object dato; // Dato que almacena (varía dependiendo del árbol)
    protected NodoBinario izq; // Hijo izquierdo
    protected NodoBinario der; // Hijo derecho
    
    /**
     * Constructor de un nodo con hijo izquierdo y derecho
     * @param dato
     * @param izq
     * @param der 
     */
    public NodoBinario(Object dato, NodoBinario izq, NodoBinario der) { // Se crea un nodo con hijo izquierdo y derecho
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }
    
    /**
     * Constructor de un nodo sin hijo
     * @param dato 
     */
    public NodoBinario(Object dato) { // Se crea un nodo sin hijo 
        this(dato, null, null);
    }
    
    /**
     * Instanciar un objeto
     */
    public NodoBinario() { // Se instancia un objeto con todo nulo
        this(null);
    }

    /**
     * Obtener el dato que guarda el nodo
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }
    
    /**
     * Recorrer el nodo en posOrden
     */
    public void posOrden() {
        if (izq != null) {
            izq.posOrden();
        }
        if (der != null) {
            der.posOrden();
        }
        System.out.println(dato);//Raiz
    }
    
    /**
     * Recorrer el nodo en preOrden
     */
    public void preOrden() {
        System.out.println(dato);//Raiz    
        if (izq != null) {
            izq.preOrden();
        }
        if (der != null) {
            der.preOrden();
        }

    }
    
    /**
     * Recorrer el nodo en inOrden
     */
    public void inOrden() { //IRD
        if (izq != null) {
            izq.inOrden();
        }
        System.out.println(dato);//Raiz
        if (der != null) {
            der.inOrden();
        }
    }

    /**
     * Función para setear el dato del nodo
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * @return the izq
     */
    public NodoBinario getIzq() {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(NodoBinario izq) {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public NodoBinario getDer() {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(NodoBinario der) {
        this.der = der;
    }
}
