/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainList;

import MainPackage.Egresados;

/**
 * Clase abstracta de la lista doble que extiende de lista
 *
 * @author victo
 */
public abstract class ListaD extends Lista {

    protected NodoDoble inicio;
    protected NodoDoble ultimo;

    /**
     * Método para saber si la lista está vacía
     *
     * @return
     */
    public boolean vacio() {
        return inicio == null;
    }

    /**
     * Método para imprimir la lista
     */
    public void imprimir() {
        super.setInicio(inicio);
        super.imprimir();
    }

    /**
     * Método para imprimir al revés la lista
     */
    public void imprimirAlReves() {
        if (!vacio()) {
            NodoDoble actual = ultimo;
            while (actual != null) {
                System.out.print("<-" + actual.getDato());
                actual = actual.getAnterior();
            }
        }
    }

    //Esto lo use solo para probar que se hayan capturado todos los archivos del csv en la lista
    public void MostrarEgresadosConsola() {
        NodoDoble actual = inicio;
        while (actual != null) {
            if (actual.getDato() instanceof Egresados) {
                Egresados egresado = (Egresados) actual.getDato();
                System.out.println(egresado.getTexto());
            }
            actual = actual.getSiguiente();
        }
    }

    /**
     * Método para obtener el inicio de la lista doble
     *
     * @return
     */
    public NodoDoble getInicioListaDoble() {
        return inicio;
    }

    /**
     * Método para obtener el último de la lista doble
     *
     * @return
     */
    public NodoDoble getUltimoListaDoble() {
        return ultimo;
    }
}
