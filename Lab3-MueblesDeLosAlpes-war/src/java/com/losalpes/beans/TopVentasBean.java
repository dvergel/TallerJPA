/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.dto.MuebleVendido;
import com.losalpes.servicios.IServicioCatalogoMockLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Zamir
 */
@ManagedBean
@RequestScoped
public class TopVentasBean {
    
    @EJB
    private IServicioCatalogoMockLocal servicioCatalogo;
    
    private List<MuebleVendido> mueblesVendidos;

    /**
     * Creates a new instance of TopVentasBean
     */
    public TopVentasBean() {
    }

    public List<MuebleVendido> getMueblesVendidos() {
        return mueblesVendidos;
    }

    public void setMueblesVendidos(List<MuebleVendido> mueblesVendidos) {
        this.mueblesVendidos = mueblesVendidos;
    }
    
    @PostConstruct
    public void init(){
        mueblesVendidos = servicioCatalogo.getMueblesMasVendidos();
    }
    
}
