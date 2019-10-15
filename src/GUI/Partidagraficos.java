package GUI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import javax.swing.JFrame;
import objnegocio.Punto;
import objnegocio.Tablero;

/**
 *
 * @author Usuario
 */
public class Partidagraficos extends JFrame {

    private int tamanioTablero = 900;

    //Panel que contiene el tablero
    Tablero ventanaTablero;

    //Variables para dibujar las lineas
    private MouseHandler mouseHandler = new MouseHandler();
    ArrayList<GeneralPath> lineas = new ArrayList<GeneralPath>();
    GeneralPath path = null;
    private boolean drawing = false;


    public Partidagraficos(int numJug) {

        this.setPreferredSize(new Dimension(tamanioTablero, tamanioTablero));
        ventanaTablero = new Tablero(numJug, tamanioTablero);
        ventanaTablero.setPreferredSize(new Dimension(tamanioTablero, tamanioTablero));
        this.add(ventanaTablero, BorderLayout.CENTER);
        this.pack();

        ventanaTablero.addMouseListener(mouseHandler);
        ventanaTablero.addMouseMotionListener(mouseHandler);
       
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        ventanaTablero.generarPuntos();
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2));
        
        int contadorParaColor = 0;        

        if (path != null) {
            for (int i = 0; i < lineas.size(); i++) {
                
                //HACER UN METODO QUE SEA PARA DECIDIR EL COLOR
                switch (contadorParaColor) {
                    case 0: 
                        g2d.setColor(Color.BLUE);
                        contadorParaColor++;
                        break;
                    case 1:
                        g2d.setColor(Color.RED);
                        contadorParaColor++;
                        break;
                    case 2:
                        g2d.setColor(Color.GREEN);
                        contadorParaColor = 0;
                        break; 
                    default:                        
                        break;
                }
                
                
                if (lineas.get(i) != null) {
                    g2d.draw(lineas.get(i));

                }
            }
        }
        ventanaTablero.dibujarTablero();
    }

    @Override
    public void repaint() {
        Graphics g = ventanaTablero.getGraphics();
        paint(g);
    }

    //Esta es una clase privada que obtiene los puntos donde se 
    //hace click para que despues otro metodo se encargue de pintarlos
    private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {

            Punto p = ventanaTablero.detectarPunto(e.getPoint());

            if (!drawing) {
                path = new GeneralPath();
                path.moveTo(p.obtenerX(), p.obtenerY());
                drawing = true;
            } else {
                path.lineTo(p.obtenerX(), p.obtenerY());
                lineas.add(path);
                drawing = false;
            }

            repaint();
        }
    }

}//Llave de la clase
