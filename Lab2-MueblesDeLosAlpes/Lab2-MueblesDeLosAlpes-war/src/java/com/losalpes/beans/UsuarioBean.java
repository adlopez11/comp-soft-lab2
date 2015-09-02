/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * UsuarioBean.java Universidad de los Andes (Bogotá - Colombia) Departamento de
 * Ingeniería de Sistemas y Computación Licenciado bajo el esquema Academic Free
 * License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.beans;

import com.losalpes.bos.TipoUsuario;
import com.losalpes.bos.Usuario;
import com.losalpes.servicios.IServicioSeguridad;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 * Managed bean encargado de la administración de usuarios
 *
 */
@ManagedBean
public class UsuarioBean implements Serializable {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Representa un nuevo usuario a ingresar
     */
    private Usuario usuario;

    /**
     * Representa el usuario seleccionado
     */
    private Usuario usuarioSeleccionado;

    /**
     * Relación con la interfaz que provee los servicios necesarios de la
     * seguridad.
     */
    private IServicioSeguridad seguridad;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase principal
     */
    public UsuarioBean() {
        usuario = new Usuario();
    }

    /**
     * PostConstruct donde se incializa el servicio de usuarios, que se
     * encuentra en la unica fuente de datos en bean de aplicaición DatosBean
     */
    @PostConstruct
    public void inicializar() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        DatosBean datos = (DatosBean) servletContext.getAttribute("datosBean");
        seguridad = datos.getServicio();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    /**
     * Devuelve el objeto usuario
     *
     * @return usuario Objeto usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Modifica el objeto usuario
     *
     * @param usuario Nuevo usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve una lista con todos los usuarios del sistema
     *
     * @return usuario Usuarios del sistema
     */
    public List<Usuario> getUsuarios() {

        return seguridad.darUsuarios();
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * Agrega un nuevo usuario al sistema
     */
    public void guardarUsuario() {
//        seguridad
        seguridad.agregarUsuario(usuario);
        usuario = new Usuario();
    }

    /**
     * Elimina la información del usuario
     */
    public void limpiar() {
        usuario = new Usuario();
    }

    /**
     * Devuelve los tipos de usuarios
     *
     * @return sitems Tipos de usuarios en el sistema
     */
    public SelectItem[] getTiposUsuario() {
        TipoUsuario[] tipos = TipoUsuario.values();
        SelectItem[] sitems = new SelectItem[tipos.length];

        for (int i = 0; i < sitems.length; i++) {
            sitems[i] = new SelectItem(tipos[i]);
        }
        return sitems;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public void onRowSelect(SelectEvent event) {
        /* FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
         FacesContext.getCurrentInstance().addMessage(null, msg);*/
    }

    public void onRowUnselect(UnselectEvent event) {
        /* FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
         FacesContext.getCurrentInstance().addMessage(null, msg);*/
    }
}
