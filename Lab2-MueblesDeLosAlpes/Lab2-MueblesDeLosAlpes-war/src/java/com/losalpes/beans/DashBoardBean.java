/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ $Id$
 * DashBoardBean.java Universidad de los Andes (Bogotá - Colombia) Departamento
 * de Ingeniería de Sistemas y Computación Licenciado bajo el esquema Academic
 * Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.losalpes.beans;

import com.losalpes.bos.TipoUsuario;
import com.losalpes.bos.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Managed bean encargado del dashboard el sistema
 *
 */
@ManagedBean
@SessionScoped
public class DashBoardBean implements Serializable {

    /**
     * Usuario con sesion iniciada
     */
    private Usuario usuario;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase
     */
    public DashBoardBean() {
    }

    /**
     * Post-Constructor de la clase busca el usuario que inicio sesión y que
     * esta almacenado en la sesion Http,
     */
    @PostConstruct
    public void inciar() {
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        usuario = (Usuario) sesion.getAttribute("Usuario");
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * Realiza la redireccion del sistema al módulo de muebles
     *
     * @return pagina Devuelve un string con el acceso a la nueva pagina de
     * muebles
     */
    public String muebles() {
        return "muebles";
    }

    /**
     * Realiza la redireccion del sistema al módulo de usuarios
     *
     * @return pagina Devuelve un string con el acceso a la nueva pagina de
     * usuarios
     */
    public String usuarios() {
        return "usuarios";
    }

    /**
     * Realiza la redireccion del sistema al módulo de carrito de compra
     *
     * @return pagina Devuelve un string con el acceso a la nueva pagina de
     * carrito de compra
     */
    public String carrito() {
        return "carrito";
    }

    /**
     * Realiza la redireccion del sistema al modulo de resportes de ventas
     *
     * @return pagina Devuelve un string con el acceso a la nueva pagina de
     * reportes de ventas
     */
    public String reportes() {
        return "reportes";
    }

    /**
     * Realiza la redireccion del sistema a la pagina de mi perfil
     *
     * @return pagina Devuelve un string con el acceso a la pagina del perfil
     */
    public String perfil() {
        return "perfil";
    }

    /**
     * Cierra la sesión actual y redirecciona a la pagina de login
     *
     * @return pagina Devuelve un string con el acceso a la pagina de login
     */
    public String cerrarCesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.removeAttribute("dashBoardBean");
        session.removeAttribute("carritoBean");
        session.removeAttribute("catalogoBean");
        session.removeAttribute("usuariosBean");
        session.removeAttribute("Usuario");
        return "cerrar";
    }

    /**
     * Retorna el usuario con sesión iniciada
     *
     * @return Usuario cono sesión iniciada
     */
    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isRenderCliente() {
        return usuario != null && usuario.getTipo().equals(TipoUsuario.CLIENTE);
    }

    public boolean isRenderAdministrador() {
        return usuario != null && usuario.getTipo().equals(TipoUsuario.ADMINISTRADOR);
    }
}
