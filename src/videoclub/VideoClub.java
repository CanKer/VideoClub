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

        pelicula.crearPeliculas();          //Creamos películas muestra
        videojuego.crearVideojuegos();      //Creamos videojuegos muestra
        principal();
    }

    public static void listaPrincipal() {
        System.out.println("Seleccione la opción deseada: ");
        System.out.println("1) Agregar productos");
        System.out.println("2) Rentar productos");
        System.out.println("3) Mostrar datos");
        System.out.println("4) Salir");
    }

    public static void principal() {
        listaPrincipal();
        while (!in.hasNextInt()) {
            System.out.println("No se pueden ingresar letras o símbolos");
            listaPrincipal();
            in.next();
        }
        int opcion = in.nextInt();

        switch (opcion) {
            case 1:
                agregarProductos();
                break;
            case 2:
                rentarProductos();
                break;
            case 3:
                administrativo();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Opción incorrecta");
                principal();
                break;
        }
    }

    public static void listaProductos() {
        System.out.println("1) Videojuegos");
        System.out.println("2) Películas");
    }

    public static void agregarProductos() {
        System.out.println("¿Qué desea agregar?");
        listaProductos();
        while (!in.hasNextInt()) {
            System.out.println("No se pueden ingresar letras o símbolos");
            System.out.println("¿Qué desea agregar?");
            listaProductos();
            in.next();
        }
        int opcion = in.nextInt();
        switch (opcion) {
            case 1:
                agregarProducto("videojuego");
                break;
            case 2:
                agregarProducto("pelicula");
                break;
            default:
                System.out.println("Opción incorrecta");
                agregarProductos();
                break;
        }
    }

    public static void rentarProductos() {
        System.out.println("¿Qué desea rentar?");
        listaProductos();
        while (!in.hasNextInt()) {
            System.out.println("No se pueden ingresar letras o símbolos");
            System.out.println("¿Qué desea rentar?");
            listaProductos();
            in.next();
        }
        int opcion = in.nextInt();
        switch (opcion) {
            case 1:
                rentarProducto("videojuego");
                break;
            case 2:
                rentarProducto("pelicula");
                break;
            default:
                System.out.println("Opción incorrecta");
                rentarProductos();
                break;
        }
    }

    public static void listaAdministrativo() {
        System.out.println("Indique el código de su consulta. Solo se tomará en cuenta el primer dígito");
        System.out.println("T/t: Desplegar todos los productos:");
        System.out.println("P/p: Desplegar todas las películas");
        System.out.println("V/v: Desplegar todos los videojuegos");
        System.out.println("S/s: Checar estatus de película");
        System.out.println("J/j: Checar estatus de videojuego");
        System.out.println("C/c: Mostrar cantidad de películas rentadas");
        System.out.println("X/x: Mostrar cantidad de videojuegos para Xbox");
        System.out.println("R/r: Regresar al menú principal");
        System.out.println("U/u: Terminar programa");
    }

    public static void administrativo() {
        listaAdministrativo();
        char opcion = in.next().charAt(0);
        switch (opcion) {
            case 'T':
            case 't':
                mostrarPeliculas();
                mostrarVideojuegos();
                break;
            case 'P':
            case 'p':
                mostrarPeliculas();
                break;
            case 'V':
            case 'v':
                mostrarVideojuegos();
                break;
            case 'S':
            case 's':
                checarEstatusPelicula();
                break;
            case 'J':
            case 'j':
                checarEstatusVideojuego();
                break;
            case 'C':
            case 'c':
                mostrarPeliculasRentadas();
                break;
            case 'X':
            case 'x':
                mostrarVideojuegosXbox();
                break;
            case 'R':
            case 'r':
                principal();
            case 'U':
            case 'u':
                System.exit(0);
                break;
            default:
                System.out.println("Opción incorrecta");
                administrativo();
                break;
        }
    }

    public static void agregarProducto(String producto) {
        System.out.println("Cuántas " + producto + "s quiere agregar?");
        int cantidad = in.nextInt();
        for (int i = 1; i <= cantidad; i++) {
            System.out.println(producto + ": " + i);
            System.out.println("¿Cómo se llama?");
            String nombre = in.next();
            System.out.println("¿Qué precio tendrá?");
            double costoRenta = in.nextDouble();
            if (producto.equals("pelicula")) {
                String genero = null;
                do {
                    genero = seleccionarGenero();
                } while (genero == null);

                System.out.println("¿De qué año es?");
                String año = in.next();

                System.out.println(nombre + costoRenta + genero + año);

                pelicula.agregar(new Pelicula(nombre, costoRenta, '0', 0, genero, año));
            } else if (producto.equals("videojuego")) {
                String estilo = null;
                do {
                    estilo = seleccionarEstilo();
                } while (estilo == null);

                String plataforma = null;
                do {
                    plataforma = seleccionarPlataforma();
                } while (plataforma == null);

                System.out.println(nombre + " " + costoRenta + " " + estilo + " " + plataforma);
                videojuego.agregar(new Videojuego(nombre, costoRenta, '1', 0, estilo, plataforma));
            }

        }
        principal();
    }

    public static void rentarProducto(String producto) {
        Videojuego juego = null;
        Pelicula peli = null;
        in.nextLine();
        System.out.println("¿Cuál es el nombre de su producto?");
        String nombre = in.nextLine();
        System.out.println("¿Cuántos días quiere rentarlo?");
        int dias = in.nextInt();
        if (producto.equals("videojuego")) {
            juego = videojuego.status(nombre);
            if (juego != null) {
                if (juego.getRentado() != '1') {
                    juego.setRentado('1');
                    juego.setDias(dias);
                    System.out.println("Favor de pagar $" + juego.getCostoRenta(dias) + "MXN.");
                    System.out.println("Videojuego " + juego.getNombre() + " rentado exitosamente");
                } else {
                    System.out.println("Videojuego ocupado");
                }
            } else {
                System.out.println("El videojuego no existe");
            }
        } else if (producto.equals("pelicula")) {
            peli = pelicula.status(nombre);
            if (peli != null) {
                if (peli.getRentado() != '1') {
                    peli.setRentado('1');
                    peli.setDias(dias);
                    System.out.println("Favor de pagar $" + peli.getCostoRenta(dias) + "MXN.");
                    System.out.println("Pelicula " + peli.getNombre() + " rentada exitosamente");
                } else {
                    System.out.println("Película ocupada");
                }
            } else {
                System.out.println("La película no existe");
            }
        }
        principal();
    }

    public static void mostrarProductos() {
        System.out.println("Videojuegos: ");
        for (Videojuego x : videojuego.getListaJuegos()) {
            System.out.println(x.toString());
        }
        
        System.out.println("Películas: ");
        for (Pelicula x : pelicula.getListaPeliculas()) {
            System.out.println(x.toString());
        }

        administrativo();
    }

    public static void mostrarPeliculas() {
        System.out.println("Películas: ");
        for (Pelicula x : pelicula.getListaPeliculas()) {
            System.out.println(x.toString());
        }

        administrativo();
    }

    public static void mostrarVideojuegos() {
        System.out.println("Videojuegos: ");
        for (Videojuego x : videojuego.getListaJuegos()) {
            System.out.println(x.toString());
        }

        administrativo();
    }

    public static void checarEstatusPelicula() {
        Pelicula peli;
        in.nextLine();
        System.out.println("¿Cuál es el nombre de la película a buscar?");
        String nombre = in.nextLine();
        peli = pelicula.status(nombre);
        if (peli != null) {
            if (peli.getRentado() != '0') {
                System.out.println("La película " + peli.getNombre() + " no está disponible");
            } else {
                System.out.println("La película " + peli.getNombre() + " está disponible");
            }

        } else {
            System.out.println("No existe");
        }

        administrativo();
    }

    public static void checarEstatusVideojuego() {
        Videojuego juego;
        in.nextLine();
        System.out.println("¿Cuál es el nombre del videojuego a buscar?");
        String nombre = in.nextLine();
        juego = videojuego.status(nombre);
        if (juego != null) {
            if (juego.getRentado() != '0') {
                System.out.println("El videojuego " + juego.getNombre() + " no está disponible");
            } else {
                System.out.println("El videojuego " + juego.getNombre() + " está disponible");
            }

        } else {
            System.out.println("No existe");
        }

        administrativo();
    }

    public static void mostrarPeliculasRentadas() {
        System.out.println("Existen" + pelicula.rentadas() + " películas rentadas");

        administrativo();
    }

    public static void mostrarVideojuegosXbox() {
        System.out.println("Existen " + videojuego.conXbox() + " videojuegos para Xbox");

        administrativo();
    }

    public static void listaEstilos() {
        System.out.println("Seleccione el estilo: ");
        System.out.println("1) Acción");
        System.out.println("2) Deportes");
        System.out.println("3) Aventura");
    }

    public static void listaPlataformas() {
        System.out.println("¿Para qué plataforma es?");
        System.out.println("1) Xbox");
        System.out.println("2) Playstation");
        System.out.println("3) Wii");
    }

    public static void listaGeneros() {
        System.out.println("Seleccione el género: ");
        System.out.println("1) Acción");
        System.out.println("2) Fantasía");
        System.out.println("3) Drama");
        System.out.println("4) Comedia");
        System.out.println("5) Aventura");
    }

    public static String seleccionarEstilo() {
        listaEstilos();

        while (!in.hasNextInt()) {
            System.out.println("No se pueden ingresar letras o símbolos");
            listaEstilos();
            in.next();
        }
        int opcion = in.nextInt();
        switch (opcion) {
            case 1:
                return "Acción";
            case 2:
                return "Deportes";
            case 3:
                return "Aventura";
            default:
                System.out.println("Opción incorrecta");
        }
        return null;
    }

    public static String seleccionarPlataforma() {
        listaPlataformas();
        while (!in.hasNextInt()) {
            System.out.println("No se pueden ingresar letras o símbolos");
            listaPlataformas();
            in.next();
        }
        int opcion = in.nextInt();
        switch (opcion) {
            case 1:
                return "Xbox";
            case 2:
                return "Playstation";
            case 3:
                return "Wii";
            default:
                System.out.println("Opción incorrecta");
        }
        return null;
    }

    public static String seleccionarGenero() {
        listaGeneros();
        while (!in.hasNextInt()) {
            System.out.println("No se pueden ingresar letras o símbolos");
            listaGeneros();
            in.next();
        }
        int opcion = in.nextInt();

        switch (opcion) {
            case 1:
                return "Acción";
            case 2:
                return "Fantasía";
            case 3:
                return "Drama";
            case 4:
                return "Comedia";
            case 5:
                return "Aventura";
            default:
                System.out.println("Opción incorrecta");
        }
        return null;
    }

}
