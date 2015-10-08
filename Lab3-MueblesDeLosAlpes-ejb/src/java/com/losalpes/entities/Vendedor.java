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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author de.vergel10
 */
@Entity
@Table(name = "VENDEDOR", catalog = "", schema = "CSOF5302051520")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findById", query = "SELECT v FROM Vendedor v WHERE v.id = :id"),
    @NamedQuery(name = "Vendedor.findByNombres", query = "SELECT v FROM Vendedor v WHERE v.nombres = :nombres"),
    @NamedQuery(name = "Vendedor.findByApellidos", query = "SELECT v FROM Vendedor v WHERE v.apellidos = :apellidos"),
    @NamedQuery(name = "Vendedor.findBySalario", query = "SELECT v FROM Vendedor v WHERE v.salario = :salario"),
    @NamedQuery(name = "Vendedor.findByComisionVentas", query = "SELECT v FROM Vendedor v WHERE v.comisionVentas = :comisionVentas"),
    @NamedQuery(name = "Vendedor.findByPerfil", query = "SELECT v FROM Vendedor v WHERE v.perfil = :perfil"),
    @NamedQuery(name = "Vendedor.findByFoto", query = "SELECT v FROM Vendedor v WHERE v.foto = :foto")})
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Size(max = 50)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 50)
    @Column(name = "APELLIDOS")
    private String apellidos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARIO")
    private BigDecimal salario;
    @Column(name = "COMISION_VENTAS")
    private BigDecimal comisionVentas;
    @Size(max = 50)
    @Column(name = "PERFIL")
    private String perfil;
    @Size(max = 50)
    @Column(name = "FOTO")
    private String foto;
    @OneToMany(mappedBy = "vendedorId", fetch = FetchType.LAZY)
    private List<Experienciavendedor> experienciavendedorList;

    public Vendedor() {
    }

    public Vendedor(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getComisionVentas() {
        return comisionVentas;
    }

    public void setComisionVentas(BigDecimal comisionVentas) {
        this.comisionVentas = comisionVentas;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public List<Experienciavendedor> getExperienciavendedorList() {
        return experienciavendedorList;
    }

    public void setExperienciavendedorList(List<Experienciavendedor> experienciavendedorList) {
        this.experienciavendedorList = experienciavendedorList;
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
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.losalpes.entities.Vendedor[ id=" + id + " ]";
    }
    
}
