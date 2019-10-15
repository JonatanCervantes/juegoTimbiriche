/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objnegocio;

import java.util.List;



/**
 *
 * @author Usuario
 */
public class Partida {
    
    private List<Jugador> jugadores;
    Tablero tablero;
    
    public Partida() {
        
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    
    
}
