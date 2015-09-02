/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * Venta.java Universidad de los Andes (Bogotá - Colombia) Departamento de
 * Ingeniería de Sistemas y Computación Licenciado bajo el esquema Academic Free
 * License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.bos;

/**
 * Clase que representa la venta de un mueble
 */
public class Venta {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Referencia que identifica el mueble vendido
     */
    private Mueble mueble;

    /**
     * Referencia que identifica el cliente que lo compro
     */
    private Usuario cliente;

    /**
     * Cantidad de muebles comprados del mismo tipo
     */
    private int cantidad;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------
    /**
     * Constructor sin argumentos de la clase
     */
    public Venta() {

    }

    /**
     * Constructor de la clase. Inicializa los atributos con los valores que
     * ingresan por parametro.
     *
     * @param mueble
     * @param cliente
     * @param cantidad
     */
    public Venta(Mueble mueble, Usuario cliente, int cantidad) {
        this.mueble = mueble;
        this.cliente = cliente;
        this.cantidad = cantidad;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    /**
     * Devuelve el mueble
     *
     * @return El mueble
     */
    public Mueble getMueble() {
        return mueble;
    }

    /**
     * Modifica el mueble
     *
     * @param mueble Nuevo mueble
     */
    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    /**
     * Devuelve el mueble
     *
     * @return El mueble
     */
    public Usuario getCliente() {
        return cliente;
    }

    /**
     * Modifica el Cliente
     *
     * @param cliente Nuevo cliente
     */
    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna la cantidad Vendida
     *
     * @return cantidad ventida
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Modifica la cantidad vendida
     *
     * @param cantidad nueva cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
