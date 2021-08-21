/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controller.interfaceController.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Lopez Hernandez
 */
public class Programa1 {

    /**
     * Declaración del método principal
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Crear archivo y ruta en caso de no existir
        String directorio = "res";
        String ruta = directorio + "/DBClients.json";
        // Si existe el directorio no es creado
        File directorios = new File(directorio);
        if (!directorios.exists()) {
            if (directorios.mkdir()) {
                System.out.println("Multiples directorios fueron creados");
            } else {
                System.out.println("Error al crear directorios");
            }
        }else{
            System.out.println("Ya existe el directorio");
        }
        // Si el archivo no existe es creado
        File file = new File(ruta);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Archivo Encontrado");
            }
        }else{
            System.out.println("Ya existe el archivo");
        }
        // Menu de la aplicacion 
        int opcion = 0;
        String palabra;
        Scanner teclado = new Scanner(System.in);

        System.out.println(
                "=========BIENVENIDO=========");
        do {
            System.out.println("Introduce la palabra de seguridad:");
            palabra = teclado.next();
        } while (!palabra.equals(getPalabraDeSeguridad()));
        do {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1)Lista de clientes");
            System.out.println("2)Agregar Cliente");
            System.out.println("3)Actualizar datos de Cliente");
            System.out.println("4)Eliminar Cliente");
            System.out.println("5)Salir");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    listClients();
                    break;
                case 2:
                    AgregarCliente();
                    break;
                case 3:
                    System.out.println("Introduce el Alias que deseas modificar:");
                    Modificar(teclado.nextLine(), teclado);
                    break;
                case 4:
                    System.out.println("Introduce el Alias que deseas Eliminar:");
                    BorrarCliente(teclado.nextLine());
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (opcion != 1 || opcion != 2 || opcion != 3 || opcion != 4 || opcion
                != 5);
    }
}
