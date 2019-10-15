/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objnegocio;

/**
 *
 * @author Usuario
 */
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Tablero extends JPanel {

    int numJug;
    int tamanioTablero;
    int espacioEntrePuntos;
    private Punto[][] puntosTablero;

    public Tablero(int numJug, int tamanioTablero) {
        super();
        this.numJug = numJug;
        this.tamanioTablero = tamanioTablero;
    }

    //Genera los puntos del tablero en base a los jugadores
    public void generarPuntos() {
        int posOriginal = 50;
        int posicionX = posOriginal;
        int posicionY = posOriginal;
        int dimension = 0;

        //Definicion de la dimension del tablero en base a los jugadores
        switch (numJug) {
            case 2:
                dimension = 10;
                break;
            case 3:
                dimension = 20;
                break;
            case 4:
                dimension = 40;
                break;
            default:
                break;
        }

        int espacioDisponible = tamanioTablero - 100; //800
        espacioEntrePuntos = espacioDisponible / dimension;

        //Creacion del tablero
        puntosTablero = new Punto[dimension][dimension];

        //Creacion de los puntos que estaran en el tablero
        for (int i = 0; i < puntosTablero.length; i++) { //Este for representa el eje de las Y

            for (int j = 0; j < puntosTablero[i].length; j++) {//Este for representa el eje de las X

                puntosTablero[i][j] = new Punto(posicionX, posicionY);
                posicionX = posicionX + espacioEntrePuntos;

                if (j == puntosTablero[i].length - 1) {
                    posicionX = posOriginal;
                }
            }

            posicionY = posicionY + espacioEntrePuntos;

            if (i == puntosTablero.length - 1) {
                posicionY = posOriginal;
            }
        }

    }//Fin del metodo generarPuntos()

    //Pinta el tablero(Los puntos)
    public void dibujarTablero() {
        Graphics g = this.getGraphics();
        this.setDoubleBuffered(true);

        //Estas dos lineas son para aumentar el grosor del punto
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        //Esta linea es para que los circulos salgan mas smooth
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < puntosTablero.length; i++) { //Este for representa el eje de las Y

            for (int j = 0; j < puntosTablero[i].length; j++) {//Este for representa el eje de las X

                g.drawOval(puntosTablero[i][j].obtenerX(), puntosTablero[i][j].obtenerY(), 3, 3);
                g.fillOval(puntosTablero[i][j].obtenerX(), puntosTablero[i][j].obtenerY(), 3, 3);

            }
        }

    }//Fin del metodo dibujarTablero()

    //Detecta el punto mas cercano a donde se dan los clicks
    public Punto detectarPunto(Point p) {
        if (puntosTablero == null) {
            return null;
        }

        int distanciaMenor = 0;
        int distanciaActual = 0;
        Punto puntoCercano = null;

        for (int i = 0; i < puntosTablero.length; i++) { //Este for representa el eje de las Y

            for (int j = 0; j < puntosTablero[i].length; j++) {//Este for representa el eje de las X

                distanciaActual = distanciaActual + Math.abs(puntosTablero[i][j].obtenerX() - p.x);
                distanciaActual = distanciaActual + Math.abs(puntosTablero[i][j].obtenerY() - p.y);

                if (i == 0 && j == 0) {
                    distanciaMenor = distanciaActual;
                    puntoCercano = puntosTablero[i][j];
                }

                if (distanciaActual < distanciaMenor) {
                    distanciaMenor = distanciaActual;
                    puntoCercano = puntosTablero[i][j];
                }

                distanciaActual = 0;
            }
        }

        return puntoCercano;

    }

    public Punto obtenerPuntoReal(Punto punto) {
        for (int i = 0; i < puntosTablero.length; i++) { //Este for representa el eje de las Y

            for (int j = 0; j < puntosTablero[i].length; j++) {//Este for representa el eje de las X
                if(punto.equals(puntosTablero[i][j])) {
                    return puntosTablero[i][j];
                }
            }
        }
        
        
        return null;
    }

    public int getEspacioEntrePuntos() {
        return espacioEntrePuntos;
    }

}//Llave de la clase
