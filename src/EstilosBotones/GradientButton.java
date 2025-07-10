/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstilosBotones;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.JButton;


public class GradientButton extends JButton  {
    private Color normalStartColor; // Color inicial cuando el botón está normal
    private Color normalEndColor;   // Color final cuando el botón está normal

    private Color currentStartColor; // Color inicial actual para el pintado
    private Color currentEndColor;
    
    
    
     // Constructor para gradiente de 2 colores
    public GradientButton(String text, Color startColor, Color endColor) {
         super(text); // Llama al constructor de JButton con el texto

        this.normalStartColor = startColor;
        this.normalEndColor = endColor;

        // Inicialmente, el botón está en estado normal
        this.currentStartColor = normalStartColor;
        this.currentEndColor = normalEndColor;

        // ¡Importante! Desactiva el pintado de fondo predeterminado del botón
        setContentAreaFilled(false);

        // Opcional: Desactiva el recuadro de foco y el borde predeterminado
        setFocusPainted(false);
        setBorderPainted(false);
        
        // Opcional: Establece un color de texto por defecto que contraste bien
        setForeground(Color.WHITE);

        // AÑADIR MouseListener para los efectos de hover y pressed
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // Al pasar el mouse, oscurece los colores
                currentStartColor = normalStartColor.darker();
                currentEndColor = normalEndColor.darker();
                repaint(); // Solicita un repintado para aplicar los cambios
            }

            public void mouseExited(MouseEvent e) {
                // Al salir el mouse, vuelve a los colores normales
                currentStartColor = normalStartColor;
                currentEndColor = normalEndColor;
                repaint();
            }

            public void mousePressed(MouseEvent e) {
                // Al hacer click, oscurece aún más los colores para el efecto de "presionado"
                currentStartColor = normalStartColor.darker().darker();
                currentEndColor = normalEndColor.darker().darker();
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                // Al soltar el click, si el mouse sigue encima, vuelve a hover; si no, a normal.
                if (contains(e.getPoint())) {
                    currentStartColor = normalStartColor.darker(); // Vuelve a hover
                    currentEndColor = normalEndColor.darker();
                } else {
                    currentStartColor = normalStartColor; // Vuelve a normal
                    currentEndColor = normalEndColor;
                }
                repaint();
            }
        });
    }
 
    

    protected void paintComponent(Graphics g) {
super.paintComponent(g); // <-- Esto es opcional si solo quieres que tu gradiente pinte el fondo

        Graphics2D g2d = (Graphics2D) g.create(); // Usa g.create() para no afectar el Graphics original

        int width = getWidth();
        int height = getHeight();

        // Puntos de inicio y fin para un gradiente vertical
        Point2D start = new Point2D.Float(0, 0);
        Point2D end = new Point2D.Float(0, height);

        // Colores y fracciones para un gradiente de 2 colores
        // Usamos los colores "current" que cambian con el estado del mouse
        Color[] colors = {currentStartColor, currentEndColor};
        float[] fractions = {0.0f, 1.0f};

        LinearGradientPaint paint = new LinearGradientPaint(start, end, fractions, colors);
        g2d.setPaint(paint);
        g2d.fillRect(0, 0, width, height);

        g2d.dispose(); // Libera los recursos del objeto Graphics2D creado

        // ¡Importante! Dibuja el texto y el icono del botón encima del gradiente.
        // Si super.paintComponent(g) ya estaba al inicio y quieres que el texto se pinte DESPUÉS del gradiente,
        // muévelo aquí (como está ahora). Si lo dejas solo al inicio, podría pintarse debajo.
        super.paintComponent(g);
        
    }

    // Opcional: Sobrescribir paintBorder para un control completo sobre el borde.
    // Si setBorderPainted(false) es suficiente (no quieres borde), puedes omitir este método.
    protected void paintBorder(Graphics g) {
        // No hacer nada para que no se pinte el borde predeterminado.
        // Si quieres un borde personalizado, actívalo con setBorderPainted(true) 
        // en el constructor y dibújalo aquí, por ejemplo:
        // Graphics2D g2d = (Graphics2D) g.create();
        // g2d.setColor(Color.DARK_GRAY); // Color del borde
        // g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1); // Dibuja un rectángulo como borde
        // g2d.dispose();
    }
    
}


