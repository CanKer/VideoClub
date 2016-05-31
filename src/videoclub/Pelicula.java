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
public class Pelicula extends Producto{

    private String genero, año;
    private List<Pelicula> listaPeliculas = new ArrayList<>();
    
    public Pelicula()   {}
    public Pelicula(String nombre, double costoRenta, char rentado, int dias, String genero, String año)   {
        super(nombre, costoRenta, rentado, dias);
        this.genero = genero;
        this.año    = año;
    }
    
    public void crearPeliculas()   {
        listaPeliculas.add(new Pelicula("Star Wars", 10.30, '1', 5, "Accion", "2016"));
        listaPeliculas.add(new Pelicula("Star Trek", 10.30, '0', 7, "Accion", "2016"));
        listaPeliculas.add(new Pelicula("Captain America", 10.30, '0', 4, "Accion", "2016"));
        listaPeliculas.add(new Pelicula("Batman v Superman", 10.30, '0', 2, "Accion", "2016"));
        listaPeliculas.add(new Pelicula("Thor", 10.30, '1', 3, "Accion", "2013"));
    }
    
    public void agregar(Pelicula p) {
        listaPeliculas.add(p);
    }
    
    public Pelicula status(String nombre) {
        Pelicula respuesta = null;
        
        for(Pelicula pelicula : listaPeliculas) {
            if(pelicula.getNombre().equals(nombre))

            if(nombre.equals(pelicula.getNombre()))   {
                respuesta  = pelicula;
            } 
        }
        return respuesta;
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

    public List<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(List<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }
    
    public int rentadas()  {
        int contador = 0;
        for(Pelicula pelicula : listaPeliculas)   {
            contador = (pelicula.getRentado() == '1') ? contador + 1 : contador;
        }
        return contador;
    }
    
    @Override
    public String toString()    {
        return getNombre() + "\n\tCosto:\t\t" +getCostoRenta(1)+ "\n\tEstado:\t\t" +getRentado()+
                "\n\tDias:\t\t" +getDias()+ "\n\tGénero:\t\t" +getGenero()+
                "\n\tAño:\t\t" +getAño();
    }
    
    
}
