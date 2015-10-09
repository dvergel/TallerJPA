/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author de.vergel10
 */
@Entity
@Table(name = "REGISTRO_VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroVenta.findAll", query = "SELECT r FROM RegistroVenta r"),
    @NamedQuery(name = "RegistroVenta.findByFechaVenta", query = "SELECT r FROM RegistroVenta r WHERE r.registroVentaPK.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "RegistroVenta.findByProducto", query = "SELECT r FROM RegistroVenta r WHERE r.registroVentaPK.producto = :producto"),
    @NamedQuery(name = "RegistroVenta.findByComprador", query = "SELECT r FROM RegistroVenta r WHERE r.registroVentaPK.comprador = :comprador"),
    @NamedQuery(name = "RegistroVenta.findByCantidad", query = "SELECT r FROM RegistroVenta r WHERE r.cantidad = :cantidad")})
public class RegistroVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegistroVentaPK registroVentaPK;
    @Column(name = "CANTIDAD")
    private short cantidad;
    @JoinColumn(name = "COMPRADOR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;
    @JoinColumn(name = "PRODUCTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mueble mueble;
    @JoinColumn(name = "CIUDAD", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ciudad ciudad;

    public RegistroVenta() {
    }

    public RegistroVenta(RegistroVentaPK registroVentaPK) {
        this.registroVentaPK = registroVentaPK;
    }
    
    /**
     * Constructor de la clase con argumentos
     * @param fechaVenta Fecha en que se realizó la venta
     * @param producto Mueble adquirido
     * @param cantidad Cantidad adquirida
     * @param ciudad Ciudad en la que se vendió el producto
     * @param comprador Usuario que compro el mueble
     */
    public RegistroVenta(Date fechaVenta, Mueble producto, short cantidad,
            Ciudad ciudad, Usuario comprador)
    {
        this.registroVentaPK =  new RegistroVentaPK(fechaVenta, producto.getId(), comprador.getId()); 
        this.cantidad = cantidad;
        this.ciudad = ciudad;
    }

    public RegistroVenta(Date fechaVenta, short producto, short comprador) {
        this.registroVentaPK = new RegistroVentaPK(fechaVenta, producto, comprador);
    }

    public RegistroVentaPK getRegistroVentaPK() {
        return registroVentaPK;
    }

    public void setRegistroVentaPK(RegistroVentaPK registroVentaPK) {
        this.registroVentaPK = registroVentaPK;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Mueble getMueble() {
        return mueble;
    }

    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registroVentaPK != null ? registroVentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroVenta)) {
            return false;
        }
        RegistroVenta other = (RegistroVenta) object;
        if ((this.registroVentaPK == null && other.registroVentaPK != null) || (this.registroVentaPK != null && !this.registroVentaPK.equals(other.registroVentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.losalpes.entities.RegistroVenta[ registroVentaPK=" + registroVentaPK + " ]";
    }
    
}
