/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import DomainList.ListaDoble;
import java.util.ArrayList;

/**
 * Clase para árboles de nombre
 *
 * @author victo
 */
public class ArbolAVL {

    protected NodoAVL raiz; // Raiz del árbol
    protected ListaDoble todosLosIndices = new ListaDoble();

    /**
     * Constructor del árbol sin raiz
     */
    public ArbolAVL() { // Se crea el árbol sin raiz
        raiz = null;
    }

    /**
     * Constructor del árbol solo con raiz
     *
     * @param o
     */
    public ArbolAVL(Object o) {
        raiz = new NodoAVL(o);
    }

    /**
     * Método para setear la raiz
     *
     * @param o
     * @param indice
     */
    public void setearRaiz(Object o, Object indice) { // Se crea la raiz
        raiz = new NodoAVL(o);
        raiz.agregarIndice((int) indice);
        todosLosIndices.insertaFinal((int) indice);
    }

    /**
     * Método para recorrer en inOrden
     */
    public void inOrden() { // Recorrer árbol en inOrden
        if (raiz != null) {
            raiz.inOrden();
        }
    }

    /**
     * Método para recorrer en preOrden
     */
    public void preOrden() { // Recorrer árbol en preOrden
        if (raiz != null) {
            raiz.preOrden();
        }
    }

    /**
     * Método para recorrer en posOrden
     */
    public void posOrden() { // Recorrer árbol en posOrden
        if (raiz != null) {
            raiz.posOrden();
        }
    }

    /**
     * Método que retorna una lista doble con todos los índices
     *
     * @return todosLosIndices
     */
    public ListaDoble getListaDobleTotal() {
        return todosLosIndices;
    }

    /**
     * Esta función sirve para insertar elementos al árbol AVL de nombres
     *
     * @param o
     * @param indice
     */
    public void insertar(Object o, Object indice) {
        insertarOrdenado(raiz, o, indice);
        todosLosIndices.insertaFinal((int) indice);
    }

    /**
     * Método para insetar elementos de forma ordenada al árbol de nombres
     *
     * @param n
     * @param o
     * @param indice
     */
    private void insertarOrdenado(NodoAVL n, Object o, Object indice) {
        String cadenaActual = (String) n.getDato();
        String cadenaIngresar = (String) o;
        int esAnterior = cadenaIngresar.compareTo(cadenaActual);
        if (esAnterior < 0) {
            if (n.getIzq() == null) {
                n.setIzq(new NodoAVL(o, (int) indice, null, null, n));
                recalcularFE(n);
            } else {
                insertarOrdenado((NodoAVL) n.getIzq(), o, (int) indice);
            }
        } else {
            if (esAnterior > 0) {
                if (n.getDer() == null) {
                    n.setDer(new NodoAVL(o, (int) indice, null, null, n));
                    recalcularFE(n);
                } else {
                    insertarOrdenado((NodoAVL) n.getDer(), o, (int) indice);
                }
            }
        }
    }

    /**
     * Esta función sirve para buscar un elemento en el árbol
     *
     * @param o
     */
    public void buscar(Object o) {
        buscarSiExiste(raiz, o);
    }

    /**
     * Función que busca si un elemento existe
     *
     * @param n
     * @param o
     */
    private void buscarSiExiste(NodoAVL n, Object o) {
        String cadenaActual = (String) n.getDato();
        String cadenaIngresar = (String) o;
        int esAnterior = cadenaIngresar.compareTo(cadenaActual);
        if (esAnterior < 0) {
            if ((NodoAVL) n.getIzq() != null) {
                buscarSiExiste((NodoAVL) n.getIzq(), o);
            } else {
                System.out.println("El nombre ingresado no existe");
            }
        } else {
            if (esAnterior > 0) {
                if ((NodoAVL) n.getDer() != null) {
                    buscarSiExiste((NodoAVL) n.getDer(), o);
                } else {
                    System.out.println("El nombre ingresado no existe");
                }
            } else {
                System.out.println("El egresado " + n.getDato() + " existe");
                System.out.println("Y tiene el índice: ");
                ListaDoble aux = n.getListaDoble();
                aux.imprimir();
            }
        }
    }

    /**
     * Función que recibe un nombre a buscar y retorna el índice que tiene
     *
     * @param o
     * @return indices
     */
    public ListaDoble obtenerListaDeNombre(Object o) {
        ListaDoble indices = new ListaDoble();
        indices = obtenerListaExisteDoble(raiz, o);
        return indices;
    }

    /**
     * Función que recibe un nodo del árbol y el nombre a buscar y retorna el
     * índice en forma de lista si es que lo encuentra
     *
     * @param n
     * @param o
     * @return indices
     */
    private ListaDoble obtenerListaExisteDoble(NodoAVL n, Object o) {
        ListaDoble indices = new ListaDoble();
        String profesionActual = (String) n.getDato();
        String profesionABuscar = (String) o;
        int esAnterior = profesionABuscar.compareTo(profesionActual);
        if (esAnterior < 0) { // Si el nombre de la profesión es menor
            if ((NodoAVL) n.getIzq() != null) {
                indices = obtenerListaExisteDoble((NodoAVL) n.getIzq(), o);
            } else {
                indices = null;
            }
        } else {
            if (esAnterior > 0) {
                if ((NodoAVL) n.getDer() != null) {
                    indices = obtenerListaExisteDoble((NodoAVL) n.getDer(), o);
                } else {
                    indices = null;
                }
            } else {
                indices = (ListaDoble) n.getListaDoble();
            }
        }
        return indices;
    }

    /**
     * Función para recalcular el factor de equilibrio
     *
     * @param nodo
     */
    public void recalcularFE(NodoAVL nodo) {
        if (nodo != null) {
            nodo.setFE(
                    NodoAVL.altura((NodoAVL) nodo.getDer())
                    - NodoAVL.altura((NodoAVL) nodo.getIzq())
            );
            if (nodo.getFE() == 2 || nodo.getFE() == -2) {
                balancear(nodo);
            } else {
                recalcularFE(nodo.getPadre());
            }
        }
    }

    /**
     * Función para balancear el árbol
     *
     * @param nodo
     */
    public void balancear(NodoAVL nodo) {
        int feActual = nodo.getFE();
        if (feActual == 2) {
            switch (((NodoAVL) nodo.getDer()).getFE()) {
                case 0:
                case 1:
                    rotacionDD(nodo);
                    //System.out.println("Aplicando rotación DD..");
                    break;
                case -1:
                    rotacionDI(nodo);
                    //System.out.println("Aplicando rotación DI..");
                    break;
            }
        } else {
            switch (((NodoAVL) nodo.getIzq()).getFE()) {
                case 0:
                case -1:
                    rotacionII(nodo);
                    //System.out.println("Aplicando rotación II..");
                    break;
                case 1:
                    rotacionID(nodo);
                    //System.out.println("Aplicando rotación ID..");
                    break;
            }
        }
    }

    public void rotacionII(NodoAVL nodo) {
        //Establecer los apuntadores..
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL) P.getIzq();
        NodoAVL B = (NodoAVL) Q.getDer();

        //Ajustar hijos
        if (Padre != null) {
            if (Padre.getDer() == P) {
                Padre.setDer(Q);
            } else {
                Padre.setIzq(Q);
            }
        } else {
            raiz = Q;
        }
        //Reconstruir el arbol
        P.setIzq(B);
        Q.setDer(P);

        //Reasignar Padres
        P.setPadre(Q);
        if (B != null) {
            B.setPadre(P);
        }
        Q.setPadre(Padre);

        //Ajustar los valores de los FE
        P.setFE(0);
        Q.setFE(0);
    }

    public void rotacionDD(NodoAVL nodo) {
        //Establecer los apuntadores..
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL) P.getDer();
        NodoAVL B = (NodoAVL) Q.getIzq();

        //Ajustar hijos
        if (Padre != null) {
            if (Padre.getIzq() == P) {
                Padre.setIzq(Q);
            } else {
                Padre.setDer(Q);
            }
        } else {
            raiz = Q;
        }
        //Reconstruir el arbol
        P.setDer(B);
        Q.setIzq(P);

        //Reasignar Padres
        P.setPadre(Q);
        if (B != null) {
            B.setPadre(P);
        }
        Q.setPadre(Padre);

        //Ajustar los valores de los FE
        P.setFE(0);
        Q.setFE(0);
    }

    public void rotacionID(NodoAVL nodo) {
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL) P.getIzq();
        NodoAVL R = (NodoAVL) Q.getDer();
        NodoAVL B = (NodoAVL) R.getIzq();
        NodoAVL C = (NodoAVL) R.getDer();

        if (Padre != null) {
            if (Padre.getDer() == nodo) {
                Padre.setDer(R);
            } else {
                Padre.setIzq(R);
            }
        } else {
            raiz = R;
        }
        //Reconstrucción del árbol
        Q.setDer(B);
        P.setIzq(C);
        R.setIzq(Q);
        R.setDer(P);
        //Reasignación de padres
        R.setPadre(Padre);
        P.setPadre(R);
        Q.setPadre(R);
        if (B != null) {
            B.setPadre(Q);
        }
        if (C != null) {
            C.setPadre(P);
        }
        //Ajusta los valores de los factores de equilibrio 
        switch (R.getFE()) {
            case -1 -> {
                Q.setFE(0);
                P.setFE(1);
            }
            case 0 -> {
                Q.setFE(0);
                P.setFE(0);
            }
            case 1 -> {
                Q.setFE(-1);
                P.setFE(0);
            }
        }
        R.setFE(0);
    }

    public void rotacionDI(NodoAVL nodo) {
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL) P.getDer();
        NodoAVL R = (NodoAVL) Q.getIzq();
        NodoAVL B = (NodoAVL) R.getDer();
        NodoAVL C = (NodoAVL) R.getIzq();

        if (Padre != null) {
            if (Padre.getIzq() == nodo) {
                Padre.setIzq(R);
            } else {
                Padre.setDer(R);
            }
        } else {
            raiz = R;
        }
        //Reconstrucción del árbol
        Q.setIzq(B);
        P.setDer(C);
        R.setDer(Q);
        R.setIzq(P);
        //Reasignación de padres
        R.setPadre(Padre);
        P.setPadre(R);
        Q.setPadre(R);
        if (B != null) {
            B.setPadre(Q);
        }
        if (C != null) {
            C.setPadre(P);
        }
        //Ajusta los valores de los factores de equilibrio 
        switch (R.getFE()) {
            case -1 -> {
                Q.setFE(0);
                P.setFE(1);
            }
            case 0 -> {
                Q.setFE(0);
                P.setFE(0);
            }
            case 1 -> {
                Q.setFE(-1);
                P.setFE(0);
            }
        }
        R.setFE(0);
    }
}
