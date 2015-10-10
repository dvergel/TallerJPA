/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.dto;

/**
 *
 * @author Zamir
 */
public class MuebleVendido {
    
    private long id;
    
    private long cantidad;
    
    private String nombre;

    public MuebleVendido() {
    }

    public MuebleVendido(long id, long cantidad, String nombre) {
        this.id = id;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
