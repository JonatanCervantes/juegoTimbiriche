/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import objnegocio.Jugador;
import objnegocio.Jugadores;

/**
 *
 * @author Usuario
 */
public class Control {
    
    private static Control controlin = new Control();
    private Jugadores jugadores = new Jugadores();
    
    
    
    private Control() {}
    
    public static Control obtenerInstancia() {
        return controlin;
        
    }
    
    public void agregarJugador(String nombre, String colorPref) {
        jugadores.agregarJugador(nombre, colorPref);
    }
    
    public ArrayList<Jugador> obtenerJugadores() {
        return jugadores.getJugadores();
    }
    
    
    
}
