/*Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Login.Logica;
/**
*
**/
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;



//clase conexion
public class ConexionBD {

    public static com.sun.jdi.connect.spi.Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private Connection conn;
private Statement sentencia;
private final String controlador;
private final String nombreBD;
private final String usuarioBD;
private final String claveBD;

      public ConexionBD(){
        this.controlador="sun.jdbc.odbc.JdbcOdbcDriver";
        this.nombreBD="C:\\Users\\Admin\\Documents\\NetBeansProjects\\inventario\\BD\\Inventario_Muebles.accdb";
        this.usuarioBD="";
        this.claveBD="";
    }

  //establñecer conexion
public boolean establecerConexion() throws SQLException{
    try{
        conn=DriverManager.getConnection("jdbc:ucanaccess://"+this.nombreBD,this.usuarioBD,this.claveBD);
    }catch (SQLException e) {
    JOptionPane.showMessageDialog(null,"Error al realizar la conexión "+e);
    return false;
}
    try{
this.sentencia=this.conn.createStatement(
ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_READ_ONLY);
}catch (SQLException e){
JOptionPane.showMessageDialog(null,
"Error al crear el objeto sentencia "+ e);
return false;
}
return true;      
}

public ResultSet ejecutaSentenciaQuery(String sql) throws SQLException{
ResultSet rs;
rs=this.sentencia.executeQuery(sql);
return rs;
}
public int ejecutaSentenciaSql(String sql) throws SQLException{
int res;
res=this.sentencia.executeUpdate(sql);
return res;
}
    








    
}
