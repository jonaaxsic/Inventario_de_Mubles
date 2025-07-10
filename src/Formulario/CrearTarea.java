/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formulario;

import static Formulario.Login.control;
import Login.Logica.Controlador;
import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;
import javax.swing.JOptionPane;
import java.util.logging.Level;


public class CrearTarea extends javax.swing.JFrame {
      private Menu ventanaPrincipalMenu;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CrearTarea.class.getName());

    
    public CrearTarea() {
        initComponents();
        inicializarComponentesPersonalizados();
    }
    
    
    
    public CrearTarea(Menu menuQueMeAbrio) {
        this.ventanaPrincipalMenu = menuQueMeAbrio; 
        initComponents();
        
         inicializarComponentesPersonalizados();
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jbtVolver = new EstilosBotones.GradientButton(
            "VOLVER AL MENU", // El texto del botón
            new java.awt.Color(131, 145, 146), // Color inicial
            new java.awt.Color(213, 219, 219 ));
        jbtGuardarTareas = new EstilosBotones.GradientButton(
            "CREAR TAREA", // El texto del botón
            new java.awt.Color(63, 81, 110), // Color inicial
            new java.awt.Color(41, 128, 185));
        jLabel5 = new javax.swing.JLabel();
        jbtLimpiar = new EstilosBotones.GradientButton(
            "LIMPIAR", // El texto del botón
            new java.awt.Color(125, 60, 152), // Color inicial
            new java.awt.Color(165, 105, 189 ));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(63, 81, 110));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CREAR NUEVA TAREA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tipo de Tarea");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Piking", "Inventario", "Almacenar", "Recepcion", "Despacho" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Descripcion de tarea");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Fecha de Creación:");

        jDateChooser1.setBackground(new java.awt.Color(204, 204, 204));
        jDateChooser1.setForeground(new java.awt.Color(0, 0, 0));

        jbtVolver.setForeground(new java.awt.Color(0, 0, 0));
        jbtVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/volver-flecha 20px.png"))); // NOI18N
        jbtVolver.setText("VOLVER AL MENU");
        jbtVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVolverActionPerformed(evt);
            }
        });

        jbtGuardarTareas.setBackground(new java.awt.Color(63, 81, 110));
        jbtGuardarTareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/agregar-tarea25px.png"))); // NOI18N
        jbtGuardarTareas.setText("CREAR TAREA");
        jbtGuardarTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGuardarTareasActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/capsule2.png"))); // NOI18N

        jbtLimpiar.setBackground(new java.awt.Color(102, 0, 204));
        jbtLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jbtLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/goma-de-borrar 20px.png"))); // NOI18N
        jbtLimpiar.setText("LIMPIAR");
        jbtLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(59, 59, 59)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jbtGuardarTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtLimpiar)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jbtVolver)))
                        .addContainerGap(30, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtVolver)
                    .addComponent(jbtGuardarTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtLimpiar))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    
     private void inicializarComponentesPersonalizados() {
        // Establecer la fecha actual como la fecha por defecto en el JDateChooser
        jDateChooser1.setDate(new Date()); 
        // Configuración básica de JTextArea para que el texto fluya y se ajuste
        jTextArea1.setLineWrap(true); 
        jTextArea1.setWrapStyleWord(true); 
    }
    
    
    
    
    
    
    private void jbtVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVolverActionPerformed
       this.dispose();
       if (ventanaPrincipalMenu != null) {
            ventanaPrincipalMenu.setVisible(true); 
        } else {
           
            JOptionPane.showMessageDialog(this, "Error de navegación: No se pudo volver al menú principal.", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_jbtVolverActionPerformed

    private void jbtGuardarTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGuardarTareasActionPerformed
                String tipoTarea = "";
        if (jComboBox1.getSelectedItem() != null) { 
            tipoTarea = jComboBox1.getSelectedItem().toString().trim();
        }

        String descripcion = jTextArea1.getText().trim(); 
        
        // --- Obtener la fecha del JDateChooser ---
        Date fechaSeleccionada = jDateChooser1.getDate(); 
        String fechaCreacionStr = null;

        // --- Validaciones ---
        if (fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione la Fecha de Creación.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            // Formatear la fecha para la base de datos (Formato compatible con Access es #YYYY-MM-DD HH:MM:SS#)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            fechaCreacionStr = sdf.format(fechaSeleccionada);
        }

        // Si tienes una opción por defecto como "Seleccione un tipo", inclúyela en la validación
        if (tipoTarea.isEmpty() || tipoTarea.equals("Seleccione un tipo") || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un Tipo de Tarea y complete la Descripción.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            
            control = new Controlador(); 
            control.crearConexion();     

           
          String sql_insert = "INSERT INTO Tareas (Tipo_Tarea, Descripcion_Tarea, Fecha_creacion) VALUES ('"
                        + tipoTarea + "', '"
                        + descripcion + "', #"
                        + fechaCreacionStr + "#)";

    int res = control.mandarSQL(sql_insert);

    if (res > 0) {
        JOptionPane.showMessageDialog(this, "Tarea creada exitosamente. Ahora puedes asignarla.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        jbtLimpiarActionPerformed(null);
    } else {
        JOptionPane.showMessageDialog(this, "Error al crear la tarea. No se afectaron filas.", "Error", JOptionPane.ERROR_MESSAGE);
    }

} catch (java.sql.SQLException ex) {
    logger.log(java.util.logging.Level.SEVERE, "Error de base de datos al crear la tarea", ex);
    JOptionPane.showMessageDialog(this, "Error de base de datos al crear la tarea: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
} finally {
            //  cerrar la conexión si tu Controlador
            // if (control != null) {
            //     try {
            //         control.cerrarConexion(); // Asume que tienes un método para cerrar la conexión
            //     } catch (SQLException ex) {
            //         logger.log(Level.SEVERE, "Error al cerrar la conexión", ex);
            //     }
            // }
        }

    }//GEN-LAST:event_jbtGuardarTareasActionPerformed

    private void jbtLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLimpiarActionPerformed
        jComboBox1.setSelectedIndex(0); 
        jTextArea1.setText(""); 
        jDateChooser1.setDate(new Date()); 
        jComboBox1.requestFocusInWindow();
    }//GEN-LAST:event_jbtLimpiarActionPerformed

   
    public static void main(String args[]) {
       FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CrearTarea().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbtGuardarTareas;
    private javax.swing.JButton jbtLimpiar;
    private javax.swing.JButton jbtVolver;
    // End of variables declaration//GEN-END:variables
}
