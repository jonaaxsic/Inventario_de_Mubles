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
import javax.swing.JOptionPane;

public class Ig_Usuario extends javax.swing.JFrame {

    public static Controlador control;
    public static int res;
    public Ig_Usuario() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new EstilosPanel.GradientPanel(
            new java.awt.Color(63, 81, 110),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(41, 128, 185),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(127, 179, 213));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new EstilosPanel.GradientPanel(
            new java.awt.Color(97, 106, 107),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(204, 209, 209),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(234, 242, 248) );
        jPanel3 = new EstilosPanel.GradientPanel(
            new java.awt.Color(63, 81, 110),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(41, 128, 185),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(127, 179, 213));
        jtfnom_Usuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfContrasena = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfMail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbRoles = new javax.swing.JComboBox<>();
        jbtCrearUsuario = new EstilosBotones.GradientButton(
            "Crear Usuario", // El texto del botón
            new java.awt.Color(63, 81, 110), // Color inicial
            new java.awt.Color(41, 128, 185));
        jbtVolver = new EstilosBotones.GradientButton(
            "VOLVER AL MENU", // El texto del botón
            new java.awt.Color(131, 145, 146), // Color inicial
            new java.awt.Color(213, 219, 219 ));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(63, 81, 110));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Crear Nuevo Usuario");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/capsule2.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/agregar-usuario50px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(136, 136, 136)))
                .addComponent(jLabel2)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3))
        );

        jPanel2.setBackground(new java.awt.Color(127, 131, 131));

        jPanel3.setBackground(new java.awt.Color(63, 81, 110));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Nombre de Usuario:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Contraseña:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Correo:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Tipo de Rol");

        jcbRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Bodeguero", "Vendedor" }));

        jbtCrearUsuario.setBackground(new java.awt.Color(63, 81, 110));
        jbtCrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/agregar-usuario .png"))); // NOI18N
        jbtCrearUsuario.setText("CREAR USUARIO");
        jbtCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCrearUsuarioActionPerformed(evt);
            }
        });

        jbtVolver.setBackground(new java.awt.Color(204, 204, 204));
        jbtVolver.setForeground(new java.awt.Color(51, 51, 51));
        jbtVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/volver-flecha 20px.png"))); // NOI18N
        jbtVolver.setText("VOLVER AL MENU");
        jbtVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfMail, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtCrearUsuario)
                    .addComponent(jtfnom_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfnom_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jbtCrearUsuario)
                .addGap(18, 18, 18)
                .addComponent(jbtVolver)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCrearUsuarioActionPerformed
      try{
 control =new Controlador();
 control.crearConexion();
 }catch (SQLException ex){
 Logger.getLogger(Ig_Usuario.class.getName()).log(Level.SEVERE, null, ex);
 }
    int idRol = 0;
String rolSeleccionado = jcbRoles.getSelectedItem().toString();

switch (rolSeleccionado) {
    case "Administrador":
        idRol = 1;
        break;
    case "Bodeguero":
        idRol = 2;
        break;
    case "Vendedor":
        idRol = 3;
        break;
}


String sql_ins = "INSERT INTO Usuario (nom_usuario, contraseña, correo, Id_rol) VALUES ('"
    + jtfnom_Usuario.getText() + "', '"
    + jtfContrasena.getText() + "', '"
    + jtfMail.getText() + "', "
    + idRol + ")";

int res = -1;

try {
    res = control.mandarSQL(sql_ins);
} catch (SQLException ex) {
    Logger.getLogger(Ig_Usuario.class.getName()).log(Level.SEVERE, null, ex);
}

if (res == -1) {
    JOptionPane.showMessageDialog(null, "ERROR");
} else {
    JOptionPane.showMessageDialog(null, "Grabación Exitosa");
}  
      
      
      
    }//GEN-LAST:event_jbtCrearUsuarioActionPerformed

    private void jbtVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVolverActionPerformed
    Menu menu = new Menu();
    menu.setVisible(true);
    menu.setLocationRelativeTo(null);
    this.dispose();         
    }//GEN-LAST:event_jbtVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
       FlatDarkLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ig_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbtCrearUsuario;
    private javax.swing.JButton jbtVolver;
    private javax.swing.JComboBox<String> jcbRoles;
    private javax.swing.JTextField jtfContrasena;
    private javax.swing.JTextField jtfMail;
    private javax.swing.JTextField jtfnom_Usuario;
    // End of variables declaration//GEN-END:variables
}
