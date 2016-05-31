/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Omar
 */
public class Videojuego extends Producto{
    
    private String estilo, plataforma;
    private List<Videojuego> listaJuegos = new ArrayList<>();

    public Videojuego() {}
    public Videojuego(String nombre, double costoRenta, char rentado, int dias, String estilo, String plataforma) {
        super(nombre, costoRenta, rentado, dias);
        this.estilo     = estilo;
        this.plataforma = plataforma;
    }
    
    public void crearVideojuegos() {
        listaJuegos.add(new Videojuego("World of Warcraft", 20.30, '0', 0, "Aventuras", "Xbox"));
        listaJuegos.add(new Videojuego("The Witcher", 50.50, '1', 5, "Aventuras", "PlayStation"));
        listaJuegos.add(new Videojuego("Star Wars", 200.30, '0', 0, "Aventuras", "Wii"));
        listaJuegos.add(new Videojuego("Doom", 50.80, '0', 0, "Aventuras", "PlayStation"));
        listaJuegos.add(new Videojuego("Half Life", 20.90, '0', 0, "Aventuras", "Xbox"));
    }

    public void agregar(Videojuego e)   {
        listaJuegos.add(e);
    }
    
    public Videojuego status(String nombre) {
        Videojuego respuesta = null;
        
        for(Videojuego videojuego : listaJuegos) {
            if(videojuego.getNombre().equals(nombre))

            if(nombre.equals(videojuego.getNombre()))   {
                respuesta  = videojuego;
            } 
        }
        return respuesta;
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

    public List<Videojuego> getListaJuegos() {
        return listaJuegos;
    }

    public void setListaJuegos(ArrayList<Videojuego> listaJuegos) {
        this.listaJuegos = listaJuegos;
    }
    
    public int conXbox()  {
        int contador = 0;
        for(Videojuego videojuego : getListaJuegos())   {
            contador = (videojuego.getPlataforma().equalsIgnoreCase("Xbox")) ? contador + 1 : contador;
        }
        return contador;
    }
    
  //  @Override
    public String toString()    {
        return getNombre() + "\n\tCosto:\t\t" +getCostoRenta(1)+ "\n\tEstado:\t\t" +getRentado()+
                "\n\tDias:\t\t" +getDias()+ "\n\tEstilo:\t\t" +getEstilo()+
                "\n\tPlataforma:\t" +getPlataforma();
    } 
    
    
}
