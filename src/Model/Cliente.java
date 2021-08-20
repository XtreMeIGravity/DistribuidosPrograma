/*
 * Practica 1 Software Engineering IPN
 * Nombre del alumno: David Lopez Hernandez
 * Descripcion del archivo: Archivo principal
 * que gestiona las funciones crud
 * 
 */
package Model;

/**
 * <h1> Cliente </h1>
 * Esta es la clase de la entidad Cliente
 *
 * @author David Lopez Hernandez
 * @since 18-08-2021
 */
public class Cliente {

    private String alias;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String razonSocial;
    private String rfc;
    private long telefono;
    private String Correo;

    public Cliente(String alias, String nombre, String primerApellido, String segundoApellido, String razonSocial, String rfc, long telefono, String Correo) {
        this.alias = alias;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.telefono = telefono;
        this.Correo = Correo;
    }

    public Cliente() {
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the primerApellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * @param primerApellido the primerApellido to set
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * @return the segundoApellido
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * @param segundoApellido the segundoApellido to set
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @param razonSocial the razonSocial to set
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the telefono
     */
    public long getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return Correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

}
