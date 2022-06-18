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
import java.util.ArrayList;

/**
 *
 * @author braul
 */
public class Main {

//    public static void main(String[] args) {
//        ListaDoble listaEgresados;
//        AdministradorArchivos adminArch = new AdministradorArchivos();
//        String ruta = "D:\\Desktop\\egresados.csv";
//        
//        if (adminArch.checkFileExistance(ruta)) {
//            listaEgresados = adminArch.getContentList(ruta);
//
//            /*
//            for (Egresados egresado : array) {
//                System.out.println("Nombre: " + egresado.getNombre());
//                System.out.println("Profesión: " + egresado.getProfesion());
//                System.out.println("Promedio: " + egresado.getPromedio());
//                System.out.println("Indice: " + egresado.getIndice());
//                System.out.println("-----------------------------------------");
//            }*/
//            
//            
//            /*ARBOL DE NOMBRES*/
//            
//            System.out.println("Se crea el árbol...");
//            ArbolAVL arbol = new ArbolAVL();
//            for (Egresados egresado : array) {
//                if (egresado.getIndice() == 2) {
//                    arbol.setearRaiz(egresado.getNombre()); //Asigno el primer nodo
//                }
//                arbol.insertar(egresado.getNombre()); // Asigno cada elemento
//            }
//            
//             //IMPRIMO TODO EL ARBOL
//            System.out.println("Arbol por nombres: ");
//            arbol.posOrden(); 
//            arbol.buscar("Abril Guadalupe Escobedo Bojórquez"); // Buscar uno en particular
//            
//            
//            
//            
//           
//            /*                              ARBOL DE PROFESIONES                                */
//            //CREO EL ARBOL
//            System.out.println("----------------------------------------------------------------");
//            System.out.println("Se crea el árbol de profesiones...");
//            ArbolAVLProfesion arbolProfesiones = new ArbolAVLProfesion();
//            for (Egresados egresado : array) {
//                if (egresado.getIndice() == 2) {
//                    arbolProfesiones.setearRaiz(egresado.getProfesion(), egresado.getIndice());
//                }
//                arbolProfesiones.insertar(egresado.getProfesion(), egresado.getIndice());
//            }
//            //IMPRIMO TODO EL ARBOL
//            arbolProfesiones.inOrden();
//            
//            //BUSCAR SI UNA PROFESION EXISTE
//            arbolProfesiones.buscar("Arquitecto");
//            
//            //OBTENER TODOS LOS INDICES DE LOS QUE TENGAN DICHA PROFESION
//            ListaDoble indices = new ListaDoble();
//            indices = arbolProfesiones.obtenerListaDeProfesion("Arquitecto"); 
//            System.out.println("Todos los" + "arquitectos: ");
//            indices.imprimir();
//            
//            //ALGORITMO PARA IMPRIMIR UNA CIERTA PROFESION
//            Nodo indiceActual = new Nodo();
//            for(Egresados egresado: array){
//                indiceActual = indices.getInicio();
//                while(indiceActual.getSiguiente() != null){
//                    if(egresado.getIndice() == (int)indiceActual.getDato()){
//                        System.out.println(egresado.getNombre());
//                    }
//                    indiceActual = indiceActual.getSiguiente();
//                }
//            }
//
//            
//            //OBTENER LA LISTA CON TODOS LOS INDICES DEL ARBOL
//            ListaDoble indicesAux = new ListaDoble();
//            indicesAux = arbolProfesiones.obtenerListaDeProfesion("Arquitecto");
//            indicesAux.imprimir();
//            
//            
//            System.out.println("");
//            System.out.println("TODOS LOS INDICES: ");
//            
//            ListaDoble todosLosIndices = new ListaDoble();
//            todosLosIndices = arbolProfesiones.getTodosIndices();
//            todosLosIndices.imprimir();
//
//            
//            
//            
//            /*                                              ARBOL DE PROMEDIOS                                              */
//            System.out.println("----------------------------------------------------------------");
//            System.out.println("Se crea el árbol de promedios...");
//            ArbolAVLPromedio arbolPromedio = new ArbolAVLPromedio();
//            for (Egresados egresado : array) {
//                if (egresado.getIndice() == 2) {
//                    arbolPromedio.setearRaiz(egresado.getPromedio(), egresado.getIndice());
//                }
//                arbolPromedio.insertar(egresado.getPromedio(), egresado.getIndice());
//            }
//            
//            //IMPRIMO TODO EL ARBOL
//            System.out.println("Arbol por promedios:");
//            arbolPromedio.inOrden();
//            
//            //BUSCO SI UN PROMEDIO EXISTE
//            arbolPromedio.buscar(90);
//            
//            //OBTENER TODOS LOS INDICES DE LOS QUE TENGAN DICHO PROMEDIO
//            ListaDoble indicesPromedio = new ListaDoble();
//            indicesPromedio = arbolPromedio.obtenerListaDePromedio(90);
//            System.out.println("Todos los que tengan promedio 90");
//            indicesPromedio.imprimir();
//            
//            
//            //ALGORITMO PARA IMPRIMIR UN CIERTO PROMEDIO
//            Nodo indiceActualAux = new Nodo();
//            for(Egresados egresado: array){
//                indiceActualAux = indicesPromedio.getInicio();
//                while(indiceActualAux.getSiguiente() != null){
//                    if(egresado.getIndice() == (int)indiceActualAux.getDato()){
//                        System.out.println(egresado.getNombre());
//                    }
//                    indiceActualAux = indiceActualAux.getSiguiente();
//                }
//            }
//            
//            
//            
//            
//            /*                      ALGORITMOS PARA BUSQUEDAS COMPLEJAS                             */
//            
//            
//            //BUSQUEDA COMPLEJA (CIERTA PROFESION CON CIERTO PROMEDIO)
//            System.out.println("\n--------------------------------------------------------------------------\n");
//            ListaDoble listaDobleAux = new ListaDoble(); // Esta lista va a guardar los índices repetidos
//            Nodo indiceAcutalProfesion = new Nodo(); //Creo una var Nodo que va a ir recorriendo todos los indices de profesion
//            Nodo indiceActualPromedio = new Nodo();
//            indiceAcutalProfesion = indices.getInicio(); //Ahora tiene el primer indice
//            while(indiceAcutalProfesion.getSiguiente() != null){
//                indiceActualPromedio = indicesPromedio.getInicio(); //Ahora indiceActualPromedio tiene el primer índice de los promedios
//                while(indiceActualPromedio.getSiguiente() != null){
//                    if ((int )indiceAcutalProfesion.getDato() == (int) indiceActualPromedio.getDato()){ // Si los índices son iguales
//                        listaDobleAux.insertaFinal((int)indiceActualPromedio.getDato()); // Guardo el índice repetido
//                    }
//                    indiceActualPromedio = indiceActualPromedio.getSiguiente(); // El indice de la lista de promedios avanza al siguiente
//                }
//                indiceAcutalProfesion = indiceAcutalProfesion.getSiguiente(); // El indice de la profesion avanza al siguiente
//            }
//            
//            listaDobleAux.imprimir();
//            
//            
//            //MAS DE UN PROMEDIO
//            
//            ListaDoble listaPromedios = new ListaDoble(); //Esta lista va a tener todos los índices de cada lista que se cree
//            ListaDoble indicesPromedioVariable = new ListaDoble(); //Esta lista va a obtener cada lista que se cree en el for
//            Nodo indiceVariable = new Nodo(); //Este es el indice que se va a mover entre cada lista que se crea
//            for (int i = 90;    i<=100;     i++){
//                indicesPromedioVariable = arbolPromedio.obtenerListaDePromedio(i); //Obtengo la lista en ese momento
//                indiceVariable = indicesPromedioVariable.getInicio(); //Le doy el primer elemento de la lista justo creada
//                while(indiceVariable.getSiguiente() != null){ 
//                    listaPromedios.insertaFinal((int) indiceVariable.getDato()); //Le inserto a la lista grande el valor en ese momento
//                    indiceVariable = indiceVariable.getSiguiente(); 
//                }
//            }
//            System.out.println("\n");
//            listaPromedios.imprimir();
//            
//            
//            
//        }

}

