/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaDeNegocio;

import database.Tbanimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sergio13v
 */
@Stateless
public class TbanimalFacade extends AbstractFacade<Tbanimal> {

    @PersistenceContext(unitName = "AnimalesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbanimalFacade() {
        super(Tbanimal.class);
    }
    
    public List<Tbanimal> findAllByIdTipo(int idTipo) {
        List<Tbanimal>listaAnimales = em.createQuery("select A from Tbanimal A where A.idTipo.id=?1").setParameter(1, idTipo).getResultList();
        return listaAnimales;
    }
    
}
