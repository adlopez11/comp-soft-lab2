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

import com.losalpes.bos.Usuario;
import com.losalpes.excepciones.AutenticacionException;
import com.losalpes.servicios.IServicioSeguridad;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * Managed bean encargado de la autenticación en el sistema
 *
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Nombre del usuario
     */
    private String usuario;

    /**
     * Contraseña del usuario
     */
    private String contraseña;

    /**
     * Relación con la interfaz adecuada para la autenticación de usuarios
     */
    private IServicioSeguridad servicio;

    /**
     * Determina si existe error o no
     */
    private boolean error;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase
     */
    public LoginBean() {
        error = false;
    }

    /**
     * PostConstruct donde se incializa el servicio de usuarios, que se
     * encuentra en la unica fuente de datos en bean de aplicaición DatosBean
     */
    @PostConstruct
    public void inicializar() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        DatosBean datos = (DatosBean) servletContext.getAttribute("datosBean");
        servicio = datos.getServicio();
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * Realiza la autenticación de un usuario que desea entrar al sistema guarda
     * el modelo de servicio de seguridad en sesion, ya que contiene la lista de
     * usuarios es decir de clientes
     *
     * @return tipoUsuario Devuelve el tipo de usuario
     */
    public String login() {

        try {
            Usuario user = servicio.login(usuario, contraseña);
            contraseña = null;
            if (user != null) {
                HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                sesion.setAttribute("Usuario", user);
                return "login";
            } else {
                return "";
            }
        } catch (AutenticacionException ex) {
            error = true;
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), "");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    /**
     * Devuelve el nombre del usuario
     *
     * @return usuario Nombre del usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Modifica el nombre del usuario
     *
     * @param usuario Nuevo nombre del usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve la contraseña del usuario
     *
     * @return contraseña Contraseña del usuario
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Modifica la contraseña de un usuario
     *
     * @param contraseña Nueva contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Devuelve el estado de la autenticación (si es error o no)
     *
     * @return error Estado de autenticación
     */
    public boolean isError() {
        return error;
    }

    /**
     * Modifica el estado de error
     *
     * @param error Nuevo estado
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * Cierra el panel de error
     */
    public void cerrarPanelError() {
        error = false;
    }
}
