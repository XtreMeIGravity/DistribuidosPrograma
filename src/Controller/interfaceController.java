/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import java.util.Scanner;

/**
 * <h1>Descripcion </h1>
 *
 *
 * @author David Lopez Hernandez
 * @since 19-08-2021
 */
public class interfaceController {

    /**
     * @return the palabraDeSeguridad
     */
    public static String getPalabraDeSeguridad() {
        return palabraDeSeguridad;
    }

    private static final String palabraDeSeguridad = "Contrasena";

    /*
     *
     *
     */
    public static void listClients() {
        jsonConnector jsonConect = new jsonConnector();
        System.out.println("=======CLIENTES========");
        jsonConect.listClients();
        jsonConect.close();
    }

    /*
     *
     *
     */
    public static void BorrarCliente(String busqueda) {
        jsonConnector jsonConect = new jsonConnector();
        Scanner teclado = new Scanner(System.in);
        Cliente tmp = jsonConect.searchClient(busqueda);
        jsonConect.deleteClient(tmp);
        jsonConect.close();
    }

    /*
     *
     *
     */
    public static void Modificar(String busqueda, Scanner teclado) {
        jsonConnector jsonConect = new jsonConnector();
        Cliente tmp = jsonConect.searchClient(busqueda);
        Cliente tmpModificado = new Cliente();
        if (tmp == null) {
            System.out.println("El Alias no puede ser modificado");
        } else {

            tmpModificado.setAlias(tmp.getAlias());
            System.out.println("=======MODIFICAR CLIENTE========");
            tmpModificado = modificarString("Nombre", tmp, tmpModificado, teclado);
            tmpModificado = modificarString("Primer Apellido", tmp, tmpModificado, teclado);
            tmpModificado = modificarString("Segundo Apellido", tmp, tmpModificado, teclado);
            tmpModificado = modificarString("Razon social", tmp, tmpModificado, teclado);
            tmpModificado = modificarString("rfc", tmp, tmpModificado, teclado);
            tmpModificado = modificarString("correo", tmp, tmpModificado, teclado);
            tmpModificado = modificarString("telefono", tmp, tmpModificado, teclado);
            jsonConect.modifyClient(tmp, tmpModificado);
        }
        jsonConect.close();
    }

    /*
     *
     *
     */
    public static Cliente modificarString(String filter, Cliente origen, Cliente Destino, Scanner teclado) {
        ////////////Lectura de razon social
        int value = 0;
        do {
            if (value != 0) {
                System.out.println("Valor invalido");
            }
            String textoCambiar = "";
            long telefono = 0;
            if (filter.equals("Nombre")) {
                textoCambiar = origen.getNombre();
            } else if (filter.equals("Primer Apellido")) {
                textoCambiar = origen.getPrimerApellido();
            } else if (filter.equals("Segundo Apellido")) {
                textoCambiar = origen.getSegundoApellido();
            } else if (filter.equals("Razon social")) {
                textoCambiar = origen.getRazonSocial();
            } else if (filter.equals("rfc")) {
                textoCambiar = origen.getRfc();
            } else if (filter.equals("correo")) {
                textoCambiar = origen.getCorreo();
            } else if (filter.equals("telefono")) {
                telefono = origen.getTelefono();
            }

            if (telefono != 0) {
                System.out.println("Desea cambiar el valor de " + filter + "? Valor Actual: " + telefono + "");
            } else {
                System.out.println("Desea cambiar el valor de " + filter + "? Valor Actual: " + textoCambiar + "");
            }

            System.out.println("1)Si");
            System.out.println("2)No");
            value = teclado.nextInt();

            if (filter.equals("Nombre")) {
                if (value == 1) {
                    System.out.println("Introduce el nuevo valor:");
                    Destino.setNombre(teclado.next());
                } else if (value == 2) {
                    Destino.setNombre(textoCambiar);
                }
            } else if (filter.equals("Primer Apellido")) {
                if (value == 1) {
                    System.out.println("Introduce el nuevo valor:");
                    Destino.setPrimerApellido(teclado.next());
                } else if (value == 2) {
                    Destino.setPrimerApellido(textoCambiar);
                }
            } else if (filter.equals("Segundo Apellido")) {
                if (value == 1) {
                    System.out.println("Introduce el nuevo valor:");
                    Destino.setSegundoApellido(teclado.next());
                } else if (value == 2) {
                    Destino.setSegundoApellido(textoCambiar);
                }
            } else if (filter.equals("Razon social")) {
                if (value == 1) {
                    System.out.println("Introduce el nuevo valor:");
                    Destino.setRazonSocial(teclado.next());
                } else if (value == 2) {
                    Destino.setRazonSocial(textoCambiar);
                }
            } else if (filter.equals("rfc")) {
                if (value == 1) {
                    System.out.println("Introduce el nuevo valor:");
                    Destino.setRfc(teclado.next());
                } else if (value == 2) {
                    Destino.setRfc(textoCambiar);
                }
            } else if (filter.equals("correo")) {
                if (value == 1) {
                    System.out.println("Introduce el nuevo valor:");
                    Destino.setCorreo(teclado.next());
                } else if (value == 2) {
                    Destino.setCorreo(textoCambiar);
                }
            } else if (filter.equals("telefono")) {
                if (value == 1) {
                    System.out.println("Introduce el nuevo valor:");
                    Destino.setTelefono(teclado.nextLong());
                } else if (value == 2) {
                    Destino.setTelefono(telefono);
                }
            }

        } while (value != 1 && value != 2);
        ///////////////////////////////
        return Destino;
    }

    /*
     * 
     *
     */
    public static void AgregarCliente() {
        jsonConnector jsonConect = new jsonConnector();
        Scanner teclado = new Scanner(System.in);
        Cliente tmp = new Cliente();

        System.out.println("=======AGREGAR CLIENTE========");
        String aliasString = "";
        do {
            if (jsonConect.searchClient(aliasString) != null) {
                System.out.println("Ya existe el alias");
            }
            System.out.println("Escribe el Alias del nuevo usuario");
            aliasString = teclado.nextLine();
            if (aliasString.equals("")) {
                return;
            }
            tmp.setAlias(aliasString);
        } while (jsonConect.searchClient(aliasString) != null);

        String nombreString;
        do {
            System.out.println("Escribe el Nombre del nuevo usuario");
            nombreString = teclado.nextLine();
            tmp.setNombre(nombreString);
        } while (nombreString.equals(""));

        String primerApellido;
        do {
            System.out.println("Escribe el Primer Apellido del nuevo usuario");
            primerApellido = teclado.nextLine();
            tmp.setPrimerApellido(primerApellido);
        } while (primerApellido.equals(""));

        String segundoApellido;
        System.out.println("Escribe el Segundo Apellido del nuevo usuario(Opcional)");
        segundoApellido = teclado.nextLine();
        tmp.setSegundoApellido(segundoApellido);

        String razonSocial;
        do {
            System.out.println("Escribe el Razon social del nuevo usuario");
            razonSocial = teclado.nextLine();
            tmp.setRazonSocial(razonSocial);
        } while (razonSocial.equals(""));

        String rfcString;
        do {
            System.out.println("Escribe el rfc del nuevo usuario");
            rfcString = teclado.nextLine();
            tmp.setRfc(rfcString);
        } while (rfcString.equals(""));

        String correoString;
        do {
            System.out.println("Escribe el correo del nuevo usuario");
            correoString = teclado.nextLine();
            tmp.setCorreo(correoString);
        } while (rfcString.equals(""));

        System.out.println("Escribe el telefono del nuevo usuario");
        tmp.setTelefono(teclado.nextLong());

        jsonConect.addClient(tmp);
        jsonConect.close();
    }

}
