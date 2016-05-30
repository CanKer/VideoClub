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
    static Videojuego videojuego = new Videojuego();
    static Pelicula pelicula = new Pelicula();
    
    public static void main(String[] args) {
        
        pelicula.crearPeliculas();
        videojuego.crearVideojuegos();
        principal();
    }
    public static void principal()  {
        System.out.println("Seleccione la opción deseada: ");
        System.out.println("1) Agregar productos");
        System.out.println("2) Mostrar datos");
        System.out.println("3) Salir");
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
                agregarProducto("videojuego");
                break;
            case 2:
                agregarProducto("pelicula");
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
            char opcion = in.next(".").charAt(0);
        switch(opcion)  {
            case 'T':
            case 't':
                mostrarProductos();
                break;
            case 'P':
            case 'p':
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

    public static void agregarProducto(String producto)    {
        System.out.println("Cuántas "+producto+"s quiere agregar?");
        int cantidad = in.nextInt();
        for(int i = 1; i <= cantidad; i++)  {
            System.out.println(producto + ": "+ i);
            System.out.println("¿Cómo se llama?");
            String nombre = in.next();
            System.out.println("¿Qué precio tendrá?");
                double costoRenta = in.nextDouble();
            if(producto.equals("pelicula")) {
                System.out.println("Seleccione el género: ");
                System.out.println("1) Acción");
                System.out.println("2) Fantasía");
                System.out.println("3) Drama");
                System.out.println("4) Comedia");
                System.out.println("5) Aventura");
                    int opcionGenero = in.nextInt();
                    String genero = obtenerGenero(opcionGenero);
                System.out.println("¿De qué año es?");
                    String año = in.next();
                
                System.out.println(nombre + costoRenta + genero + año);
                
                pelicula.agregar(new Pelicula(nombre, costoRenta, '1', 0, genero, año));
            } else if(producto.equals("videojuego"))    {
                System.out.println("Seleccione el estilo: ");
                System.out.println("1) Acción");
                System.out.println("2) Deportes");
                System.out.println("5) Aventura");
                    int opcionEstilo = in.nextInt();
                    String estilo = obtenerEstilo(opcionEstilo);
                System.out.println("¿Para qué plataforma es?");
                System.out.println("1) Xbox");
                System.out.println("2) Playstation");
                System.out.println("5) Wii");
                    int opcionPlataforma = in.nextInt();
                    String plataforma = obtenerPlataforma(opcionPlataforma);
                
                System.out.println(nombre + " " + costoRenta + " " + estilo + " " + plataforma);
                videojuego.agregar(new Videojuego(nombre, costoRenta, '1', 0, estilo, plataforma));
            }

        }
        principal();
    }
    public static void mostrarProductos()   {
        mostrarPeliculas();
        mostrarVideojuegos();
        
        principal();
    }
    public static void mostrarPeliculas()   {
        System.out.println("Películas: ");
        for(Pelicula x : pelicula.getListaPeliculas())   {
            System.out.println(x.toString());
        }
        
        principal();
    }
    public static void mostrarVideojuegos() {
        System.out.println("Videojuegos: ");
        for(Videojuego x : videojuego.getListaJuegos()) {
            System.out.println(x.toString());
        }
        
        principal();
    }
    public static void checarEstatusPelicula()  {
        in.nextLine();
        System.out.println("¿Cuál es el nombre de la película a buscar?");
        String nombre = in.nextLine();
        System.out.println(pelicula.status(nombre));
        
        principal();
    }
    public static void checarEstatusVideojuego()    {
        in.nextLine();
        System.out.println("¿Cuál es el nombre del videojuego a buscar?");
        String nombre = in.nextLine();
        System.out.println(videojuego.status(nombre));
        
        principal();
    }
    public static void mostrarPeliculasRentadas()   {
        System.out.println(pelicula.rentadas());
        
        principal();
    }
    public static void mostrarVideojuegosXbox() {
        System.out.println("Existen " + videojuego.conXbox() + " videojuegos para Xbox");
        
        principal();
    }
    public static String obtenerGenero(int opcion)  {
        String genero = null;
        switch(opcion)  {
            case 1:
                genero = "Acción";
                break;
            case 2:
                genero = "Fantasía";
                break;
            case 3:
                genero = "Drama";
                break;
            case 4:
                genero = "Comedia";
                break;
            case 5:
                genero = "Aventura";
                break;                
        }
        
        return genero;
    }
    public static String obtenerEstilo(int opcion)  {
        String estilo = null;
        switch(opcion)  {
            case 1:
                estilo = "Acción";
                break;
            case 2:
                estilo = "Deportes";
                break;
            case 3:
                estilo = "Aventura";
                break;                
        }
        
        return estilo;
    }
    public static String obtenerPlataforma(int opcion)  {
        String plataforma = null;
        switch(opcion)  {
            case 1:
                plataforma = "Xbox";
                break;
            case 2:
                plataforma = "Playstation";
                break;
            case 3:
                plataforma = "Wii";
                break;
        }
        return plataforma;
    }
       
}
