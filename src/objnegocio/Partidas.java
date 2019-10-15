/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objnegocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Partidas {
    
    private static ArrayList<Partida> partidasRegistradas;
    
    public Partidas() {       
        partidasRegistradas = new ArrayList<Partida>();
        
    }

    public List<Partida> getPartidasRegistradas() {
        return partidasRegistradas;
    }
    
    
    
}
