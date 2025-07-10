/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formulario;

import Login.Logica.ConexionBD;
import Login.Logica.Controlador;
import com.formdev.flatlaf.FlatDarkLaf;
import com.sun.jdi.connect.spi.Connection;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import EstilosPanel.GradientPanel;
import Formulario.Ig_Usuario;


public class Menu extends javax.swing.JFrame {

    private Object EstilosPanel;
    

        
    public Menu(String username, String roleName) {
        initComponents();
         
          
          if (lbNom != null) {
            lbNom.setText(username);
        }
        if (lbRol != null) {
            lbRol.setText(roleName);   
        }
       

        configureUIbyRole(roleName);
         setupAdminPanelListeners();
    }
    
public Menu() {
    initComponents();
}


   
//CONTROLAR COMO SE MUESTRAN LOS BOTONES A LOS USUARIOS
    private void configureUIbyRole(String role) {
            System.out.println("DEBUG: Rol recibido en configureUIbyRole: '" + role + "'");

        // --- OCULTAR TODOS LOS BOTONES DE NAVEGACIÓN LATERAL INICIALMENTE ---
        if (jBtAdministracion != null) jBtAdministracion.setVisible(false);
        if (jBtBodega != null) jBtBodega.setVisible(false);
        if (jBtVentas != null) jBtVentas.setVisible(false);

        // --- LIMPIAR PESTAÑAS DEL JTabbedPane PRINCIPAL (jTabPan1) ---
        if (jTabPan1 != null) { // Asegúrate que jTabPan1 no sea null
            jTabPan1.setVisible(false); // Ocultar el panel de pestañas temporalmente

            // Eliminar todas las pestañas existentes para empezar con una pizarra limpia
            for (int i = jTabPan1.getTabCount() - 1; i >= 0; i--) {
                jTabPan1.removeTabAt(i);
            }
        } else {
            System.err.println("ERROR: jTabPan1 es null. No se puede configurar el JTabbedPane.");
            // Considera salir o manejar este error grave
            JOptionPane.showMessageDialog(this, "Error crítico: El panel de pestañas no está inicializado.", "Error Fatal", JOptionPane.ERROR_MESSAGE);
            this.dispose(); // Cierra la ventana si no se puede continuar
            return; // Termina la ejecución del método
        }

//MOSTRAR LOS BOTONES SEGUN LOS ROLES 
        switch (role.toString()) {
            case "Administrador":
                System.out.println("DEBUG: Rol es Administrador.");
                // Añadir todas las pestañas de nuevo en el orden deseado
                if (jTpAdministracion != null) jTabPan1.addTab("Administracion", jTpAdministracion);
                if (jTpBodega != null) jTabPan1.addTab("Bodega", jTpBodega);
                if (jTpVentas != null) jTabPan1.addTab("Ventas", jTpVentas);

                // Mostrar todos los botones de navegación
                if (jBtAdministracion != null) jBtAdministracion.setVisible(true);
                if (jBtBodega != null) jBtBodega.setVisible(true);
                if (jBtVentas != null) jBtVentas.setVisible(true);
                
                // Seleccionar la primera pestaña por defecto (Administración)
                // Asegúrate que el título "Administracion" coincida exactamente
                int adminTabIdx = jTabPan1.indexOfTab("Administracion");
                if (adminTabIdx != -1) {
                    jTabPan1.setSelectedIndex(adminTabIdx);
                } else {
                    System.err.println("ADVERTENCIA: No se encontró la pestaña 'Administracion' para seleccionar.");
                }
                break;

            case "Bodeguero": // ¡Verifica que este String coincida EXACTAMENTE con el de tu BD!
                System.out.println("DEBUG: Rol es Bodeguero.");
                // Añadir solo la pestaña de Bodega
                if (jTpBodega != null) {
                    jTabPan1.addTab("Bodega", jTpBodega); // Asegúrate que el título "Bodega" coincida exactamente
                    System.out.println("DEBUG: Pestaña 'Bodega' añadida.");
                } else {
                    System.err.println("ERROR: jTpBodega es null. La pestaña 'Bodega' no se puede añadir.");
                }

                // Mostrar solo el botón de Bodega
                if (jBtBodega != null) {
                    jBtBodega.setVisible(true);
                    System.out.println("DEBUG: Botón 'jBtBodega' visible.");
                } else {
                    System.err.println("ERROR: jBtBodega es null. El botón 'Bodega' no se puede mostrar.");
                }

                // Seleccionar la pestaña de Bodega
                int bodegaTabIdx = jTabPan1.indexOfTab("Bodega");
                if (bodegaTabIdx != -1) {
                    jTabPan1.setSelectedIndex(bodegaTabIdx);
                    System.out.println("DEBUG: Pestaña 'Bodega' seleccionada.");
                } else {
                    System.err.println("ADVERTENCIA: No se encontró la pestaña 'Bodega' para seleccionar después de añadir.");
                }
                break;

            case "Vendedor":
                System.out.println("DEBUG: Rol es Vendedor.");
                // Añadir solo la pestaña de Ventas
                if (jTpVentas != null) jTabPan1.addTab("Ventas", jTpVentas);

                // Mostrar solo el botón de Ventas
                if (jBtVentas != null) jBtVentas.setVisible(true);

                // Seleccionar la pestaña de Ventas
                int ventasTabIdx = jTabPan1.indexOfTab("Ventas");
                if (ventasTabIdx != -1) {
                    jTabPan1.setSelectedIndex(ventasTabIdx);
                } else {
                    System.err.println("ADVERTENCIA: No se encontró la pestaña 'Ventas' para seleccionar.");
                }
                break;

            default:
                System.out.println("DEBUG: Rol desconocido: " + role);
                JOptionPane.showMessageDialog(this, "Rol de usuario desconocido: " + role + ". No hay opciones disponibles.", "Acceso Restringido", JOptionPane.WARNING_MESSAGE);
                // Las pestañas ya se eliminaron al inicio.
                // Los botones ya están ocultos al inicio.
                break;
        }

        // --- Restaurar la visibilidad del JTabbedPane ---
        if (jTabPan1 != null) {
            jTabPan1.setVisible(true);
        }

        // --- Verificación final ---
        if (jTabPan1 != null && jTabPan1.getTabCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay opciones disponibles para este rol. Cerrando sesión.", "Acceso Restringido", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); // Cierra la ventana
        }
              
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel2 =  new EstilosPanel.GradientPanel(
            new java.awt.Color(63, 81, 110),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(41, 128, 185),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(127, 179, 213)
        );  // Color abajo (puedes ajustar el tono));
        jBtAdministracion = new EstilosBotones.GradientButton(
            "ADMINISTRACION", // El texto del botón
            new java.awt.Color(63, 81, 110), // Color inicial
            new java.awt.Color(41, 128, 185));
        jtbCerrarSesion = new javax.swing.JButton();
        jBtVentas = new EstilosBotones.GradientButton(
            "VENTAS", // El texto del botón
            new java.awt.Color(63, 81, 110), // Color inicial
            new java.awt.Color(41, 128, 185));
        jBtBodega = new EstilosBotones.GradientButton(
            "BODEGA", // El texto del botón
            new java.awt.Color(63, 81, 110), // Color inicial
            new java.awt.Color(41, 128, 185));
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbNom = new javax.swing.JLabel();
        lbRol = new javax.swing.JLabel();
        jPanel3 = new EstilosPanel.GradientPanel(
            new java.awt.Color(63, 81, 110),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(41, 128, 185),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(127, 179, 213));
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabPan1 = new javax.swing.JTabbedPane();
        jTpAdministracion =  new EstilosPanel.GradientPanel(
            new java.awt.Color(97, 106, 107),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(204, 209, 209),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(234, 242, 248) );
        jPanel4 = new EstilosPanel.GradientPanel(
            new java.awt.Color(63, 81, 110),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(41, 128, 185),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(127, 179, 213));
        jLabel4 = new javax.swing.JLabel();
        jbtRegistrar = new EstilosBotones.GradientButton(
            "Usuario", // El texto del botón
            new java.awt.Color(63, 81, 110), // Color inicial
            new java.awt.Color(41, 128, 185));
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jbtCon_Usuario = new EstilosBotones.GradientButton(
            "PERFILES DE USUARIOS", // El texto del botón
            new java.awt.Color(20, 143, 119 ), // Color inicial
            new java.awt.Color(72, 201, 176));
        btnMod_User = new EstilosBotones.GradientButton(
            "Usuarios", // El texto del botón
            new java.awt.Color(125, 60, 152), // Color inicial
            new java.awt.Color(165, 105, 189 ));
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTpBodega =  new EstilosPanel.GradientPanel(
            new java.awt.Color(97, 106, 107),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(204, 209, 209),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(234, 242, 248));
        jPanel5 = new EstilosPanel.GradientPanel(
            new java.awt.Color(63, 81, 110),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(41, 128, 185),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(127, 179, 213));
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jbtnCrearTarea = new EstilosBotones.GradientButton(
            "TAREA", // El texto del botón
            new java.awt.Color(63, 81, 110), // Color inicial
            new java.awt.Color(41, 128, 185));
        jLabel8 = new javax.swing.JLabel();
        jbtCons_Tarea = new EstilosBotones.GradientButton(
            "TAREAS CREADAS", // El texto del botón
            new java.awt.Color(125, 60, 152), // Color inicial
            new java.awt.Color(165, 105, 189 ));
        jLabel10 = new javax.swing.JLabel();
        jTpVentas =  new EstilosPanel.GradientPanel(
            new java.awt.Color(97, 106, 107),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(204, 209, 209),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(234, 242, 248) );
        jPanel6 = new EstilosPanel.GradientPanel(
            new java.awt.Color(63, 81, 110),   // Color 1: Azul oscuro/grisáceo
            new java.awt.Color(41, 128, 185),  // Color 2: Azul más claro (como "Peter River" de Flat UI)
            new java.awt.Color(127, 179, 213));
        jLabel6 = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(63, 81, 110));
        jPanel2.setPreferredSize(new java.awt.Dimension(260, 275));

        jBtAdministracion.setBackground(new java.awt.Color(63, 81, 110));
        jBtAdministracion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jBtAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/administrar (3).png"))); // NOI18N
        jBtAdministracion.setText("    ADMINISTRACION");
        jBtAdministracion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jBtAdministracion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtAdministracion.setPreferredSize(new java.awt.Dimension(70, 30));
        jBtAdministracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtAdministracionMouseClicked(evt);
            }
        });
        jBtAdministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdministracionActionPerformed(evt);
            }
        });

        jtbCerrarSesion.setBackground(new java.awt.Color(255, 0, 0));
        jtbCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        jtbCerrarSesion.setText("Cerrar sesion");
        jtbCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbCerrarSesionActionPerformed(evt);
            }
        });

        jBtVentas.setBackground(new java.awt.Color(63, 81, 110));
        jBtVentas.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jBtVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/de-venta (1).png"))); // NOI18N
        jBtVentas.setText("         VENTAS");
        jBtVentas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jBtVentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtVentas.setPreferredSize(new java.awt.Dimension(70, 30));
        jBtVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtVentasMouseClicked(evt);
            }
        });
        jBtVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVentasActionPerformed(evt);
            }
        });

        jBtBodega.setBackground(new java.awt.Color(63, 81, 110));
        jBtBodega.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jBtBodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/bodega1.png"))); // NOI18N
        jBtBodega.setText("         BODEGA");
        jBtBodega.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jBtBodega.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtBodega.setPreferredSize(new java.awt.Dimension(70, 30));
        jBtBodega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtBodegaMouseClicked(evt);
            }
        });
        jBtBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBodegaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Perfil de Usuario:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre Usuario:");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/register user35px.png"))); // NOI18N

        lbNom.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbNom.setForeground(new java.awt.Color(255, 255, 255));

        lbRol.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbRol.setForeground(new java.awt.Color(255, 255, 255));
        lbRol.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtAdministracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtBodega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jtbCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRol)
                            .addComponent(lbNom, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbNom))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbRol))
                .addGap(18, 18, 18)
                .addComponent(jBtAdministracion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtbCerrarSesion)
                .addGap(19, 19, 19))
        );

        jPanel3.setBackground(new java.awt.Color(63, 81, 110));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/capsule2.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido al sistema  de Inventario");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTabPan1.setBackground(new java.awt.Color(51, 51, 51));
        jTabPan1.setForeground(new java.awt.Color(255, 255, 255));
        jTabPan1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jTpAdministracion.setBackground(new java.awt.Color(153, 153, 153));
        jTpAdministracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel4.setBackground(new java.awt.Color(63, 81, 110));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Bienvenido a Administracion ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(393, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtRegistrar.setBackground(new java.awt.Color(63, 81, 110));
        jbtRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/agregar-usuario .png"))); // NOI18N
        jbtRegistrar.setText("USUARIOS");
        jbtRegistrar.setMaximumSize(new java.awt.Dimension(120, 40));
        jbtRegistrar.setMinimumSize(new java.awt.Dimension(120, 40));
        jbtRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtRegistrarMouseClicked(evt);
            }
        });
        jbtRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRegistrarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("MODIFICAR");

        jbtCon_Usuario.setBackground(new java.awt.Color(0, 153, 153));
        jbtCon_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/consultarUSER.png"))); // NOI18N
        jbtCon_Usuario.setText("PERFILES DE USUARIOS");
        jbtCon_Usuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbtCon_Usuario.setMaximumSize(new java.awt.Dimension(168, 40));
        jbtCon_Usuario.setMinimumSize(new java.awt.Dimension(168, 40));
        jbtCon_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCon_UsuarioActionPerformed(evt);
            }
        });

        btnMod_User.setBackground(new java.awt.Color(102, 0, 204));
        btnMod_User.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/editarusuario.png"))); // NOI18N
        btnMod_User.setText("USUARIOS");
        btnMod_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMod_UserActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("CREAR");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("CONSULTAR");

        javax.swing.GroupLayout jTpAdministracionLayout = new javax.swing.GroupLayout(jTpAdministracion);
        jTpAdministracion.setLayout(jTpAdministracionLayout);
        jTpAdministracionLayout.setHorizontalGroup(
            jTpAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jTpAdministracionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jTpAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(28, 28, 28)
                .addGroup(jTpAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtCon_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jTpAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(btnMod_User))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator2)
        );
        jTpAdministracionLayout.setVerticalGroup(
            jTpAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTpAdministracionLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jTpAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jTpAdministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCon_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMod_User)
                    .addComponent(jbtRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabPan1.addTab("Administracion", jTpAdministracion);

        jTpBodega.setBackground(new java.awt.Color(153, 153, 153));
        jTpBodega.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel5.setBackground(new java.awt.Color(63, 81, 110));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Bienvenido a Bodega");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(446, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnCrearTarea.setBackground(new java.awt.Color(63, 81, 110));
        jbtnCrearTarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/agregar-tarea.png"))); // NOI18N
        jbtnCrearTarea.setText("TAREA");
        jbtnCrearTarea.setMaximumSize(new java.awt.Dimension(120, 40));
        jbtnCrearTarea.setMinimumSize(new java.awt.Dimension(120, 40));
        jbtnCrearTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCrearTareaActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("NUEVA ");

        jbtCons_Tarea.setBackground(new java.awt.Color(102, 0, 153));
        jbtCons_Tarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/tarea.png"))); // NOI18N
        jbtCons_Tarea.setText("TAREAS CREADAS");
        jbtCons_Tarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCons_TareaActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("CONSULTAR");

        javax.swing.GroupLayout jTpBodegaLayout = new javax.swing.GroupLayout(jTpBodega);
        jTpBodega.setLayout(jTpBodegaLayout);
        jTpBodegaLayout.setHorizontalGroup(
            jTpBodegaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jTpBodegaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jTpBodegaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnCrearTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jTpBodegaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jbtCons_Tarea))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator3)
        );
        jTpBodegaLayout.setVerticalGroup(
            jTpBodegaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTpBodegaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jTpBodegaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(9, 9, 9)
                .addGroup(jTpBodegaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCrearTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtCons_Tarea, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        jTabPan1.addTab("Bodega", jTpBodega);

        jTpVentas.setBackground(new java.awt.Color(153, 153, 153));
        jTpVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel6.setBackground(new java.awt.Color(63, 81, 110));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Bienvenido a Ventas");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(454, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jTpVentasLayout = new javax.swing.GroupLayout(jTpVentas);
        jTpVentas.setLayout(jTpVentasLayout);
        jTpVentasLayout.setHorizontalGroup(
            jTpVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jTpVentasLayout.setVerticalGroup(
            jTpVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTpVentasLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 345, Short.MAX_VALUE))
        );

        jTabPan1.addTab("Ventas", jTpVentas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabPan1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabPan1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdministracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtAdministracionActionPerformed

    private void jBtVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtVentasActionPerformed

    private void jBtAdministracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtAdministracionMouseClicked
        jTabPan1.setSelectedComponent(jTpAdministracion);
        
    }//GEN-LAST:event_jBtAdministracionMouseClicked

    private void jBtBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBodegaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtBodegaActionPerformed

    private void jBtBodegaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtBodegaMouseClicked
        jTabPan1.setSelectedComponent(jTpBodega);
    }//GEN-LAST:event_jBtBodegaMouseClicked

    private void jBtVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtVentasMouseClicked
        jTabPan1.setSelectedComponent(jTpVentas);
    }//GEN-LAST:event_jBtVentasMouseClicked

      
    private void jbtRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtRegistrarMouseClicked
             
    }//GEN-LAST:event_jbtRegistrarMouseClicked

      
    
    
    
    private void jbtRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRegistrarActionPerformed
    Ig_Usuario Ig_Usuario = null;
    Ig_Usuario = new Ig_Usuario();
      Ig_Usuario.setVisible(true);
      Ig_Usuario.setLocationRelativeTo(null);
      this.dispose();
        
    }//GEN-LAST:event_jbtRegistrarActionPerformed

    private void setupAdminPanelListeners() {
   
}
       
    
    
    private void jtbCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbCerrarSesionActionPerformed
       Login login = new Login();       
       login.setVisible(true);          
       login.setLocationRelativeTo(null); 
       this.dispose();                  

    }//GEN-LAST:event_jtbCerrarSesionActionPerformed

    private void jbtCon_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCon_UsuarioActionPerformed
      Con_Usuario con_Usuario = null;
        try {
            con_Usuario = new Con_Usuario();
        } catch (SQLException ex) {
            System.getLogger(Menu.class.getName()).log(Level.ERROR, (String) null, ex);
        }
      con_Usuario.setVisible(true);
      con_Usuario.setLocationRelativeTo(null);
      this.dispose();
      

    }//GEN-LAST:event_jbtCon_UsuarioActionPerformed

    private void btnMod_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMod_UserActionPerformed
        Mod_Usuario ModUser =new Mod_Usuario();
        ModUser.setVisible(true);
        ModUser.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnMod_UserActionPerformed

    private void jbtnCrearTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearTareaActionPerformed
   CrearTarea ventanaTarea = new CrearTarea(this); 
    ventanaTarea.setVisible(true);
    ventanaTarea.setLocationRelativeTo(null); 
    this.setVisible(false); 
    }//GEN-LAST:event_jbtnCrearTareaActionPerformed

    private void jbtCons_TareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCons_TareaActionPerformed
        consultarTarea VerTareas = null; 
        try {
            VerTareas = new consultarTarea();
        } catch (SQLException ex) {
            System.getLogger(Menu.class.getName()).log(Level.ERROR, (String) null, ex);
        }
    VerTareas.setVisible(true);
    VerTareas.setLocationRelativeTo(null); 
    this.setVisible(false);
    }//GEN-LAST:event_jbtCons_TareaActionPerformed

    
   
     
    
    
    
    
    
    
    public static void main(String args[]) {
         FlatDarkLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMod_User;
    public javax.swing.JButton jBtAdministracion;
    public javax.swing.JButton jBtBodega;
    public javax.swing.JButton jBtVentas;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabPan1;
    private javax.swing.JPanel jTpAdministracion;
    private javax.swing.JPanel jTpBodega;
    private javax.swing.JPanel jTpVentas;
    private javax.swing.JButton jbtCon_Usuario;
    private javax.swing.JButton jbtCons_Tarea;
    private javax.swing.JButton jbtRegistrar;
    private javax.swing.JButton jbtnCrearTarea;
    private javax.swing.JButton jtbCerrarSesion;
    public static javax.swing.JLabel lbNom;
    public static javax.swing.JLabel lbRol;
    // End of variables declaration//GEN-END:variables
}
