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

import com.losalpes.bos.Mueble;
import com.losalpes.bos.Usuario;
import com.losalpes.bos.Venta;
import com.losalpes.servicios.IServicioCatalogo;
import com.losalpes.servicios.IServicioVenta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

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

    /**
     * Relación con la interfaz que provee el servicio con las ventas realizadas
     */
    private IServicioVenta ventas;

    /**
     * Relación con la interfaz que provee los servicios necesarios del
     * catálogo.
     */
    private final List<Venta> carrito;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase principal
     */
    public CarritoBean() {
        carrito = new ArrayList<>();
    }

    /**
     * PostConstruct donde se incializa el la lista de muebles del catalogo, que
     * se encuentra en la unica fuente de datos en bean de aplicaición DatosBean
     */
    @PostConstruct
    public void inicializar() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        DatosBean datos = (DatosBean) servletContext.getAttribute("datosBean");
        catalogo = datos.getCatalogo();
        ventas = datos.getVentas();
    }

    /**
     * Devuelve una lista con todos los muebles del sistema
     *
     * @return muebles Muebles del sistema
     */
    public List<Venta> getVentas() {

        return venta.getVentas();
    }

    /**
     * Agrega un articulo al carrito
     *
     * @param mueble Mueble a agregar
     */
    public void agregar(final Mueble mueble) {
        boolean existe = false;
        for (Venta venta : carrito) {
            if (venta.getMueble().equals(mueble)) {
                venta.setCantidad(venta.getCantidad() + 1);
                existe = true;
            }
        }
        if (!existe) {
            Venta venta = new Venta();
            venta.setCantidad(1);
            venta.setMueble(mueble);
            carrito.add(venta);
        }
    }

    /**
     * metodo que simula un pago y agrega los articulos del carrito a lista de
     * ventas
     *
     */
    public String pagar() {
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Usuario usuario = (Usuario) sesion.getAttribute("Usuario");

        for (Venta venta : carrito) {
            venta.setCliente(usuario);
            venta.setFecha(new Date());
            ventas.agregarVenta(venta);
        }
        carrito.clear();
        return "pagado";
    }

    /**
     * Total de articulos agregados al carrito
     *
     * @return Total de articulos agregados al carrito
     */
    public String getTotalArticulos() {
        int total = 0;

        for (Venta venta : carrito) {
            total += venta.getCantidad();
        }
        return String.valueOf(total);
    }

    /**
     * Total de articulos agregados al carrito
     *
     * @return Total de articulos agregados al carrito
     */
    public Double getTotalCosto() {
        Double total = 0d;

        for (Venta venta : carrito) {
            total += (venta.getMueble().getValor() * (double) venta.getCantidad());
        }
        return total;
    }

    /**
     * Retorna la lista de muebles vendidos
     *
     * @return Lista de tipos de muebles vendidos
     */
    public List<Venta> getCarrito() {
        return carrito;
    }

    public boolean isSeleccionados() {
        return !carrito.isEmpty();
    }
}
