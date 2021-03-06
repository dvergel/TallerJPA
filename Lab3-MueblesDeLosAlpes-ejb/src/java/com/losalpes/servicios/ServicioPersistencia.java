/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioPersistenciaMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.servicios;

import com.losalpes.dto.MuebleVendido;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Implementación de los servicios de persistencia
 */
@Stateless
public class ServicioPersistencia implements IServicioPersistenciaMockLocal,IServicioPersistenciaMockRemote, Serializable {

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    @PersistenceContext(unitName = "Lab3-MueblesDeLosAlpes-ejbPU")
    private EntityManager em;
    
    /**
     * La entidad encargada de persistir en la base de datos
     */
    //TODO

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase. Inicializa los atributos.
     */
    public ServicioPersistencia()
    {
        
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    
    /**
     * Permite crear un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere crear.
     */
    @Override
    public void create(Object obj) throws OperacionInvalidaException
    {
       getEntityManager().persist(obj);
    }

    /**
     * Permite modificar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere modificar.
     */
    @Override
    public void update(Object obj)
    {
       getEntityManager().merge(obj);
    }

    /**
     * Permite borrar un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    @Override
    public void delete(Object obj) throws OperacionInvalidaException
    {
       getEntityManager().remove(getEntityManager().merge(obj));

    }

    /**
     * Retorna la lista de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase dada que se encuentran en el sistema.
     */
    @Override
    public List findAll(Class c)
    {
        final CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(c));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidadi.
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    @Override
    public Object findById(Class c, Object id)
    {
        return getEntityManager().find(c, id);
    }
    
    @Override
    public List<Object> findByNamedQuery(final String queryName, final Map<String, Object> params) {
        final Query q = getEntityManager().createNamedQuery(queryName);

        final Set<Entry<String, Object>> paramList = params.entrySet();

        for (Entry<String, Object> entry : paramList) {
            q.setParameter(entry.getKey(), entry.getValue());
        }

        return q.getResultList();

    }
    
    @Override
    public List<Object> findNamedQueryRange(final String queryName, final Map<String, Object> params,final int firstResult, final int maxResults) {
        final Query q = getEntityManager().createNamedQuery(queryName);

        final Set<Entry<String, Object>> paramList = params.entrySet();

        for (Entry<String, Object> entry : paramList) {
            q.setParameter(entry.getKey(), entry.getValue());
        }
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }
    
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<MuebleVendido> getMueblesMasVendidos() {
        StringBuilder sb = new StringBuilder();
        sb.append("select distinct(v.producto), COUNT(v.comprador), m.nombre ");
        sb.append("from registro_venta v join mueble m on m.id = v.producto ");
        sb.append("group by v.producto , m.nombre order by count(v.comprador) desc");
        Query query = em.createNativeQuery(sb.toString());
        List<Object[]> result = query.setMaxResults(3).getResultList();
        List<MuebleVendido> muebles = new ArrayList<>();
        for (Object[] o: result) {
            muebles.add(new MuebleVendido((int)o[0], (long)o[1], (String)o[2]));
        }
        return muebles;
    }
}
