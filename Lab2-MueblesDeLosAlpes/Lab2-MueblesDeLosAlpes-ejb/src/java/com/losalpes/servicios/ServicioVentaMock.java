/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * ServicioCatalogoMock.java Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación Licenciado bajo el
 * esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.servicios;

import com.losalpes.bos.Venta;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion de los servicios del listado de ventas que se le prestan al
 * sistema. [Mock Object]
 *
 */
public class ServicioVentaMock implements IServicioVenta {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Arreglo con las ventas del sistema
     */
    private final ArrayList<Venta> ventas;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioVentaMock() {

        //Inicializa el arreglo de ventas
        ventas = new ArrayList<Venta>();
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * Agrega una venta al sistema
     *
     * @param venta Nueva venta
     */
    @Override
    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    /**
     * Devuelve las ventas del sistema
     *
     * @return ventas Arreglo con todos las ventas del sistema
     */
    @Override
    public List<Venta> getVentas() {
        return ventas;
    }

}
