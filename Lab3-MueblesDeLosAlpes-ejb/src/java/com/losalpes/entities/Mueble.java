/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author de.vergel10
 */
@Entity
@TableGenerator(name = "seqmueble", initialValue = 1, allocationSize = 1)
@Table(name = "MUEBLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mueble.findAll", query = "SELECT m FROM Mueble m"),
    @NamedQuery(name = "Mueble.findById", query = "SELECT m FROM Mueble m WHERE m.id = :id"),
    @NamedQuery(name = "Mueble.findByReferencia", query = "SELECT m FROM Mueble m WHERE m.referencia = :referencia"),
    @NamedQuery(name = "Mueble.findByNombre", query = "SELECT m FROM Mueble m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Mueble.findByDescripcion", query = "SELECT m FROM Mueble m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Mueble.findByTipo", query = "SELECT m FROM Mueble m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "Mueble.findByPrecio", query = "SELECT m FROM Mueble m WHERE m.precio = :precio"),
    @NamedQuery(name = "Mueble.findByImagen", query = "SELECT m FROM Mueble m WHERE m.imagen = :imagen"),
    @NamedQuery(name = "Mueble.findByCantidad", query = "SELECT m FROM Mueble m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "Mueble.findBySeleccion", query = "SELECT m FROM Mueble m WHERE m.seleccion = :seleccion")})
public class Mueble implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seqmueble")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REFERENCIA")
    private short referencia;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoMueble tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Size(max = 50)
    @Column(name = "IMAGEN")
    private String imagen;
    @Column(name = "CANTIDAD")
    private Short cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SELECCION")
    private short seleccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mueble", fetch = FetchType.LAZY)
    private List<RegistroVenta> registroVentaList;

    public Mueble() {
    }

    public Mueble(Short id) {
        this.id = id;
    }

    public Mueble(Short id, short referencia, short seleccion) {
        this.id = id;
        this.referencia = referencia;
        this.seleccion = seleccion;
    }
    
    /**
     * Constructor de la clase. Inicializa los atributos con los valores que ingresan por parametro.
     * @param referencia Referencia del mueble
     * @param nombre Nombre del mueble
     * @param descripcion Descripión del mueble
     * @param tipo Tipo de mueble
     * @param cantidad Cantidad de ejemplares
     */
    public Mueble(short referencia, String nombre, String descripcion, TipoMueble tipo,Short cantidad,String imagen,BigDecimal precio)
    {
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad=cantidad;
        this.imagen=imagen;
        this.precio=precio;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public short getReferencia() {
        return referencia;
    }

    public void setReferencia(short referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoMueble getTipo() {
        return tipo;
    }

    public void setTipo(TipoMueble tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public short getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(short seleccion) {
        this.seleccion = seleccion;
    }

    @XmlTransient
    public List<RegistroVenta> getRegistroVentaList() {
        return registroVentaList;
    }

    public void setRegistroVentaList(List<RegistroVenta> registroVentaList) {
        this.registroVentaList = registroVentaList;
    }
    
    /**
     * Aumenta la cantidad de muebles
     */
    public void incrementarCantidad()
    {
        cantidad++;
    }
    
    /**
     * Reduce la cantidad de muebles
     */
    public void reducirCantidad()
    {
        cantidad--;
    } 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mueble)) {
            return false;
        }
        Mueble other = (Mueble) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.losalpes.entities.Mueble[ id=" + id + " ]";
    }
    
}
