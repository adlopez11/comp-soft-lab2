/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * Mueble.java Universidad de los Andes (Bogotá - Colombia) Departamento de
 * Ingeniería de Sistemas y Computación Licenciado bajo el esquema Academic Free
 * License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.bos;

import java.util.Objects;

/**
 * Clase que representa la información de un mueble en el sistema
 */
public class Mueble {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Referencia que identifica el modelo del mueble en el sistema.
     */
    private String referencia;

    /**
     * Nombre del mueble.
     */
    private String nombre;

    /**
     * Descripción del mueble.
     */
    private String descripcion;

    /**
     * Tipo de mueble.
     */
    private TipoMueble tipo;

    /**
     * Valor del mueble.
     */
    private Double valor;

    /**
     * Indica si el mueble fue seleccionado
     */
    private boolean seleccion;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------
    /**
     * Constructor sin argumentos de la clase
     */
    public Mueble() {

    }

    /**
     * Constructor de la clase. Inicializa los atributos con los valores que
     * ingresan por parametro.
     *
     * @param referencia Referencia del mueble
     * @param nombre Nombre del mueble
     * @param descripcion Descripión del mueble
     * @param tipo Tipo de mueble
     * @param valor Valor de mueble
     */
    public Mueble(String referencia, String nombre, String descripcion, TipoMueble tipo, Double valor) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor = valor;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    /**
     * Devuelve la descripción del mueble
     *
     * @return descripcion Descripción del mueble
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Modifica la descripción del mueble
     *
     * @param descripcion Nueva descripción del mueble
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el nombre del mueble
     *
     * @return nombre Nombre del mueble
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del mueble
     *
     * @param nombre Nuevo nombre del mueble
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la referencia del mueble
     *
     * @return referencia Referencia del mueble
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Modifica la referencia del mueble
     *
     * @param referencia Nueva referencia del mueble
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * Devuelve el tipo de mueble
     *
     * @return tipo Tipo de mueble
     */
    public TipoMueble getTipo() {
        return tipo;
    }

    /**
     * Modifica el tipo de mueble
     *
     * @param tipo Nuevo tipo de mueble
     */
    public void setTipo(TipoMueble tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el estado de selección del mueble
     *
     * @return seleccion Verdadero o falso
     */
    public boolean isSeleccion() {
        return seleccion;
    }

    /**
     * Cambia el estado de selección de un mueble
     *
     * @param seleccion Nuevo estado de selección
     */
    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Metodo que crea el codigo Hash a partir del campo Referencia
     *
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.referencia);
        return hash;
    }

    /**
     * Metodo que compara de dos intancias de mueble por el campo Referencia
     *
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mueble other = (Mueble) obj;
        if (!Objects.equals(this.referencia, other.referencia)) {
            return false;
        }
        return true;
    }

}
