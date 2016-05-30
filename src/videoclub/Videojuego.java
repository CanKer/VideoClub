/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

import java.util.ArrayList;

/**
 *
 * @author CanKer
 */
public class Videojuego extends Producto{
    
    private String estilo, plataforma;
    private ArrayList<Videojuego> listaJuegos = new ArrayList<Videojuego>();

    
    
    public Videojuego(String nombre, double costoRenta, char rentado, int dias, String estilo, String plataforma) {
        super(nombre, costoRenta, rentado, dias);
        this.estilo     = estilo;
        this.plataforma = plataforma;
    }
    
    private void crearVideojuegos() {
        listaJuegos.add(new Videojuego("World of Warcraft", 20.30, '0', 0, "Aventuras", "Xbox"));
        listaJuegos.add(new Videojuego("The Witcher", 50.50, '1', 5, "Aventuras", "PlayStation"));
        listaJuegos.add(new Videojuego("Star Wars", 200.30, '0', 0, "Aventuras", "Wii"));
        listaJuegos.add(new Videojuego("Doom", 50.80, '0', 0, "Aventuras", "PlayStation"));
        listaJuegos.add(new Videojuego("Half Life", 20.90, '0', 0, "Aventuras", "Xbox"));
    }


    public String getEstilo() {
        return estilo;
    }


    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }


    public String getPlataforma() {
        return plataforma;
    }


    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }


    public ArrayList<Videojuego> getListaJuegos() {
        return listaJuegos;
    }


    public void setListaJuegos(ArrayList<Videojuego> listaJuegos) {
        this.listaJuegos = listaJuegos;
    }
    
    
    
}
