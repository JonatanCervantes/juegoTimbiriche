package objnegocio;

import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class Punto extends Point {

    private int x;
    private int y;

    private boolean lineaDerecha ;
    private boolean lineaAbajo;
    private boolean lineaIzquierda;
    private boolean lineaArriba;

    private boolean[] direcciones;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;

        lineaDerecha = false;
        lineaAbajo = false;
        lineaIzquierda = false;
        lineaArriba = false;

    }

    public int obtenerX() {
        return x;
    }

    public int obtenerY() {
        return y;
    }

    public boolean isLineaDerecha() {
        return lineaDerecha;
    }

    public void setLineaDerecha(boolean lineaDerecha) {
        this.lineaDerecha = lineaDerecha;
    }

    public boolean isLineaAbajo() {
        return lineaAbajo;
    }

    public void setLineaAbajo(boolean lineaAbajo) {
        this.lineaAbajo = lineaAbajo;
    }

    public boolean isLineaIzquierda() {
        return lineaIzquierda;
    }

    public void setLineaIzquierda(boolean lineaIzquierda) {
        this.lineaIzquierda = lineaIzquierda;
    }

    public boolean isLineaArriba() {
        return lineaArriba;
    }

    public void setLineaArriba(boolean lineaArriba) {
        this.lineaArriba = lineaArriba;
    }

    public boolean[] getDirecciones() {
        return direcciones;
    }

    public boolean[] obtenerDirecciones() {
        direcciones = new boolean[4];
        direcciones[0] = lineaDerecha;
        direcciones[1] = lineaAbajo;
        direcciones[2] = lineaIzquierda;
        direcciones[3] = lineaArriba;

        return direcciones;
    }
    
    public String obtenerPosicion() {
        return "Pos X= " + obtenerX() + ", Pos Y = " + obtenerY();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Punto other = (Punto) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    

}
