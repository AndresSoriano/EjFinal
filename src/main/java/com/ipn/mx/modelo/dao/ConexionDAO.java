package com.ipn.mx.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Soriano
 */
public class ConexionDAO {
    
    private Connection conexion;
    public Connection conectar(){
        //String user = "xeuypkajvsxnme";
        //String pwd = "8a7dbc29094673aa7ffe757ccf3b91b8efa90dcae15a2df8d3517d226ada74ba";
        //String url="jdbc:postgresql://ec2-174-129-37-144.compute-1.amazonaws.com:5432/d52fhuga0cbijr";
        //String pgDriver = "org.postgresql.Driver";
        
        String user = "djsdmffucjsloe";
        String pwd = "698576154e2a24eeb1abbd7bc141385d70793b0821781f4ef48dbe2e06f51b48";
        String url = "jdbc:postgresql://ec2-3-233-55-123.compute-1.amazonaws.com:5432/dfrhst85f9q4tq";
        String pgDriver = "org.postgresql.Driver";
        
        try{
            Class.forName(pgDriver);
            conexion = DriverManager.getConnection(url, user, pwd);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conexion;
    }
}