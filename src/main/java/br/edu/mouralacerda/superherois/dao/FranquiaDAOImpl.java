/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mouralacerda.superherois.dao;

import br.edu.mouralacerda.superherois.modelo.Franquia;
import br.edu.mouralacerda.superherois.persistencia.EMFSuperHerois;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author jpcasati
 */
public class FranquiaDAOImpl implements FranquiaDAO {

    @Override
    public boolean salvar(Franquia f) {
        EntityManager em = EMFSuperHerois.getInstance().createEntityManager();
        boolean ret = false;
        
        try {
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            ret = true;
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
        }
        em.close();
        return ret;
    }

    @Override
    public List<Franquia> listar() {
        EntityManager em = EMFSuperHerois.getInstance().createEntityManager();
        
        List<Franquia> franquias = em.createQuery("FROM franquia f").getResultList();
        
        em.close();
        
        return franquias;
    }

    @Override
    public Franquia selecionar(Integer id) {
        EntityManager em = EMFSuperHerois.getInstance().createEntityManager();
        
        Franquia franquia = em.find(Franquia.class, id);
        
        return franquia;
    }
    
}
