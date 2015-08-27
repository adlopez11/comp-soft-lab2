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
import com.losalpes.servicios.ServicioSeguridadMock;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 * Managed bean encargado de la administración de usuarios
 *
 */
@ManagedBean
public class UsuarioBean {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Representa un nuevo usuario a ingresar
     */
    private Usuario usuario;

    /**
     * Relación con la interfaz que provee los servicios necesarios de
     * la seguridad.
     */
    private final IServicioSeguridad seguridad;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase principal
     */
    public UsuarioBean() {
        usuario = new Usuario();
        seguridad = new ServicioSeguridadMock();
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
    public void agregarUsuario() {
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

}
