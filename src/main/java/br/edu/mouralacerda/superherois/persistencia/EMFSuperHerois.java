/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mouralacerda.superherois.persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jpcasati
 */
public class EMFSuperHerois {
    
    private static EntityManagerFactory INSTANCE;
    
    private EMFSuperHerois() {
         
    }
    
    public static EntityManagerFactory getInstance() {
        
        String pu = "superPU";
        
        if(INSTANCE == null)
            INSTANCE = Persistence.createEntityManagerFactory(pu);
        else if(!INSTANCE.isOpen())
            INSTANCE = Persistence.createEntityManagerFactory(pu);
        return INSTANCE;
        
    }
    
}
