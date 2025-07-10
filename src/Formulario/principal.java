/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formulario;

import Login.Logica.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class principal {
    public static Controlador control;
    public static ResultSet rs;
    public static int res;
    
    public static void main(String[] args) {
        try{
                control =new Controlador();
                control.crearConexion();
                
        }catch (SQLException ex){
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
}
    }
}
    
