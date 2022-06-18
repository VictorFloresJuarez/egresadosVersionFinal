/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainList;

/**
 * Clase de lista doble que extiende de la clase abstracta listaD
 *
 * @author victo
 */
public class ListaDoble extends ListaD {

    /**
     * Método para insertar al inicio de la lista
     *
     * @param dato
     */
    @Override
    public void insertaInicio(Object dato) {
        if (vacio()) {
            inicio = ultimo = new NodoDoble(dato);
        } else {
            NodoDoble nuevo = new NodoDoble(dato, inicio, null);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
    }

    /**
     * Método para insertar al final de la lista
     *
     * @param dato
     */
    @Override
    public void insertaFinal(Object dato) {
        if (vacio()) {
            inicio = ultimo = new NodoDoble(dato);
        } else {
            NodoDoble nuevo = new NodoDoble(dato, null, ultimo);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    /**
     * Método para eliminar el inicio de la lista
     *
     * @return
     */
    @Override
    public Object eliminaInicio() {
        Object eliminado = null;
        if (vacio()) {
            System.out.println("Lista vacía");
        } else {
            if (inicio == ultimo) {
                eliminado = inicio.getDato();
                inicio = ultimo = null;
            } else {
                eliminado = inicio.getDato();
                inicio = inicio.getSiguiente();
                inicio.setAnterior(null);
            }
        }
        return eliminado;
    }

    /**
     * Método para eliminar el final de la lista
     *
     * @return
     */
    @Override
    public Object eliminaFinal() {
        Object eliminado = null;
        if (vacio()) {
            System.out.println("Lista vacía");
        } else {
            if (inicio == ultimo) {
                eliminado = ultimo.getDato();
                inicio = ultimo = null;
            } else {
                eliminado = ultimo.getDato();
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
            }
        }
        return eliminado;
    }

    /**
     * Método para insertar de manera ordenada los datos
     *
     * @param dato
     */
    public void insertaOrdenado(int dato) {
        if (vacio()) {
            insertaInicio(dato);
        } else {
            if (inicio == ultimo) {
                if (dato < (Integer) inicio.getDato()) {
                    insertaInicio(dato);
                } else {
                    insertaFinal(dato);
                }
            } else {
                NodoDoble antes = null, despues = inicio;
                while (despues != null && dato > (Integer) despues.getDato()) {
                    antes = despues;
                    despues = despues.getSiguiente();
                }
                if (antes == null) {
                    insertaInicio(dato);
                } else if (despues == null) {
                    insertaFinal(dato);
                } else {
                    NodoDoble nuevo = new NodoDoble(dato, despues, antes);
                    antes.setSiguiente(nuevo);
                }
            }
        }
    }

}
