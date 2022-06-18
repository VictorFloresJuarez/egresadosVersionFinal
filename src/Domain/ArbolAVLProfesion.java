/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import DomainList.ListaDoble;
import java.util.ArrayList;

/**
 *Clase para los árboles de profesión
 * @author victo
 */
public class ArbolAVLProfesion {

    protected NodoAVLProfesion raiz; // Raiz del árbol
    protected ListaDoble todosIndices = new ListaDoble();
    
    /**
     * Constructor del árbol de profesión sin raiz
     */
    public ArbolAVLProfesion() { // Se crea el árbol sin raiz
        raiz = null;
    }
    
    /**
     * Constructor del árbol de profesión con solo la raiz
     * @param o 
     */
    public ArbolAVLProfesion(Object o) { // Se crea el árbol con la raíz
        raiz = new NodoAVLProfesion(o);
    }
    
    /**
     * Función para setear el primer elemento que entra al árbol (la raiz), recibe como parámetros la profesión a ingresar y el índice del egresado con esa profesión
     * @param o
     * @param indice 
     */
    public void setearRaiz(Object o, Object indice) {
        raiz = new NodoAVLProfesion(o);
        raiz.agregarIndice((int) indice);
        todosIndices.insertaFinal((int) indice);
    }
    
    /**
     * Función para recorrer el árbol en inOrden
     */
    public void inOrden() { // Recorrer árbol en inOrden
        if (raiz != null) {
            raiz.inOrden();
        }
    }
    
    /**
     * Función para recorrer el árbol en preOrden
     */
    public void preOrden() { // Recorrer árbol en preOrden
        if (raiz != null) {
            raiz.preOrden();
        }
    }
    
    /**
     * Función para recorrer el árbol en posOrden
     */
    public void posOrden() { // Recorrer árbol en posOrden
        if (raiz != null) {
            raiz.posOrden();
        }
    }
    
    /**
     * Función para insertar a partir del segundo elemento a insertar en el árbol. Recibe como parámetro la profesión y el índice del elemento a ingresar
     * @param profesion
     * @param indice 
     */
    public void insertar(Object profesion, Object indice) {
        insertarOrdenado(raiz, profesion, indice);
        todosIndices.insertaFinal((int) indice);
    }
    
    /**
     * Función local para ingresar de manera ordenada el nuevo egresado. Recibe como parámetro el nodo del árbol en el momento de la llamada, la profesión a ingresar y el índice del elemento
     * @param n
     * @param profesion
     * @param indice 
     */
    private void insertarOrdenado(NodoAVLProfesion n, Object profesion, Object indice) {
        String profesionActual = (String) n.getDato();
        String profesionPorIngresar = (String) profesion;
        int esAnterior = profesionActual.compareTo(profesionPorIngresar);
        if (esAnterior < 0) {
            if (n.getIzq() == null) {
                n.setIzq(new NodoAVLProfesion((String) profesion, (int) indice, null, null, n));
                recalcularFE(n);
            } else {
                insertarOrdenado((NodoAVLProfesion) n.getIzq(), profesion, (int) indice);
            }
        } else {
            if (esAnterior > 0) {
                if (n.getDer() == null) {
                    n.setDer(new NodoAVLProfesion((String) profesion, (int) indice, null, null, n));
                    recalcularFE(n);
                } else {
                    insertarOrdenado((NodoAVLProfesion) n.getDer(), (String) profesion, (int) indice);
                }
            } else { // Si son iguales
                n.agregarIndice((int) indice);
            }
        }
    }
    
    /**
     * Función para buscar un elemento en el árbol. Buscar una profesión. No devuelve ningún valor
     * @param o 
     */
    public void buscar(Object o) {
        buscarSiExiste(raiz, o);
    }

    private void buscarSiExiste(NodoAVLProfesion n, Object o) {
        String profesionActual = (String) n.getDato();
        String profesionABuscar = (String) o;
        int esAnterior = profesionABuscar.compareTo(profesionActual);
        if (esAnterior > 0) { // Si el nombre de la profesión es menor
            if ((NodoAVLProfesion) n.getIzq() != null) {
                buscarSiExiste((NodoAVLProfesion) n.getIzq(), o);
            } else {
                System.out.println("La profesión ingresada no existe");
            }
        } else {
            if (esAnterior < 0) {
                if ((NodoAVLProfesion) n.getDer() != null) {
                    buscarSiExiste((NodoAVLProfesion) n.getDer(), o);
                } else {
                    System.out.println("La profesión ingresada no existe");
                }
            } else {
                System.out.println("La profesión existe y cuenta con los egresados: " + n.getListaDoble());
            }
        }
    }

    /**
     *Esta función regresa una lista doble con todos los índices de una profesión en específico. Recibe como parámetro la profesión a buscar
     * @param o
     * @return indices
     */
    public ListaDoble obtenerListaDeProfesion(Object o) {
        ListaDoble indices = new ListaDoble();
        indices = obtenerListaExisteDoble(raiz, o);
        return indices;
    }
    
    /**
     * Función local de la clase que recibe como parámetro el nodo del árbol en ese momento y la profesión a buscar, regresa la lista de índices que encontró en esa profesión
     * @param n
     * @param o
     * @return indices 
     */
    private ListaDoble obtenerListaExisteDoble(NodoAVLProfesion n, Object o) {
        ListaDoble indices = new ListaDoble();
        String profesionActual = (String) n.getDato();
        String profesionABuscar = (String) o;
        int esAnterior = profesionABuscar.compareTo(profesionActual);
        if (esAnterior > 0) { // Si el nombre de la profesión es menor
            if ((NodoAVLProfesion) n.getIzq() != null) {
                indices = obtenerListaExisteDoble((NodoAVLProfesion) n.getIzq(), o);
            } else {
                indices = null;
            }
        } else {
            if (esAnterior < 0) {
                if ((NodoAVLProfesion) n.getDer() != null) {
                    indices = obtenerListaExisteDoble((NodoAVLProfesion) n.getDer(), o);
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
    public void recalcularFE(NodoAVLProfesion nodo) {
        if (nodo != null) {
            nodo.setFE(
                    NodoAVLProfesion.altura((NodoAVLProfesion) nodo.getDer())
                    - NodoAVLProfesion.altura((NodoAVLProfesion) nodo.getIzq())
            );
            if (nodo.getFE() == 2 || nodo.getFE() == -2) {
                balancear(nodo);
            } else {
                recalcularFE(nodo.getPadre());
            }
        }
    }
    
    /**
     * Función para recorrer el árbol
     * @param nodo 
     */
    public void balancear(NodoAVLProfesion nodo) {
        int feActual = nodo.getFE();
        if (feActual == 2) {
            switch (((NodoAVLProfesion) nodo.getDer()).getFE()) {
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
            switch (((NodoAVLProfesion) nodo.getIzq()).getFE()) {
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

    public void rotacionII(NodoAVLProfesion nodo) {
        //Establecer los apuntadores..
        NodoAVLProfesion Padre = nodo.getPadre();
        NodoAVLProfesion P = nodo;
        NodoAVLProfesion Q = (NodoAVLProfesion) P.getIzq();
        NodoAVLProfesion B = (NodoAVLProfesion) Q.getDer();

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

    public void rotacionDD(NodoAVLProfesion nodo) {
        //Establecer los apuntadores..
        NodoAVLProfesion Padre = nodo.getPadre();
        NodoAVLProfesion P = nodo;
        NodoAVLProfesion Q = (NodoAVLProfesion) P.getDer();
        NodoAVLProfesion B = (NodoAVLProfesion) Q.getIzq();

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

    public void rotacionID(NodoAVLProfesion nodo) {
        NodoAVLProfesion Padre = nodo.getPadre();
        NodoAVLProfesion P = nodo;
        NodoAVLProfesion Q = (NodoAVLProfesion) P.getIzq();
        NodoAVLProfesion R = (NodoAVLProfesion) Q.getDer();
        NodoAVLProfesion B = (NodoAVLProfesion) R.getIzq();
        NodoAVLProfesion C = (NodoAVLProfesion) R.getDer();

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

    public void rotacionDI(NodoAVLProfesion nodo) {
        NodoAVLProfesion Padre = nodo.getPadre();
        NodoAVLProfesion P = nodo;
        NodoAVLProfesion Q = (NodoAVLProfesion) P.getDer();
        NodoAVLProfesion R = (NodoAVLProfesion) Q.getIzq();
        NodoAVLProfesion B = (NodoAVLProfesion) R.getDer();
        NodoAVLProfesion C = (NodoAVLProfesion) R.getIzq();

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

    /**
     * @return the todosIndices
     */
    public ListaDoble getTodosIndices() {
        return todosIndices;
    }

    /**
     * @param todosIndices the todosIndices to set
     */
    public void setTodosIndices(ListaDoble todosIndices) {
        this.todosIndices = todosIndices;
    }

}

