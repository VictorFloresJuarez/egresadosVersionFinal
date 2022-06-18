/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainList;

/**
 *Clase abstracta de una lista simplemente ligada
 * @author victo
 */
public abstract class Lista {

    protected Nodo inicio;
    protected Nodo ultimo;
    protected String nombre;
    
    
    public Lista() {
        this("lista");
    }
    
    /**
     * Constructor de la lista con el primer elemento
     * @param nombre 
     */
    public Lista(String nombre) {
        this.nombre = nombre;
        inicio = ultimo = null;
    }
    
    /**
     * Método abstracto para insertar al inicio de la lista
     * @param dato 
     */
    public abstract void insertaInicio(Object dato);
    
    /**
     * Método abstracto para insertar al final de la lista
     * @param dato 
     */
    public abstract void insertaFinal(Object dato);
    
    /**
     * Método abstracto para eliminar el inicio de la lista
     * @return 
     */
    public abstract Object eliminaInicio();
    
    /**
     * Método abstracto para eliminar el final de la lista
     * @return 
     */
    public abstract Object eliminaFinal();

    /**
     * Método para obtener el inicio de la lista
     * @return the inicio
     */
    public Nodo getInicio() {
        return inicio;
    }

    /**
     * Método para setear el inicio de la lista
     * @param inicio the inicio to set
     */
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    /**
     * Método para obtener el último elemento de la lista
     * @return the ultimo
     */
    public Nodo getUltimo() {
        return ultimo;
    }

    /**
     * Método para setear el último de la lista
     * @param ultimo the ultimo to set
     */
    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Método para obtener el nombre del elemento de la lista
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para setear el nombre de la lista
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para saber si la lista está vacía
     * @return 
     */
    public boolean vacio() {
        return inicio == null;
    }
    
    /**
     * Método para imprimir la lista
     */
    public void imprimir() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }
    }


}