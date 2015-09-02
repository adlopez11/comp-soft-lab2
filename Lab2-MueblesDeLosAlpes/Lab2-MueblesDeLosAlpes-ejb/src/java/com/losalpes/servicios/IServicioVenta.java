/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * IServicioVenta.java Universidad de los Andes (Bogotá - Colombia) Departamento
 * de Ingeniería de Sistemas y Computación Licenciado bajo el esquema Academic
 * Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.servicios;

import com.losalpes.bos.Venta;
import java.util.List;

/**
 * Contrato funcional de los servicios que se le prestan al catálogo
 */
public interface IServicioVenta {

    /**
     * Agrega una venta al sistema
     *
     * @param venta Nueva Venta
     */
    public void agregarVenta(Venta venta);

    /**
     * Devuelve todos las ventas del sistema
     *
     * @return muebles Lista de ventas
     */
    public List<Venta> getVentas();

}
