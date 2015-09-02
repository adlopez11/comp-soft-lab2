/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * CatalogoBean.java Universidad de los Andes (Bogotá - Colombia) Departamento
 * de Ingeniería de Sistemas y Computación Licenciado bajo el esquema Academic
 * Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.beans;

import com.losalpes.bos.Venta;
import com.losalpes.servicios.IServicioVenta;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 * Managed bean encargado del manejo del carrito de compras
 *
 */
@ManagedBean
@SessionScoped
public class CarritoBean implements Serializable {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Relación con la interfaz que provee los servicios necesarios de las
     * ventas.
     */
    private IServicioVenta venta;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase principal
     */
    public CarritoBean() {
    }

    /**
     * PostConstruct donde se incializa el la lista de ventas, que se encuentra
     * en la unica fuente de datos en bean de aplicaición DatosBean
     */
    @PostConstruct
    public void inicializar() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        DatosBean datos = (DatosBean) servletContext.getAttribute("datosBean");
        venta = datos.getVentas();
    }

    /**
     * Devuelve una lista con todos los muebles del sistema
     *
     * @return muebles Muebles del sistema
     */
    public List<Venta> getVentas() {

        return venta.getVentas();
    }
}
