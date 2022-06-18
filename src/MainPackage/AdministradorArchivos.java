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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *Clase del administrador de archivos, es la que genera la lista simplemente ligada
 * @author braul
 */
public class AdministradorArchivos {

    //ListaDoble listaEgresados = null;
    public boolean checkFileExistance(String fileName) {
        File archivo = new File(fileName);
        if (!archivo.exists()) {
            JOptionPane.showMessageDialog(null, "El archivo: " + fileName + " NO existe", "FILE ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public ListaDoble getContentList(String fileName) {
        ListaDoble listaEgresados = new ListaDoble();
        File archivo = new File(fileName);
        Scanner lector;
        String linea;

        try {
            lector = new Scanner(archivo);
            int indice = 2;
            lector.nextLine();
            while (lector.hasNextLine()) {
                linea = lector.nextLine();
                String[] split = linea.split(Character.toString(','));
                Egresados egresado = new Egresados();
                egresado.setIndice(indice);
                egresado.setNombre(split[0]);
                egresado.setProfesion(split[1]);
                egresado.setPromedio(Integer.parseInt(split[2]));
                listaEgresados.insertaFinal(egresado);
                indice++;
            }
            return listaEgresados;
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        AdministradorArchivos admin = new AdministradorArchivos();
        ListaDoble lista = admin.getContentList("C:\\Users\\victo\\Desktop\\egresados.csv");
        lista.MostrarEgresadosConsola();

        /*                              ARBOL DE NOMBRES                                */
        //CREO EL ARBOL
        System.out.println("----------------------------------------------------------------");
        System.out.println("Se crea el árbol de nombres...");
        ArbolAVL arbolNombres = new ArbolAVL();
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
        
        System.out.println("\nTODOS LOS INDICES DEL ARBOL DE NOMBRES");
        ListaDoble todosLosIndicesNombres = new ListaDoble();
        todosLosIndicesNombres = arbolNombres.getListaDobleTotal();
        todosLosIndicesNombres.imprimir();
        
        
        //IMPRIMIR TODO EL ARBOL
        arbolNombres.inOrden();
        //BUSCAR UNO EN PARTICULAR
        arbolNombres.buscar("Abril Guadalupe Escobedo Bojórquez");
        
        //OBTENER INDICE DADO UN NOMBRE
        ListaDoble aux = new ListaDoble();
        aux = arbolNombres.obtenerListaDeNombre("Abril Guadalupe Escobedo Bojórquez");
        System.out.println("\n");
        aux.imprimir();
        
        
        /*                          ARBOL DE PROFESIONES                        */
        //CREO EL ARBOL
        System.out.println("----------------------------------------------------------------");
        System.out.println("Se crea el árbol de profesiones...");
        ArbolAVLProfesion arbolProfesiones = new ArbolAVLProfesion();
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
        //OBTENER TODOS LOS INDICES DE UN ARBOL
        System.out.println("\nTODOS LOS INDICES DE PROFESION: ");
        ListaDoble todosLosIndices = new ListaDoble();
        todosLosIndices = arbolProfesiones.getTodosIndices(); //todosLosIndices es una lista doble que tiene TODOS los indices
        todosLosIndices.imprimir();
        
        
        //IMPRIMIR TODO EL ARBOL
        arbolProfesiones.inOrden();

        //BUSCAR SI UNA PROFESION EXISTE
        arbolProfesiones.buscar("Arquitecto");

        //OBTENER TODOS LOS INDICES DE LOS QUE TENGAN DICHA PROFESION
        ListaDoble indices = new ListaDoble();
        indices = arbolProfesiones.obtenerListaDeProfesion("Arquitecto");
        System.out.println("Todos los " + "arquitectos: ");
        indices.imprimir();
        System.out.println("\n");

        //ALGORITMO PARA IMPRIMIR CIERTA PROFESION
        Nodo indiceActual = new Nodo();
        NodoDoble elementoActual = new NodoDoble();
        elementoActual = lista.getInicioListaDoble();
        Egresados egresado;
        while (elementoActual != null) {
            egresado = (Egresados) elementoActual.getDato();
            indiceActual = indices.getInicio();
            while (indiceActual != null) {
                if ((int) egresado.getIndice() == (int) indiceActual.getDato()) {
                    System.out.println(egresado.getNombre());
                }
                indiceActual = indiceActual.getSiguiente();
            }
            elementoActual = elementoActual.getSiguiente();
        }

        /*                          ARBOL DE PROMEDIOS                        */
        //CREO EL ARBOL
        System.out.println("----------------------------------------------------------------");
        System.out.println("Se crea el árbol de promedios...");
        ArbolAVLPromedio arbolPromedio = new ArbolAVLPromedio();
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
        
        //OBTENER TODOS LOS INDICES DE UN ARBOL
        System.out.println("\nTODOS LOS INDICES DE PROMEDIO: ");
        ListaDoble todosLosIndicesPromedio = new ListaDoble();
        todosLosIndicesPromedio = arbolPromedio.getTodosIndices(); //todosLosIndices es una lista doble que tiene TODOS los indices
        todosLosIndicesPromedio.imprimir();
        
        //IMPRIMIR TODO EL ARBOL
        arbolPromedio.inOrden();

        //BUSCAR SI UNA PROFESION EXISTE
        arbolPromedio.buscar(77);

        //OBTENER TODOS LOS INDICES DE LOS QUE TENGAN DICHO PROMEDIO
        ListaDoble indicesPromedio = new ListaDoble();
        indicesPromedio = arbolPromedio.obtenerListaDePromedio(90);
        System.out.println("Todos los " + " que tengan promedio 90: ");
        indicesPromedio.imprimir();
        System.out.println("\n");

        //ALGORITMO PARA IMPRIMIR CIERTO PROMEDIO
        Nodo indiceActualProm = new Nodo();
        NodoDoble elementoActualProm = new NodoDoble();
        elementoActualProm = lista.getInicioListaDoble();
        Egresados egresadoProm;
        while (elementoActualProm != null) {
            egresadoProm = (Egresados) elementoActualProm.getDato();
            indiceActualProm = indicesPromedio.getInicio();
            while (indiceActualProm != null) {
                if ((int) egresadoProm.getIndice() == (int) indiceActualProm.getDato()) {
                    System.out.println(egresadoProm.getNombre());
                }
                indiceActualProm = indiceActualProm.getSiguiente();
            }
            elementoActualProm = elementoActualProm.getSiguiente();
        }

        
        
        
        /*                      ALGORITMOS PARA BUSQUEDAS COMPLEJAS                             */
        //BUSQUEDA COMPLEJA (CIERTA PROFESION CON CIERTO PROMEDIO)
        System.out.println("\n--------------------------------------------------------------------------\n");
        ListaDoble listaDobleAux = new ListaDoble(); // Esta lista va a guardar los índices repetidos
        Nodo indiceAcutalProfesion = new Nodo(); //Creo una var Nodo que va a ir recorriendo todos los indices de profesion
        Nodo indiceActualPromedio = new Nodo();
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

        listaDobleAux.imprimir();

        //MAS DE UN PROMEDIO
        ListaDoble listaPromedios = new ListaDoble(); //Esta lista va a tener todos los índices de cada lista que se cree
        ListaDoble indicesPromedioVariable = new ListaDoble(); //Esta lista va a obtener cada lista que se cree en el for
        Nodo indiceVariable = new Nodo(); //Este es el indice que se va a mover entre cada lista que se crea
        for (int i = 90; i <= 100; i++) {
            indicesPromedioVariable = arbolPromedio.obtenerListaDePromedio(i); //Obtengo la lista en ese momento
            indiceVariable = indicesPromedioVariable.getInicio(); //Le doy el primer elemento de la lista justo creada
            while (indiceVariable.getSiguiente() != null) {
                listaPromedios.insertaFinal((int) indiceVariable.getDato()); //Le inserto a la lista grande el valor en ese momento
                indiceVariable = indiceVariable.getSiguiente();
            }
        }
        System.out.println("\n");
        listaPromedios.imprimir();
    }
}
