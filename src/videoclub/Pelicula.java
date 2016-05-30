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
public class Pelicula extends Producto{

    private String genero, año;
    private ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
    
    public Pelicula(String nombre, double costoRenta, char rentado, int dias, String genero, String año)   {
        super(nombre, costoRenta, rentado, dias);
        this.genero = genero;
        this.año    = año;
    }
    
    private void crearPeliculas()   {
        listaPeliculas.add(new Pelicula("Star Wars", 10.30, '1', 5, "Accion", "2016"));
        listaPeliculas.add(new Pelicula("Star Trek", 10.30, '1', 7, "Accion", "2016"));
        listaPeliculas.add(new Pelicula("Captain America", 10.30, '1', 4, "Accion", "2016"));
        listaPeliculas.add(new Pelicula("Batman v Superman", 10.30, '1', 2, "Accion", "2016"));
        listaPeliculas.add(new Pelicula("Thor", 10.30, '1', 3, "Accion", "2013"));
    }
    
    public String getGenero()   {
        return genero;
    }
    
    public void setGenero(String genero)    {
        this.genero = genero;
    }

    public String getAño() {
        return año;
    }


    public void setAño(String año) {
        this.año = año;
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }
    
}
