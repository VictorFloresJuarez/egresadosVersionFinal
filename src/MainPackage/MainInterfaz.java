/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import Domain.ArbolAVL;
import Domain.ArbolAVLProfesion;
import Domain.ArbolAVLPromedio;
import DomainList.ListaDoble;
import DomainList.Nodo;
import DomainList.NodoDoble;
import InterfazPackage.BusquedaAvanzadaGUI;
import InterfazPackage.BusquedaGUI;
import InterfazPackage.ListaGUI;
import InterfazPackage.ListadoGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author braul
 */
public class MainInterfaz implements ActionListener{
    private ListaGUI listaGui;
    private ListadoGUI listadoGui;
    private BusquedaGUI busquedaGui;
    private BusquedaAvanzadaGUI avanzadaGui;
    
    private ArbolAVL arbolNombres;
    private ArbolAVLProfesion arbolProfesiones;
    private ArbolAVLPromedio arbolPromedio;
    
    private ListaDoble listaEgresados;
    
    public MainInterfaz() {
        AdministradorArchivos admin = new AdministradorArchivos();
        String ruta = "C:\\Users\\victo\\Desktop\\egresados.csv";
        
        if (admin.checkFileExistance(ruta)) {
            listaEgresados= admin.getContentList(ruta);
            crearArbolNombres(listaEgresados);
            crearArbolProfesion(listaEgresados);
            crearArbolPromedio(listaEgresados);
            
            
            crearInterfazLista();
        }
    }
    
    
    public void crearArbolNombres(ListaDoble lista) {
        arbolNombres = new ArbolAVL();
        NodoDoble nodoActual = new NodoDoble(); //Nodoactual
        nodoActual = lista.getInicioListaDoble(); //Ahora tiene el primer elemento
        Egresados egresadoActual;
        while (nodoActual != null) {
            egresadoActual = (Egresados) nodoActual.getDato(); //Ahora el egresado actual tiene los datos del nodo actual
            if (egresadoActual.getIndice() == 2) { //Si es el primer elemento de la lista
                arbolNombres.setearRaiz(egresadoActual.getNombre(), (int) egresadoActual.getIndice());
            } else { //Si no es el primer elemento
                arbolNombres.insertar(egresadoActual.getNombre(), (int) egresadoActual.getIndice());
            }
            nodoActual = nodoActual.getSiguiente();
        }
    }
    
    public void crearArbolProfesion(ListaDoble lista) {
        arbolProfesiones = new ArbolAVLProfesion();
        NodoDoble nodoActualProfesion = new NodoDoble(); //Nodoactual
        nodoActualProfesion = lista.getInicioListaDoble(); //Ahora tiene el primer elemento
        Egresados egresadoActualProfesion;
        while (nodoActualProfesion != null) {
            egresadoActualProfesion = (Egresados) nodoActualProfesion.getDato(); //Ahora el egresado actual tiene los datos del nodo actual
            if (egresadoActualProfesion.getIndice() == 2) { //Si es el primer elemento de la lista
                arbolProfesiones.setearRaiz(egresadoActualProfesion.getProfesion(), egresadoActualProfesion.getIndice());
            } else { //Si no es el primer elemento
                arbolProfesiones.insertar(egresadoActualProfesion.getProfesion(), egresadoActualProfesion.getIndice());
            }
            nodoActualProfesion = nodoActualProfesion.getSiguiente();
        }
    }
    
    public void crearArbolPromedio(ListaDoble lista) {
        arbolPromedio = new ArbolAVLPromedio();
        NodoDoble nodoActualPromedio = new NodoDoble(); //Nodoactual
        nodoActualPromedio = lista.getInicioListaDoble(); //Ahora tiene el primer elemento
        Egresados egresadoActualPromedio;
        while (nodoActualPromedio != null) {
            egresadoActualPromedio = (Egresados) nodoActualPromedio.getDato(); //Ahora el egresado actual tiene los datos del nodo actual
            if (egresadoActualPromedio.getIndice() == 2) { //Si es el primer elemento de la lista
                arbolPromedio.setearRaiz(egresadoActualPromedio.getPromedio(), egresadoActualPromedio.getIndice());
            } else { //Si no es el primer elemento
                arbolPromedio.insertar(egresadoActualPromedio.getPromedio(), egresadoActualPromedio.getIndice());
            }
            nodoActualPromedio = nodoActualPromedio.getSiguiente();
        }
    }
    
    public ListaDoble listarNombres(){
        ListaDoble todosLosIndicesNombres = new ListaDoble();
        todosLosIndicesNombres = arbolNombres.getListaDobleTotal();
        return todosLosIndicesNombres;
    }
    
    public ListaDoble listarProfesiones() {
        ListaDoble todosLosIndices = new ListaDoble();
        todosLosIndices = arbolProfesiones.getTodosIndices();
        return todosLosIndices;
    }
    
    public ListaDoble listarPromedios(){
        ListaDoble todosLosIndicesPromedio = new ListaDoble();
        todosLosIndicesPromedio = arbolPromedio.getTodosIndices(); //todosLosIndices es una lista doble que tiene TODOS los indices
        return todosLosIndicesPromedio;
    }
    
    public ListaDoble buscarNombre(String nombre){
        ListaDoble aux = new ListaDoble();
        aux = arbolNombres.obtenerListaDeNombre(nombre);
        return aux;
    }
    
    public ListaDoble buscarProfesion(String profesion){
        ListaDoble indices = new ListaDoble();
        indices = arbolProfesiones.obtenerListaDeProfesion(profesion);
        return indices;
    }
    
    public ListaDoble buscarPromedio(int promedio){
        ListaDoble indicesPromedio = new ListaDoble();
        indicesPromedio = arbolPromedio.obtenerListaDePromedio(promedio);
        return indicesPromedio;
    }
    
    public ListaDoble buscarPromedioRango(int inicio, int fin) {
        ListaDoble listaPromedios = new ListaDoble(); //Esta lista va a tener todos los índices de cada lista que se cree
        ListaDoble indicesPromedioVariable = new ListaDoble(); //Esta lista va a obtener cada lista que se cree en el for
        Nodo indiceVariable = new Nodo(); //Este es el indice que se va a mover entre cada lista que se crea
        for (int i = inicio; i <= fin; i++) {
            indicesPromedioVariable = arbolPromedio.obtenerListaDePromedio(i); //Obtengo la lista en ese momento
            indiceVariable = indicesPromedioVariable.getInicio(); //Le doy el primer elemento de la lista justo creada
            while (indiceVariable.getSiguiente() != null) {
                listaPromedios.insertaFinal((int) indiceVariable.getDato()); //Le inserto a la lista grande el valor en ese momento
                indiceVariable = indiceVariable.getSiguiente();
            }
        }
        return listaPromedios;
    }
    
    public ListaDoble buscarPromedioRangoProfesion(int inicio, int fin, String profesion) {
        ListaDoble listaDobleAux = new ListaDoble(); // Esta lista va a guardar los índices repetidos
        Nodo indiceAcutalProfesion = new Nodo(); //Creo una var Nodo que va a ir recorriendo todos los indices de profesion
        Nodo indiceActualPromedio = new Nodo();
        ListaDoble indices = buscarProfesion(profesion);
        ListaDoble indicesPromedio = buscarPromedioRango(inicio, fin);
        indiceAcutalProfesion = indices.getInicio(); //Ahora tiene el primer indice
        while (indiceAcutalProfesion != null) {
            indiceActualPromedio = indicesPromedio.getInicio(); //Ahora indiceActualPromedio tiene el primer índice de los promedios
            while (indiceActualPromedio != null) {
                if ((int) indiceAcutalProfesion.getDato() == (int) indiceActualPromedio.getDato()) { // Si los índices son iguales
                    listaDobleAux.insertaFinal((int) indiceActualPromedio.getDato()); // Guardo el índice repetido
                }
                indiceActualPromedio = indiceActualPromedio.getSiguiente(); // El indice de la lista de promedios avanza al siguiente
            }
            indiceAcutalProfesion = indiceAcutalProfesion.getSiguiente(); // El indice de la profesion avanza al siguiente
        }

        return listaDobleAux;
    }
    
    public ListaDoble buscarPromedioProfesion(int valor, String profesion) {
        ListaDoble listaDobleAux = new ListaDoble(); // Esta lista va a guardar los índices repetidos
        Nodo indiceAcutalProfesion = new Nodo(); //Creo una var Nodo que va a ir recorriendo todos los indices de profesion
        Nodo indiceActualPromedio = new Nodo();
        ListaDoble indices = buscarProfesion(profesion);
        ListaDoble indicesPromedio = buscarPromedio(valor);
        indiceAcutalProfesion = indices.getInicio(); //Ahora tiene el primer indice
        while (indiceAcutalProfesion != null) {
            indiceActualPromedio = indicesPromedio.getInicio(); //Ahora indiceActualPromedio tiene el primer índice de los promedios
            while (indiceActualPromedio != null) {
                if ((int) indiceAcutalProfesion.getDato() == (int) indiceActualPromedio.getDato()) { // Si los índices son iguales
                    listaDobleAux.insertaFinal((int) indiceActualPromedio.getDato()); // Guardo el índice repetido
                }
                indiceActualPromedio = indiceActualPromedio.getSiguiente(); // El indice de la lista de promedios avanza al siguiente
            }
            indiceAcutalProfesion = indiceAcutalProfesion.getSiguiente(); // El indice de la profesion avanza al siguiente
        }

        return listaDobleAux;
    }
    
    public void insertarJlist(JList jlist, ListaDoble indices){
        
        DefaultListModel modelo = (DefaultListModel) jlist.getModel();
        
        
        Nodo indiceActual = new Nodo();
        NodoDoble elementoActual = new NodoDoble();
        elementoActual = listaEgresados.getInicioListaDoble();
        Egresados egresado;
        while (elementoActual != null) {
            egresado = (Egresados) elementoActual.getDato();
            indiceActual = indices.getInicio();
            while (indiceActual != null) {
                if ((int) egresado.getIndice() == (int) indiceActual.getDato()) {
                    modelo.addElement(egresado.getTexto());
                }
                indiceActual = indiceActual.getSiguiente();
            }
            elementoActual = elementoActual.getSiguiente();
        }
        
        jlist.setModel(modelo);
    }
    
    public void crearInterfazLista() {
        listaGui = new ListaGUI();
        listaGui.setVisible(true);
        listaGui.getBotonListado().addActionListener(this);
        listaGui.getBotonBusqueda().addActionListener(this);
        listaGui.getBotonAvanzada().addActionListener(this);
    }
    
    public void crearInterfazListado() {
        listadoGui = new ListadoGUI(this);
        listadoGui.setVisible(true);
    }
    
    public void crearInterfazBusqueda() {
        busquedaGui = new BusquedaGUI(this);
        busquedaGui.setVisible(true);
    }
    
    public void crearInterfazBusquedaAvanzada() {
        avanzadaGui = new BusquedaAvanzadaGUI(this);
        avanzadaGui.setVisible(true);
    }

    public JList getJList() {
        return listaGui.getJList();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == listaGui.getBotonListado()) {
            crearInterfazListado();
        }
        
        if(e.getSource() == listaGui.getBotonBusqueda()) {
            crearInterfazBusqueda();
        }
        
        if(e.getSource() == listaGui.getBotonAvanzada()) {
            crearInterfazBusquedaAvanzada();
        }
    }
    
    public static void main(String[] args) {
        MainInterfaz main = new MainInterfaz();
        
        
    }
}