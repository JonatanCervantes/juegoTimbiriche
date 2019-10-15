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
public class Jugador {
    
    private int id;
    private String nombre;
    private String colorPref;
    
    public Jugador() {
        
    }
    
    public Jugador (int id, String nombre, String colorPref) {
        this.id = id;
        this.nombre = nombre;
        this.colorPref = colorPref;        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColorPref() {
        return colorPref;
    }

    public void setColorPref(String colorPref) {
        this.colorPref = colorPref;
    }
    
    
    
}
