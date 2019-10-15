/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objnegocio;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Jugadores {
    
   private static int contadorJugadores = 0; 
   private static ArrayList<Jugador> jugadores;
   
   public Jugadores() {
       jugadores = new ArrayList<Jugador>();
   }
   
   public void agregarJugador(Jugador jugador) {
       jugadores.add(jugador);       
   }
   
   public void agregarJugador(String nombre, String colorPref) {
       contadorJugadores++;
       Jugador jug = new Jugador(contadorJugadores, nombre, colorPref);
       jugadores.add(jug);       
   }
   
   


    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
   
   
    
    
}
