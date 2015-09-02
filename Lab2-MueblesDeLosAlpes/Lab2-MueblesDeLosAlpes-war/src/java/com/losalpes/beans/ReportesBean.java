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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 * Managed bean encargado del manejo de los reportes
 *
 */
@ManagedBean
@SessionScoped
public class ReportesBean implements Serializable {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Relación con la interfaz que provee el servicio con las ventas realizadas
     */
    private IServicioVenta ventas;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase principal
     */
    public ReportesBean() {
    }

    /**
     * PostConstruct donde se incializa el la lista de muebles del catalogo, que
     * se encuentra en la unica fuente de datos en bean de aplicaición DatosBean
     */
    @PostConstruct
    public void inicializar() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        DatosBean datos = (DatosBean) servletContext.getAttribute("datosBean");
        ventas = datos.getVentas();
    }

    /**
     * Devuelve una lista con todos las ventas
     *
     * @return muebles Muebles del sistema
     */
    public List<Venta> getVentas() {

        return ventas.getVentas();
    }

    /**
     * Devuelve la suma total de ventas
     *
     * @return muebles Muebles del sistema
     */
    public Double getValorTotal() {

        List<Venta> ve = ventas.getVentas();
        Double total = 0d;

        for (Venta venta : ve) {
            total += ((double) venta.getCantidad() * venta.getMueble().getValor());
        }

        return total;
    }

    public String fechaTexto(final Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return sdf.format(date);
    }
}
