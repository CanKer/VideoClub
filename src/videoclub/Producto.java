package videoclub;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CanKer
 */
public class Producto {
    
    private String    nombre;
    private double     costoRenta;
    private char      rentado;
    private int       dias;
    
    public Producto(String nombre, double costoRenta, char rentado, int dias) {
        this.nombre         = nombre;
        this.costoRenta     = costoRenta;
        this.rentado        = rentado;
        this.dias           = dias;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getCostoRenta() {
        return costoRenta;
    }


    public void setCostoRenta(double costoRenta) {
        this.costoRenta = costoRenta;
    }


    public char getRentado() {
        return rentado;
    }


    public void setRentado(char rentado) {
        this.rentado = rentado;
    }


    public int getDias() {
        return dias;
    }


    public void setDias(int dias) {
        this.dias = dias;
    }
    
    
}
