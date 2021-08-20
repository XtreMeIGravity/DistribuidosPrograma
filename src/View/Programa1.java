/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controller.interfaceController.*;
import java.util.Scanner;

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
        // Menu de la aplicacion 
        int opcion = 0;
        String palabra;
        Scanner teclado = new Scanner(System.in);
        System.out.println("=========BIENVENIDO=========");
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
            switch (opcion) {
                case 1:
                    listClients();
                    break;
                case 2:
                    AgregarCliente();
                    break;
                case 3:
                    Modificar(teclado.nextLine(), teclado);
                    break;
                case 4:
                    BorrarCliente(teclado.nextLine());
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (opcion != 1 || opcion != 2 || opcion != 3 || opcion != 4 || opcion != 5);
    }
}
