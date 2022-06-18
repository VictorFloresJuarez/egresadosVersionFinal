/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import DomainList.ListaDoble;
import java.util.ArrayList;

/**
 *Clase del árbol AVL de promedio
 * @author victo
 */
public class ArbolAVLPromedio {

    protected NodoAVLPromedio raiz; // Raiz del árbol
    protected ListaDoble todosIndices = new ListaDoble();
    
    /**
     * Constructor del árbol de promedio sin raiz
     */
    public ArbolAVLPromedio() { // Se crea el árbol sin raiz
        raiz = null;
    }
    
    /**
     * Función para obtener todos los índices que tiene este árbol
     * @return todosIndices
     */
    public ListaDoble getTodosIndices() {
        return todosIndices;
    }
    
    /**
     * Función para setear la raiz del árbol
     * @param o
     * @param indice 
     */
    public void setearRaiz(Object o, Object indice) {
        raiz = new NodoAVLPromedio(o);
        raiz.agregarIndice((int) indice);
        todosIndices.insertaFinal((int) indice);
    }
    
    /**
     * Constructor del árbol solo con la raiz
     * @param o 
     */
    public ArbolAVLPromedio(Object o) { // Se crea el árbol con la raíz
        raiz = new NodoAVLPromedio(o);
    }
    
    /**
     * Método para recorrer el árbol en inOrden
     */
    public void inOrden() { // Recorrer árbol en inOrden
        if (raiz != null) {
            raiz.inOrden();
        }
    }
    
    /**
     * Método para recorrer el árbol en preOrden
     */
    public void preOrden() { // Recorrer árbol en preOrden
        if (raiz != null) {
            raiz.preOrden();
        }
    }
    
    /**
     * Método para recorrer el árbol en posOrden
     */
    public void posOrden() { // Recorrer árbol en posOrden
        if (raiz != null) {
            raiz.posOrden();
        }
    }
    
    /**
     * Método para insertar a partir del segundo elemento al árbol de promedio
     * @param promedio
     * @param indice 
     */
    public void insertar(Object promedio, Object indice) { //Insertar nuevo elemento en el árbol
        insertarOrdenado(raiz, promedio, indice);
        todosIndices.insertaFinal((int) indice);
    }
    
    /**
     * Método para insertar de forma ordenada un elemento al árbol
     * @param n
     * @param promedio
     * @param indice 
     */
    private void insertarOrdenado(NodoAVLPromedio n, Object promedio, Object indice) {
        int promedioActual = (int) n.getDato();
        int promedioPorIngresar = (int) promedio;
        if (promedioPorIngresar < promedioActual) {
            if (n.getIzq() == null) {
                n.setIzq(new NodoAVLPromedio((int) promedio, (int) indice, null, null, n));
                recalcularFE(n);
            } else {
                insertarOrdenado((NodoAVLPromedio) n.getIzq(), promedio, (int) indice);
            }
        } else {
            if (promedioPorIngresar > promedioActual) {
                if (n.getDer() == null) {
                    n.setDer(new NodoAVLPromedio((int) promedio, (int) indice, null, null, n));
                    recalcularFE(n);
                } else {
                    insertarOrdenado((NodoAVLPromedio) n.getDer(), (int) promedio, (int) indice);
                }
            } else { // Si son iguales
                n.agregarIndice((int) indice);
            }
        }
    }
    
    /**
     * Método para buscar un elemento en el árbol de promedio
     * @param o 
     */
    public void buscar(Object o) { //Buscar un elemento en particular (lo imprime si lo encuentra)
        buscarSiExiste(raiz, o);
    }
    
    /**
     * Método local de la clase para ver si existe el promeido en alguno de los nodos del árbol
     * @param n
     * @param o 
     */
    private void buscarSiExiste(NodoAVLPromedio n, Object o) {
        int promedioActual = (int) n.getDato();
        int promedioPorBuscar = (int) o;
        if (promedioPorBuscar < promedioActual) { // Si el nombre de la profesión es menor
            if ((NodoAVLPromedio) n.getIzq() != null) { // Si el elemento a su izquierda no es nulo entonces hay otro
                buscarSiExiste((NodoAVLPromedio) n.getIzq(), o);
            } else { // No hay ningún elemento a su izquierda por lo tanto no existe
                System.out.println("Ningún egresado tiene ese promedio");
            }
        } else {
            if (promedioPorBuscar > promedioActual) {
                if ((NodoAVLPromedio) n.getDer() != null) {
                    buscarSiExiste((NodoAVLPromedio) n.getDer(), o);
                } else {
                    System.out.println("Ningún egresado tiene ese promedio");
                }
            } else {
                System.out.println("El promedio " + n.getDato() + " la poseen los egresados: " + n.getListaDoble());
            }
        }
    }
    
    /**
     * Método que recibe como parámetro un promedio y retorna una lista con los índices del nodo de dicho promedio
     * @param o
     * @return indices
     */
    public ListaDoble obtenerListaDePromedio(Object o) { //Obtener los índices de un elemento en particular (si es que lo encuentra)
        ListaDoble indices = new ListaDoble();
        indices = obtenerListaExisteDoble(raiz, o);
        return indices;
    }
    
    /**
     * Método local a la clase que retorna la lista de los índices. Recibe como parámetros el nodo en ese momento y el promedio a buscar
     * @param n
     * @param o
     * @return indices
     */
    private ListaDoble obtenerListaExisteDoble(NodoAVLPromedio n, Object o) {
        ListaDoble indices = new ListaDoble();
        int promedioActual = (int) n.getDato();
        int promedioPorBuscar = (int) o;
        if (promedioPorBuscar < promedioActual) {
            if ((NodoAVLPromedio) n.getIzq() != null) {
                indices = obtenerListaExisteDoble((NodoAVLPromedio) n.getIzq(), o);
            } else {
                indices = null;
            }
        } else {
            if (promedioPorBuscar > promedioActual) {
                if ((NodoAVLPromedio) n.getDer() != null) {
                    indices = obtenerListaExisteDoble((NodoAVLPromedio) n.getDer(), o);
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
     * Función para recalcular los factores de equilibrio
     * @param nodo 
     */
    public void recalcularFE(NodoAVLPromedio nodo) {
        if (nodo != null) {
            nodo.setFE(
                    NodoAVLPromedio.altura((NodoAVLPromedio) nodo.getDer())
                    - NodoAVLPromedio.altura((NodoAVLPromedio) nodo.getIzq())
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
     * @param nodo 
     */
    public void balancear(NodoAVLPromedio nodo) {
        int feActual = nodo.getFE();
        if (feActual == 2) {
            switch (((NodoAVLPromedio) nodo.getDer()).getFE()) {
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
            switch (((NodoAVLPromedio) nodo.getIzq()).getFE()) {
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

    public void rotacionII(NodoAVLPromedio nodo) {
        //Establecer los apuntadores..
        NodoAVLPromedio Padre = nodo.getPadre();
        NodoAVLPromedio P = nodo;
        NodoAVLPromedio Q = (NodoAVLPromedio) P.getIzq();
        NodoAVLPromedio B = (NodoAVLPromedio) Q.getDer();

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

    public void rotacionDD(NodoAVLPromedio nodo) {
        //Establecer los apuntadores..
        NodoAVLPromedio Padre = nodo.getPadre();
        NodoAVLPromedio P = nodo;
        NodoAVLPromedio Q = (NodoAVLPromedio) P.getDer();
        NodoAVLPromedio B = (NodoAVLPromedio) Q.getIzq();

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

    public void rotacionID(NodoAVLPromedio nodo) {
        NodoAVLPromedio Padre = nodo.getPadre();
        NodoAVLPromedio P = nodo;
        NodoAVLPromedio Q = (NodoAVLPromedio) P.getIzq();
        NodoAVLPromedio R = (NodoAVLPromedio) Q.getDer();
        NodoAVLPromedio B = (NodoAVLPromedio) R.getIzq();
        NodoAVLPromedio C = (NodoAVLPromedio) R.getDer();

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

    public void rotacionDI(NodoAVLPromedio nodo) {
        NodoAVLPromedio Padre = nodo.getPadre();
        NodoAVLPromedio P = nodo;
        NodoAVLPromedio Q = (NodoAVLPromedio) P.getDer();
        NodoAVLPromedio R = (NodoAVLPromedio) Q.getIzq();
        NodoAVLPromedio B = (NodoAVLPromedio) R.getDer();
        NodoAVLPromedio C = (NodoAVLPromedio) R.getIzq();

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
