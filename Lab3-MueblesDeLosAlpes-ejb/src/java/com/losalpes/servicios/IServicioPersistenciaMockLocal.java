/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ IServicioPersistenciaMockLocal.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.servicios;

import com.losalpes.excepciones.OperacionInvalidaException;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 * Contrato funcional de los servicios de persistencia de manera local.
 * 
 */
@Local
public interface IServicioPersistenciaMockLocal
{

    /**
     * Crea un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere crear.
     */
    public void create(java.lang.Object obj)throws OperacionInvalidaException;

    /**
     * Modifica un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere modificar.
     */
    public void update(java.lang.Object obj);

    /**
     * Elimina un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    public void delete(java.lang.Object obj)throws OperacionInvalidaException;

    /**
     * Devuelve una lista con de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase.
     */
    public java.util.List findAll(java.lang.Class c);

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidad.
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    public java.lang.Object findById(java.lang.Class c, java.lang.Object id);
    
    /**
     * Retorna una lista de objetos buscada por named querys
     * @param queryName nombre del namedquery
     * @param params parametros del named query
     * @return List<Object> Resultado de la consulta.
     */
    public List<Object> findByNamedQuery(final String queryName, final Map<String, Object> params);
    
    /**
     * Retorna una lista de objetos buscada por named querys retornando un rango de registros
     * @param queryName nombre del namedquery
     * @param params parametros del named query
     * @param firstResult numero de registro desde donde se retornanar los valores
     * @param maxResults numero de registro
     * @return List<Object> Resultado de la consulta.
     */
    public List<Object> findNamedQueryRange(final String queryName, final Map<String, Object> params,final int firstResult, final int maxResults);
    
}
