package com.ipn.mx.controlador.web;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 * @author Soriano
 */
@ManagedBean(name = "indexMB")
@SessionScoped
public class IndexMB extends BaseBean implements Serializable {

    private boolean msg = false;
    private String mensaje = "";
    private String alert = "";

    /* Creates a new instance of ProductoMB */
    public IndexMB() {
    }

    @PostConstruct
    public void init(){

    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public boolean isMsg() {
        return msg;
    }

    public void setMsg(boolean msg) {
        this.msg = msg;
    }


    public String preparedIndex(){
        return "index?faces-redirect=true";
    }

    public String preparedListadoProductos(){
        return "listadoProductos?faces-redirect=true";
    }

    public String preparedListadoCategorias(){
        return "listadoCategorias?faces-redirect=true";
    }

    public String preparedListadoUsuarios(){
        return "listadoUsuarios?faces-redirect=true";
    }

    public void resetarMensaje(){
        msg=false;
        mensaje="";
        alert="";
    }
}