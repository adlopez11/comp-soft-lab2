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

import javax.faces.bean.ManagedBean;

/**
 * Managed bean encargado del dashboard el sistema
 *
 */
@ManagedBean
public class DashBoardBean {

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    /**
     * Constructor de la clase
     */
    public DashBoardBean() {
        //servicio=new ServicioSeguridadMock();
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    /**
     * Realiza la redireccion del sistema al módulo de muebles
     *
     * @return pagina Devuelve un string con el acceso a la nueva pagina de muebles
     */
    public String muebles() {
        return "muebles";
    }
    
    /**
     * Realiza la redireccion del sistema al módulo de usuarios
     *
     * @return pagina Devuelve un string con el acceso a la nueva pagina de usuarios
     */
    public String usuarios() {
        return "usuarios";
    }

    /**
     * Realiza la redireccion del sistema al módulo de carrito de compra
     *
     * @return pagina Devuelve un string con el acceso a la nueva pagina de carrito de compra
     */
    public String carrito() {
        return "carrito";
    }
}
