/*Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Login.Logica;


import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Controlador {
    private final ConexionBD con;

    public Controlador() {
        this.con = new ConexionBD();
    }
    
    
    public void crearConexion() throws SQLException{
this.con.establecerConexion();
}
    
    public ResultSet mandarQUERY(String sql) throws SQLException{
ResultSet aux_result=this.con.ejecutaSentenciaQuery(sql);
return aux_result;
}
public int mandarSQL(String sql) throws SQLException{
int aux=this.con.ejecutaSentenciaSql(sql);
return aux;
}

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
