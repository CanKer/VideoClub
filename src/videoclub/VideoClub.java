/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

import java.util.Scanner;

/**
 *
 * @author CanKer
 */
public class VideoClub {

    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
                
        System.out.println("Seleccione la opción deseada: ");
        int opcion = in.nextInt();
        
        switch(opcion)  {
            case 1:
                agregarProductos();
                break;
            case 2:
                administrativo();
                break;
        }
        

        
        
    }
    public static void agregarProductos()    {
        System.out.println("¿Qué desea agregar?");
        System.out.println("1) Videojuegos");
        System.out.println("2) Películas");
        int opcion = in.nextInt();
        switch(opcion)  {
            case 1:
                break;
            case 2:
                break;
        }
       
    }
    
    public static void administrativo() {
        System.out.println("Indique el código de su consulta");
        System.out.println("T/t: Desplegar todos los productos:");
        System.out.println("P/p: Desplegar todas las películas");
        System.out.println("V/v: Desplegar todos los videojuegos");
        System.out.println("S/s: Checar estatus de película");
        System.out.println("J/j: Checar estatus de videojuego");
        System.out.println("C/c: Mostrar cantidad de películas rentadas");
        System.out.println("X/x: Mostrar cantidad de videojuegos para Xbox");
        System.out.println("U/u: Terminar programa");
        int opcion = in.nextInt();
        switch(opcion)  {
            case 'T':
                mostrarProductos();
                break;
            case 'P':
                mostrarPeliculas();
                break;
            case 'V':
                mostrarVideojuegos();
                break;
            case 'S':
                checarEstatusPelicula();
                break;
            case 'J':
                checarEstatusVideojuego();
                break;
            case 'C':
                mostrarPeliculasRentadas();
                break;
            case 'X':
                mostrarVideojuegosXbox();
                break;
            case 'U':
                break;
        }
    }
    public static void mostrarProductos()   {
        
    }
    public static void mostrarPeliculas()   {
        
    }
    public static void mostrarVideojuegos() {
        
    }
    public static void checarEstatusPelicula()  {
        
    }
    public static void checarEstatusVideojuego()    {
        
    }
    public static void mostrarPeliculasRentadas()   {
        
    }
    public static void mostrarVideojuegosXbox() {
        
    }
}
