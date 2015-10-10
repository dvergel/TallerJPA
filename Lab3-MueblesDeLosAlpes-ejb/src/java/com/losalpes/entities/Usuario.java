/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.entities;

import java.io.Serializable;
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
@TableGenerator(name = "sequsuario", initialValue = 1, allocationSize = 1)
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
    @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuario.findByTipoUsuario", query = "SELECT u FROM Usuario u WHERE u.tipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "Usuario.findByNombreCompleto", query = "SELECT u FROM Usuario u WHERE u.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "Usuario.findByDocumento", query = "SELECT u FROM Usuario u WHERE u.documento = :documento"),
    @NamedQuery(name = "Usuario.findByTipoDocumento", query = "SELECT u FROM Usuario u WHERE u.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Usuario.findByTelefonoLocal", query = "SELECT u FROM Usuario u WHERE u.telefonoLocal = :telefonoLocal"),
    @NamedQuery(name = "Usuario.findByTelefonoCelular", query = "SELECT u FROM Usuario u WHERE u.telefonoCelular = :telefonoCelular"),
    @NamedQuery(name = "Usuario.findByCiudadId", query = "SELECT u FROM Usuario u WHERE u.ciudadId = :ciudadId"),
    @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuario.findByProfesion", query = "SELECT u FROM Usuario u WHERE u.profesion = :profesion"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findBySeleccion", query = "SELECT u FROM Usuario u WHERE u.seleccion = :seleccion")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sequsuario")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CONTRASENA")
    private String contrasena;
    
    @Column(name = "TIPO_USUARIO")
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
    @Size(max = 50)
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Column(name = "DOCUMENTO")
    private Long documento;
    
    @Column(name = "TIPO_DOCUMENTO")
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    @Column(name = "TELEFONO_LOCAL")
    private Long telefonoLocal;
    @Column(name = "TELEFONO_CELULAR")
    private Long telefonoCelular;
    @Column(name = "CIUDAD_ID")
    private Short ciudadId;
    @Size(max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    
    @Column(name = "PROFESION")
    @Enumerated(EnumType.STRING)
    private Profesion profesion;
    @Size(max = 50)
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "SELECCION")
    private boolean seleccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<RegistroVenta> registroVentaList;

    public Usuario() {
    }

    public Usuario(Short id) {
        this.id = id;
    }

    public Usuario(Short id, String login, String contrasena) {
        this.id = id;
        this.login = login;
        this.contrasena = contrasena;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getTelefonoLocal() {
        return telefonoLocal;
    }

    public void setTelefonoLocal(Long telefonoLocal) {
        this.telefonoLocal = telefonoLocal;
    }

    public Long getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(Long telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public Short getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Short ciudadId) {
        this.ciudadId = ciudadId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }

    @XmlTransient
    public List<RegistroVenta> getRegistroVentaList() {
        return registroVentaList;
    }

    public void setRegistroVentaList(List<RegistroVenta> registroVentaList) {
        this.registroVentaList = registroVentaList;
    }
    
    public void agregarRegistro(RegistroVenta registro)
    {
        registroVentaList.add(registro);
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.losalpes.entities.Usuario[ id=" + id + " ]";
    }
    
}
