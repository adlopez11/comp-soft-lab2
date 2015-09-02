/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * LoginBean.java Universidad de los Andes (Bogotá - Colombia) Departamento de
 * Ingeniería de Sistemas y Computación Licenciado bajo el esquema Academic Free
 * License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.beans;

import com.losalpes.servicios.IServicioCatalogo;
import com.losalpes.servicios.IServicioSeguridad;
import com.losalpes.servicios.IServicioVenta;
import com.losalpes.servicios.ServicioCatalogoMock;
import com.losalpes.servicios.ServicioSeguridadMock;
import com.losalpes.servicios.ServicioVentaMock;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Managed bean de Aplicacion encargado de almacenar un unico catalogo de
 * muebles, un unico servicio de usuario y un unico listado de Ventas. De esta
 * forma el sistema tiene una sola fuente de datos para todos los demas
 * ManagedBean. Este bean es inicializado cuando incia el servidor por eso se
 * coloca el atributo (eager=true)
 *
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class DatosBean implements Serializable {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Relación con la interfaz adecuada para la autenticación de usuarios
     */
    private final IServicioSeguridad servicio;

    /**
     * Relación con la interfaz que provee los servicios necesarios del
     * catálogo.
     */
    private final IServicioCatalogo catalogo;

    /**
     * Relación con la interfaz que provee las ventas realizadas
     */
    private final IServicioVenta ventas;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase
     */
    public DatosBean() {
        System.out.println("Inicio la aplicación");
        servicio = new ServicioSeguridadMock();
        catalogo = new ServicioCatalogoMock();
        ventas = new ServicioVentaMock();
    }

    /**
     * Retorna el Servicio de Usuarios
     *
     * @return
     */
    public IServicioSeguridad getServicio() {
        return servicio;
    }

    /**
     * Retorna el catalogo de muebles
     *
     * @return servicio de muebles
     */
    public IServicioCatalogo getCatalogo() {
        return catalogo;
    }

    /**
     * Retorna el servicio de ventas
     *
     * @return servicio venta
     */
    public IServicioVenta getVentas() {
        return ventas;
    }
}
