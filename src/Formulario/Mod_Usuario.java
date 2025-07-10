/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formulario;

import Login.Logica.*;
import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author yorsu
 */
public class Mod_Usuario extends javax.swing.JFrame {
    
    public static Controlador control;
    public static ResultSet rs;
    public static int res;
    public static int IdUsuario;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Mod_Usuario.class.getName());

    /**
     * Creates new form Mod_Usuario
     */
    public Mod_Usuario() {
        initComponents();
        cargarUsuariosEnComboBox();
    }
public void cargarUsuariosEnComboBox() {
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(); // Crea un nuevo modelo
    
    try {
        // Asumiendo que 'control' y 'crearConexion()' son accesibles aquí
        control = new Controlador(); 
        control.crearConexion(); 

        String sql = "SELECT nom_usuario FROM Usuario ORDER BY nom_usuario ASC"; // Ordena alfabéticamente

        ResultSet rs = control.mandarQUERY(sql);

        while (rs.next()) {
            model.addElement(rs.getString("nom_usuario")); // Añade cada nombre de usuario al modelo
        }

        cbbUSU.setModel(model); // Establece el nuevo modelo al JComboBox
        
    } catch (SQLException ex) {
        Logger.getLogger(Mod_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al cargar usuarios en el ComboBox: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Importante: Cerrar ResultSet si se abrió aquí
        try {
            if (rs != null) rs.close();
            // Si control.crearConexion() abre una conexión que debe cerrarse, hazlo aquí:
            // if (control != null) control.cerrarConexion(); 
        } catch (SQLException e) {
            Logger.getLogger(Mod_Usuario.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new EstilosPanel.GradientPanel(
            new java.awt.Color(63, 81, 110),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(41, 128, 185),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(127, 179, 213));
        jPanel2 = new EstilosPanel.GradientPanel(
            new java.awt.Color(97, 106, 107),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(204, 209, 209),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(234, 242, 248) );
        jLabel4 = new javax.swing.JLabel();
        btBuscar = new EstilosBotones.GradientButton(
            "BUSCAR USUARIO", // El texto del botón
            new java.awt.Color(63, 81, 110), // Color inicial
            new java.awt.Color(41, 128, 185));
        cbbUSU = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btModificar = new EstilosBotones.GradientButton(
            "MODIFICAR USUARIO", // El texto del botón
            new java.awt.Color(131, 145, 146), // Color inicial
            new java.awt.Color(213, 219, 219 ));
        btVolver = new EstilosBotones.GradientButton(
            "VOLVER AL MENU", // El texto del botón
            new java.awt.Color(131, 145, 146), // Color inicial
            new java.awt.Color(213, 219, 219 ));
        tfUsuario = new javax.swing.JTextField();
        tfClave = new javax.swing.JTextField();
        tfMail = new javax.swing.JTextField();
        tfRol = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(63, 81, 110));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nombre de Usuario:");

        btBuscar.setBackground(new java.awt.Color(63, 81, 110));
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/buscarUser.png"))); // NOI18N
        btBuscar.setText("BUSCAR USUARIO");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        cbbUSU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Bodega1", "Ventas1", "Diego", "yorsua", "jonathan", "carlos" }));
        cbbUSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbUSUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbbUSU, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btBuscar)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btBuscar)
                    .addComponent(cbbUSU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/capsule2.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("SISTEMA DE INVENTARIO");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Modificación de usuario");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Usuario:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Clave:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Correo");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Rol:");

        btModificar.setBackground(new java.awt.Color(153, 153, 153));
        btModificar.setForeground(new java.awt.Color(51, 51, 51));
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/editarusuario.png"))); // NOI18N
        btModificar.setText("MODIFICAR USUARIO");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        btVolver.setBackground(new java.awt.Color(153, 153, 153));
        btVolver.setForeground(new java.awt.Color(51, 51, 51));
        btVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/volver-flecha 20px.png"))); // NOI18N
        btVolver.setText("VOLVER AL MENU");
        btVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVolverActionPerformed(evt);
            }
        });

        tfClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfClaveActionPerformed(evt);
            }
        });

        tfMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(85, 85, 85))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfRol)
                    .addComponent(tfMail)
                    .addComponent(tfClave)
                    .addComponent(tfUsuario)
                    .addComponent(btModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btModificar)
                .addGap(18, 18, 18)
                .addComponent(btVolver)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfClaveActionPerformed

    private void tfMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMailActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
            try {
        control = new Controlador();
        control.crearConexion();
    } catch (SQLException ex) {
        Logger.getLogger(Mod_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
        return;
    }
            try {
    String usuarioSeleccionado = cbbUSU.getSelectedItem().toString();

    String sql = "SELECT u.Id_usuario, u.nom_usuario, u.contraseña, u.correo, r.Nombre_rol AS ROL "
               + "FROM Usuario u "
               + "INNER JOIN Roles r ON u.id_rol = r.Id_rol "
               + "WHERE u.nom_usuario = '" + usuarioSeleccionado + "'";

    ResultSet rs = control.mandarQUERY(sql);

    if (rs.next()) {
        IdUsuario = rs.getInt("Id_usuario");
        tfUsuario.setText(rs.getString("nom_usuario"));
        tfMail.setText(rs.getString("correo"));
        tfRol.setText(rs.getString("ROL"));
        tfClave.setText(rs.getString("contraseña"));
    } else {
        JOptionPane.showMessageDialog(null, "Usuario no encontrado.", "Búsqueda de Usuario", JOptionPane.INFORMATION_MESSAGE);
    }

} catch (SQLException ex) {
    Logger.getLogger(Mod_Usuario.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "Error al buscar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
} finally {
    try {
        if (rs != null) {
            rs.close();
        }
    } catch (SQLException e) {
        Logger.getLogger(Mod_Usuario.class.getName()).log(Level.SEVERE, null, e);
    }
}
            

 
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
      try {
    control = new Controlador();
    control.crearConexion();

    // 1. Obtener el Id_rol basado en el nombre del rol seleccionado
    String nomRolSeleccionado = tfRol.getText(); // Asumo que el nombre del rol se escribe en tfRol
    int idRolNuevo = -1; // Valor predeterminado para indicar que no se encontró el rol

    String sqlGetRolId = "SELECT Id_rol FROM Roles WHERE Nombre_rol = '" + nomRolSeleccionado + "'";
    ResultSet rsRol = control.mandarQUERY(sqlGetRolId);

    if (rsRol.next()) {
        idRolNuevo = rsRol.getInt("Id_rol");
    } else {
        JOptionPane.showMessageDialog(null, "El rol '" + nomRolSeleccionado + "' no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Sale del método si el rol no existe
    }
    
    // Cierra el ResultSet del rol para liberar recursos
    if (rsRol != null) {
        rsRol.close();
    }

    // 2. Construir la consulta UPDATE incluyendo el id_rol
    String sql_upd = "UPDATE Usuario SET "
            + "nom_usuario = '" + tfUsuario.getText() + "', "
            + "contraseña = '" + tfClave.getText() + "', "
            + "correo = '" + tfMail.getText() + "', "
            + "id_rol = " + idRolNuevo + " " // ¡CORREGIDO: Se añade la actualización del id_rol!
            + "WHERE Id_usuario = " + IdUsuario;

    int res = control.mandarSQL(sql_upd);

    if (res > 0) {
        JOptionPane.showMessageDialog(null, "Modificación Exitosa");
    } else if (res == 0) {
        JOptionPane.showMessageDialog(null, "No se encontró el usuario para modificar o no se realizaron cambios.");
    } else {
        JOptionPane.showMessageDialog(null, "ERROR en la operación de modificación.");
    }

} catch (SQLException ex) {
    Logger.getLogger(Mod_Usuario.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "Error al modificar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
} finally {
    // Asegúrate de cerrar la conexión si control.crearConexion() la abre de forma exclusiva para este método.
    // if (control != null) { control.cerrarConexion(); }
}
    }//GEN-LAST:event_btModificarActionPerformed

    private void btVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVolverActionPerformed
        Menu menu = new Menu();
    menu.setVisible(true);
    menu.setLocationRelativeTo(null);
    this.dispose();
    }//GEN-LAST:event_btVolverActionPerformed

    private void cbbUSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbUSUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbUSUActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
          FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Mod_Usuario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btVolver;
    private javax.swing.JComboBox<String> cbbUSU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfClave;
    private javax.swing.JTextField tfMail;
    private javax.swing.JTextField tfRol;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
