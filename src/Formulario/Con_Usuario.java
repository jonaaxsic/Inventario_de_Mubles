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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class Con_Usuario extends javax.swing.JFrame {
    public static Controlador control;
    public static ResultSet rs;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Con_Usuario.class.getName());

    /**
     * Creates new form Con_Usuario
     * @throws java.sql.SQLException
     */
    public Con_Usuario()throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        LlenarTabla("");
    }
    
    void LlenarTabla(String filtroNombre)throws SQLException{
    try{
        control =new Controlador();
        control.crearConexion();
    } catch(SQLException ex){
     Logger.getLogger(Con_Usuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    try{
DefaultTableModel model =new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("NOMBRE USUARIO");
    model.addColumn("CORREO");
    model.addColumn("ROL");
    tabUsuario.setModel(model);
   
     DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); 
        for (int i = 0; i < tabUsuario.getColumnCount(); i++) {
            tabUsuario.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    
    String sql= "SELECT u.Id_usuario, u.nom_usuario, u.correo, r.nombre_rol AS ROL " +
             "FROM Usuario u " +  
             "JOIN Roles r ON u.Id_rol = r.Id_rol";
    
     if (filtroNombre != null && !filtroNombre.trim().isEmpty()) {
                sql += "WHERE u.nom_usuario LIKE ? OR u.correo LIKE ?";
            }
     
     
    rs=control.mandarQUERY(sql);
    String []fila = new String[4];
while (rs.next()){
   fila[0]=rs.getString("Id_usuario");
   fila[1]=rs.getString("nom_usuario");
   fila[2]=rs.getString("correo");
   fila[3]=rs.getString("ROL");
model.addRow(fila);
}
tabUsuario.setModel(model);

} catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al cargar usuarios en la tabla desde la base de datos.", ex);
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los usuarios: " + ex.getMessage() + "\nPor favor, verifica la conexión y la consulta SQL.",
                    "Error de Base de Datos",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException ex) { logger.log(Level.SEVERE, "Error al cerrar ResultSet.", ex); }
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
        jtfBuscarNom = new javax.swing.JTextField();
        jbtSearch = new EstilosBotones.GradientButton(
            "CONSULTAR USUARIO", // El texto del botón
            new java.awt.Color(63, 81, 110), // Color inicial
            new java.awt.Color(41, 128, 185));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbtBack = new EstilosBotones.GradientButton(
            "VOLVER AL MENU", // El texto del botón
            new java.awt.Color(131, 145, 146), // Color inicial
            new java.awt.Color(213, 219, 219 ));
        jScrollPane1 = new javax.swing.JScrollPane();
        tabUsuario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(63, 81, 110));

        jPanel2.setBackground(new java.awt.Color(127, 131, 131));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nombre de usuario");

        jbtSearch.setBackground(new java.awt.Color(63, 81, 110));
        jbtSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/buscarUser.png"))); // NOI18N
        jbtSearch.setText("CONSULTAR USUARIOS");
        jbtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(jtfBuscarNom, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtSearch)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscarNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jbtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SISTEMA DE INVENTARIO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Consultar Usuario");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/capsule2.png"))); // NOI18N

        jbtBack.setBackground(new java.awt.Color(127, 131, 131));
        jbtBack.setForeground(new java.awt.Color(0, 0, 0));
        jbtBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/volver-flecha 20px.png"))); // NOI18N
        jbtBack.setText("VOLVER AL MENU");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });

        tabUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabUsuario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jbtBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jbtBack)
                .addGap(22, 22, 22))
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

    private void jbtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSearchActionPerformed
       try {
            control = new Controlador(); // Si lo instanciabas aquí en el original
            control.crearConexion(); // Si tu controlador antiguo tiene este método
        } catch (SQLException ex) {
            Logger.getLogger(Con_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("NOMBRE USUARIO");
            model.addColumn("CORREO");
            model.addColumn("ROL");
            tabUsuario.setModel(model); 
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); 
        for (int i = 0; i < tabUsuario.getColumnCount(); i++) {
            tabUsuario.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
            
// Asumo tabUsuario es tu JTable, si es jTable1, cámbialo.

            String sql = "SELECT u.Id_usuario, u.nom_usuario, u.correo, r.nombre_rol AS ROL " +
                         "FROM Usuario u " +
                         "JOIN Roles r ON u.Id_rol = r.Id_rol " +
                         "WHERE u.nom_usuario LIKE '%" + jtfBuscarNom.getText() + "%' OR u.correo LIKE '%" + jtfBuscarNom.getText() + "%'"; // jtfBuscarNom.getText() es el JTextField de búsqueda.

            rs = control.mandarQUERY(sql); // Asumo que tu controlador antiguo tiene este método y devuelve ResultSet.

            while (rs.next()) {
                String[] fila = new String[4];
                fila[0] = rs.getString("Id_usuario");
                fila[1] = rs.getString("nom_usuario");
                fila[2] = rs.getString("correo");
                fila[3] = rs.getString("ROL");
                model.addRow(fila);
            }

            tabUsuario.setModel(model); // Si usas jTable1, cámbialo.

        } catch (SQLException ex) {
            Logger.getLogger(Con_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al consultar usuarios: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Asegúrate de cerrar el ResultSet y la Connection en el controlador o aquí si tu controlador no lo hace.
            // Si control.mandarQUERY abre una nueva conexión cada vez, DEBE cerrarse.
            // En tu diseño antiguo (imagen), no se ve un cierre explícito en el `finally` aquí.
            // Esto es importante para evitar fugas de recursos de BD.
        }

   

    }//GEN-LAST:event_jbtSearchActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
    Menu menu = new Menu();
    menu.setVisible(true);
    menu.setLocationRelativeTo(null);
    this.dispose();  
    }//GEN-LAST:event_jbtBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Con_Usuario().setVisible(true);
            } catch (SQLException ex) {
                System.getLogger(Con_Usuario.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtSearch;
    private javax.swing.JTextField jtfBuscarNom;
    private javax.swing.JTable tabUsuario;
    // End of variables declaration//GEN-END:variables
}
