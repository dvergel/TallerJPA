/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioCatalogoMockTest.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.servicios;

import com.losalpes.entities.TipoMueble;
import com.losalpes.entities.Mueble;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase encargada de realizar pruebas unitarias
 */
@Stateless
public class ServicioCatalogoMockTest
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Arreglo de muebles de prueba
     */
    private ArrayList<Mueble> muebles;
    @EJB
    private IServicioCatalogoMockLocal instance;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos
     */
    public ServicioCatalogoMockTest()
    {
        
    }

    //-----------------------------------------------------------
    // Métodos de inicialización y terminación
    //-----------------------------------------------------------

    /**
     * Método que se ejecuta antes de comenzar la prueba unitaria
     * Se encarga de inicializar todo lo necesario para la prueba
     */
    @Before
    public void setUp() 
    {

        //Inicializa arreglo de prueba
        muebles=new ArrayList<Mueble>();

        //Agrega los muebles del sistema
        muebles.add(new Mueble(Short.valueOf("1L"), "Silla clásica", "Una confortable silla con estilo del siglo XIX.", TipoMueble.Interior.toString(), Short.valueOf("45"), "", new BigDecimal(123)));
        muebles.add(new Mueble(Short.valueOf("2L"), "Silla moderna", "Lo último en la moda de interiores. Esta silla le brindará la comodidad e innovación que busca", TipoMueble.Interior.toString(), Short.valueOf("50"), "", new BigDecimal(5464)));
        muebles.add(new Mueble(Short.valueOf("3L"), "Mesa de jardín", "Una bella mesa para comidas y reuniones al aire libre.", TipoMueble.Exterior.toString(), Short.valueOf("100"), "", new BigDecimal(4568)));
        muebles.add(new Mueble(Short.valueOf("4L"), "Sillón new wave", "Innovador y cómodo. No existen mejores palabras para describir este hermoso sillón.", TipoMueble.Interior.toString(), Short.valueOf("60"), "", new BigDecimal(5655)));
        muebles.add(new Mueble(Short.valueOf("5L"), "Mesa para comedor", "Sus cenas no tendrán mejor acompañante. Una mesa para seis personas con un hermoso diseño clásico.", TipoMueble.Interior.toString(), Short.valueOf("70"), "", new BigDecimal(1345)));
        muebles.add(new Mueble(Short.valueOf("6L"), "Cama king", "Una hermosa cama hecha en cedro para dos personas. Sus sueños no volveran a ser iguales.", TipoMueble.Interior.toString(), Short.valueOf("50"), "", new BigDecimal(63358)));
        muebles.add(new Mueble(Short.valueOf("7L"), "Silla de jardín", "Una bella silla para comidas y reuniones al aire libre.", TipoMueble.Exterior.toString(), Short.valueOf("65"), "", new BigDecimal(678)));
        muebles.add(new Mueble(Short.valueOf("8L"), "Camarote junior", "Con diseño moderno. Sus hijos ahora podrán tener unos felices sueños.", TipoMueble.Interior.toString(), Short.valueOf("85"), "", new BigDecimal(56565)));


    }

    /**
     * Método que se ejecuta después de haber ejecutado la prueba
     */
    @After
    public void tearDown()
    {
        
    }

    //-----------------------------------------------------------
    // Métodos de prueba
    //-----------------------------------------------------------

    /**
     * Prueba para agregar un mueble en el sistema
     */
    @Test
    public void testAgregarMueble()
    {
        System.out.println("agregarMueble");
        Mueble mueble = new Mueble(Short.valueOf("9L"),"SillaTest","Una confortable silla.",TipoMueble.Interior.toString(),Short.valueOf("60"),"",new BigDecimal(5342));
        int actual=instance.darMuebles().size();
        instance.agregarMueble(mueble);
        int esperado=instance.darMuebles().size();
        assertEquals(esperado,actual+1);
    }

    /**
     * Prueba para obtener todos los muebles del sistema
     */
    @Test
    public void testDarMuebles()
    {
        System.out.println("darMuebles");
        ServicioCatalogoMock instance = new ServicioCatalogoMock();
        List result = instance.darMuebles();
        assertNotNull(result);          
    }

}