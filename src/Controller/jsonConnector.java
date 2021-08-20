/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

/**
 * <h1>Descripcion </h1>
 *
 *
 * @author David Lopez Hernandez
 * @since 18-08-2021
 */
public class jsonConnector {

    private final String FileName = "res/DBClients.json";
    private final ArrayList<Cliente> clientes;

    /*
    *
    *
     */
    public jsonConnector() {
        clientes = new ArrayList<>();
        try {
            //Read Json
            // parsing file "JSONExample.json"
            Object obj = new JSONParser().parse(new FileReader(FileName));
            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;

            // getting phoneNumbers
            JSONArray ja = (JSONArray) jo.get("Clientes");
            // iterating phoneNumbers
            Iterator<Map.Entry> itr1;
            Iterator itr2 = ja.iterator();
            while (itr2.hasNext()) {
                itr1 = ((Map) itr2.next()).entrySet().iterator();
                Cliente newClient = new Cliente();
                while (itr1.hasNext()) {
                    Map.Entry pair = itr1.next();
                    if (pair.getKey().equals("Alias")) {
                        newClient.setAlias(pair.getValue().toString());
                    } else if (pair.getKey().equals("Nombre")) {
                        newClient.setNombre(pair.getValue().toString());
                    } else if (pair.getKey().equals("Primer Apellido")) {
                        newClient.setPrimerApellido(pair.getValue().toString());
                    } else if (pair.getKey().equals("Segundo Apellido")) {
                        newClient.setSegundoApellido(pair.getValue().toString());
                    } else if (pair.getKey().equals("Razon Social")) {
                        newClient.setRazonSocial(pair.getValue().toString());
                    } else if (pair.getKey().equals("rfc")) {
                        newClient.setRfc(pair.getValue().toString());
                    } else if (pair.getKey().equals("telefono")) {
                        newClient.setTelefono((int) Long.parseLong(pair.getValue().toString()));
                    } else if (pair.getKey().equals("correo")) {
                        newClient.setCorreo(pair.getValue().toString());
                    }
                }
                clientes.add(newClient);
            }

        } catch (ParseException ex) {
            Logger.getLogger(jsonConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(jsonConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(jsonConnector.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("");
        }
    }

    /*
    *
     */
    public void close() {
        PrintWriter pw = null;
        try {
            //Write Json
            JSONObject obj = new JSONObject();
            // Crea JSON ARRAY instanciando la clase correspondiente
            JSONArray ja = new JSONArray();
            //Inserta los clientes en el json
            clientes.forEach((clienteTMP) -> {
                //Componentes de cliente
                Map m = new LinkedHashMap(8);
                m.put("Alias", clienteTMP.getAlias());
                m.put("Nombre", clienteTMP.getNombre());
                m.put("Primer Apellido", clienteTMP.getPrimerApellido());
                m.put("Segundo Apellido", clienteTMP.getSegundoApellido());
                m.put("Razon Social", clienteTMP.getRazonSocial());
                m.put("rfc", clienteTMP.getRfc());
                m.put("telefono", clienteTMP.getTelefono());
                m.put("correo", clienteTMP.getCorreo());
                //Añade el cliente aal arreglo json
                ja.add(m);
            });
            // putting address to JSONObject
            obj.put("Clientes", ja);
            System.out.println("Escribi en el archivo");

            pw = new PrintWriter(FileName);
            pw.write(obj.toJSONString());
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(jsonConnector.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }

    }

    /**
     * @param clienteTMP
     * @return
     */
    public Boolean addClient(Cliente clienteTMP) {
        for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
            if (iterator.next().getAlias().equals(clienteTMP.getAlias())) {
                System.out.println("El Alias ya existe.");
                return false;
            }
        }
        clientes.add(clienteTMP);
        System.out.println("Agregado Correctamente");
        return true;
    }

    /**
     * Descripcion Esta funcion devuelve la lista de clientes
     *
     * @param clienteTMP
     */
    public Boolean deleteClient(Cliente clienteTMP) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente clienteBusqueda = clientes.get(i);
            if (clienteBusqueda.equals(clienteTMP)) {
                System.out.println("Cliente a Eliminar:" + clienteBusqueda.getAlias());
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Descripcion Esta funcion devuelve la lista de clientes
     *
     * @param clienteTMP
     */
    public Boolean modifyClient(Cliente clienteTMP, Cliente modClient) {

        for (int i = 0; i < clientes.size(); i++) {
            Cliente clienteBusqueda = clientes.get(i);
            if (clienteBusqueda.equals(clienteTMP)) {
                System.out.println("Cliente modificado:" + clienteBusqueda.getAlias());
                clientes.remove(i);
                clientes.add(i, modClient);
                return true;
            }
        }
        return false;
    }

    /**
     * Descripcion Esta funcion devuelve la lista de clientes
     *
     * @param clienteTMP
     */
    public Cliente searchClient(String busqueda) {
        for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
            Cliente clienteBusqueda = iterator.next();
            if (clienteBusqueda.getAlias().equals(busqueda)
                    || clienteBusqueda.getRfc().equals(busqueda)) {
                System.out.println("Resultado de busqueda :" + clienteBusqueda.getAlias());
                return clienteBusqueda;
            }
        }
        return null;
    }

    /**
     * Descripcion: Esta funcion devuelve la lista de clientes
     */
    public void listClients() {
        //lectura de los clientes
        clientes.forEach((clienteTMP) -> {
            System.out.println("Alias:" + clienteTMP.getAlias());
            System.out.println("Nombre" + clienteTMP.getNombre());
            System.out.println("Primer Apellido" + clienteTMP.getPrimerApellido());
            System.out.println("Segundo Apellido" + clienteTMP.getSegundoApellido());
            System.out.println("Razon Social" + clienteTMP.getRazonSocial());
            System.out.println("rfc" + clienteTMP.getRfc());
            System.out.println("telefono" + clienteTMP.getTelefono());
            System.out.println("correo" + clienteTMP.getCorreo());
            System.out.println("--------------------------------------------");
        });
    }
}
