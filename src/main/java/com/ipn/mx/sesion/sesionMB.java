/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.sesion;

import com.ipn.mx.modelo.dao.UsuarioDAO;
import com.ipn.mx.modelo.entidades.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author leoj_
 */
@Singleton
@ManagedBean(name = "sesionMB")
@SessionScoped
public class sesionMB implements Serializable {
    private static sesionMB sesionmb;
    
    
    private String nombreUsuario = "";
    private String password = "";
    private final Sesion sesion;

    private static final Logger logger = Logger.getLogger(sesionMB.class.getName());

    public sesionMB() {
        logger.log(Level.INFO, "Creando el SesionSB .. !!!!!: ");
        sesion = new Sesion();
    }

    public static sesionMB getInstance(){
        if(sesionmb == null){
            sesionmb = new sesionMB();
        }
        return sesionmb;
    }
    
    public String preparedLogin() {
        if (sesion.getAttrRequest("usuario") == null) {
            return "login.xhtml?faces-redirect=true";
        }
        //REDIRECCIONAR AL INICIO
        return "index.xhtml?faces-redirect=true";
    }

    public String vaidarCredenciales() {
        logger.log(Level.INFO, "validando datos...: ");

        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios = dao.readAll();

        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario user = listaUsuarios.get(i);
            if (nombreUsuario.equals(user.getNombreUsuario())
                    && password.equals(user.getClaveUsuario())) {
                //Credenciales validas
                sesion.setAttrRequest("usuario", user);
//                return "/usuario/listadoUsuarios?faces-redirect=true";
                return "index.xhtml?faces-redirect=true";
            } else {
                //Credenciales incorrectas
            }
        }
        //REDIRECCIONAR AL INICIO
        sesion.getSession().invalidate();
        return "errorLogin.xhtml?faces-redirect=true";
    }

    public String getNombreUsuarioActivo() {
        Usuario usuario = (Usuario) sesion.getAttrSession("usuario");
        return usuario.getNombre();
    }

    public boolean isActiveSesion() {
        Usuario usuario = (Usuario) sesion.getAttrRequest("usuario");
        if (usuario == null) {
            return false;
        }
        return true;
    }

    public String cerrarSesion() {
        logger.log(Level.INFO, "Entrando a cerrar sesion: ");

        sesion.getSession().invalidate();

        //REDIRECCIONAR AL INICIO
        return "index.xhtml?faces-redirect=true";
    }

    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Cerrando Sesion!!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 

}
