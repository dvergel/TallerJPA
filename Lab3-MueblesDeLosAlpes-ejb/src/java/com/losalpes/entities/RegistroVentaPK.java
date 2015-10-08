/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author de.vergel10
 */
@Embeddable
public class RegistroVentaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VENTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTO")
    private short producto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPRADOR")
    private short comprador;

    public RegistroVentaPK() {
    }

    public RegistroVentaPK(Date fechaVenta, short producto, short comprador) {
        this.fechaVenta = fechaVenta;
        this.producto = producto;
        this.comprador = comprador;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public short getProducto() {
        return producto;
    }

    public void setProducto(short producto) {
        this.producto = producto;
    }

    public short getComprador() {
        return comprador;
    }

    public void setComprador(short comprador) {
        this.comprador = comprador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.fechaVenta);
        hash = 97 * hash + this.producto;
        hash = 97 * hash + this.comprador;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegistroVentaPK other = (RegistroVentaPK) obj;
        if (!Objects.equals(this.fechaVenta, other.fechaVenta)) {
            return false;
        }
        if (this.producto != other.producto) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "com.losalpes.entities.RegistroVentaPK[ fechaVenta=" + fechaVenta + ", producto=" + producto + ", comprador=" + comprador + " ]";
    }
    
}
