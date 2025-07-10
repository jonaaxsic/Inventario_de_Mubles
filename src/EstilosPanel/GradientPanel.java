/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstilosPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

public class GradientPanel extends JPanel{
    
    private Color color1;
    private Color color2;
    private Color color3;

    // Constructor que acepta tres objetos Color
    public GradientPanel(Color color1, Color color2, Color color3) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // ¡Muy importante para un dibujo correcto!

        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        // 1. Define los puntos de inicio y fin del gradiente.
        // Para un gradiente vertical de arriba hacia abajo:
        Point2D start = new Point2D.Float(0, 0);
        Point2D end = new Point2D.Float(0, height);

        // 2. Crea un array con tus tres colores (usando los campos de la clase).
        Color[] colors = {this.color1, this.color2, this.color3};

        // 3. Define las "fracciones" o posiciones de cada color en el gradiente.
        // 0.0f: color1 en la parte superior.
        // 0.5f: color2 justo en el centro.
        // 1.0f: color3 en la parte inferior.
        float[] fractions = {0.0f, 0.5f, 1.0f};

        // 4. Crea el objeto LinearGradientPaint.
        LinearGradientPaint lgp = new LinearGradientPaint(start, end, fractions, colors);

        // 5. Aplica el gradiente al contexto gráfico y rellena todo el panel.
        g2d.setPaint(lgp);
        g2d.fillRect(0, 0, width, height);
    }
}
    
    
