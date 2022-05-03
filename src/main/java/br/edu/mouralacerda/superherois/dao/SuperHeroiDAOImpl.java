/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mouralacerda.superherois.dao;

import br.edu.mouralacerda.superherois.modelo.Franquia;
import br.edu.mouralacerda.superherois.modelo.SuperHeroi;
import br.edu.mouralacerda.superherois.persistencia.EMFSuperHerois;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author jpcasati
 */
public class SuperHeroiDAOImpl implements SuperHeroiDAO {
    
    @Override
    public boolean salvar(SuperHeroi sh) {
        
        EntityManager em = EMFSuperHerois.getInstance().createEntityManager();
        boolean ret = false;
        
        try {
            em.getTransaction().begin();
            em.persist(sh);
            em.getTransaction().commit();
            ret = true;
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
        }
        em.close();
        return ret;
    }

    @Override
    public List<SuperHeroi> listar() {
        
        EntityManager em = EMFSuperHerois.getInstance().createEntityManager();
        
        List<SuperHeroi> superHerois = em.createQuery("FROM super_heroi h").getResultList();
        
        em.close();
        
        return superHerois;
    }
    
    @Override
    public List<SuperHeroi> listar(Franquia f) {
        
        EntityManager em = EMFSuperHerois.getInstance().createEntityManager();
        
        List<SuperHeroi> superHerois;
        
        if(f != null) {
            superHerois = em.createQuery("FROM super_heroi h WHERE h.franquia = :fr")
                    .setParameter("fr", f)
                    .getResultList();
        } else {
            superHerois = em.createQuery("FROM super_heroi h WHERE h.franquia IS NULL")
                    .getResultList();
        }
        em.close();
        
        return superHerois;
    }

    @Override
    public boolean remover(Integer id) {
        
        EntityManager em = EMFSuperHerois.getInstance().createEntityManager();
        boolean ret = false;
        
        SuperHeroi sh = new SuperHeroi();
        sh.setId(id);
        
        try {
            em.getTransaction().begin();
            sh = em.merge(sh);
            em.remove(sh);
            em.getTransaction().commit();
            ret = true;
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
        }
        em.close();
        return ret;
        
    }
    
}
