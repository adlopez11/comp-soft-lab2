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
import com.losalpes.bos.TipoMueble;
import com.losalpes.servicios.IServicioCatalogo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

/**
 * Managed bean encargado del catálogo de muebles en el sistema
 *
 */
@ManagedBean
@SessionScoped
public class CatalogoBean implements Serializable {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Representa un nuevo mueble a ingresar
     */
    private Mueble mueble;

    /**
     * Relación con la interfaz que provee los servicios necesarios del
     * catálogo.
     */
    private IServicioCatalogo catalogo;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase principal
     */
    public CatalogoBean() {
        mueble = new Mueble();
    }

    /**
     * PostConstruct donde se incializa el catalogo de muebles, que se encuentra
     * en la unica fuente de datos en bean de aplicaición DatosBean
     */
    @PostConstruct
    public void inicializar() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        DatosBean datos = (DatosBean) servletContext.getAttribute("datosBean");
        catalogo = datos.getCatalogo();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    /**
     * Devuelve el objeto mueble
     *
     * @return mueble Objeto mueble
     */
    public Mueble getMueble() {
        return mueble;
    }

    /**
     * Modifica el objeto mueble
     *
     * @param mueble Nuevo mueble
     */
    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    /**
     * Devuelve una lista con todos los muebles del sistema
     *
     * @return muebles Muebles del sistema
     */
    public List<Mueble> getMuebles() {

        return catalogo.darMuebles();
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * Agrega un nuevo mueble al sistema
     */
    public void agregarMueble() {
        catalogo.agregarMueble(mueble);
        mueble = new Mueble();
    }

    /**
     * Elimina la información del mueble
     */
    public void limpiar() {
        mueble = new Mueble();
    }

    /**
     * Devuelve los tipos de muebles
     *
     * @return sitems Tipos de muebles en el sistema
     */
    public SelectItem[] getTiposMuebles() {
        TipoMueble[] tipos = TipoMueble.values();
        SelectItem[] sitems = new SelectItem[tipos.length];

        for (int i = 0; i < sitems.length; i++) {
            sitems[i] = new SelectItem(tipos[i]);
        }
        return sitems;
    }

}
