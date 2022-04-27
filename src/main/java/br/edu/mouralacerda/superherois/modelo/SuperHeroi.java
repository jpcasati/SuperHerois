/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mouralacerda.superherois.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jpcasati
 */

@Entity(name = "super_heroi")
public class SuperHeroi implements Serializable {
    
    @Id
    private Integer id;
    
    @Column(name = "nome_super")
    private String nomeSuper;
    
    @Column(name = "nome_real")
    private String nomeReal;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeSuper() {
        return nomeSuper;
    }

    public void setNomeSuper(String nomeSuper) {
        this.nomeSuper = nomeSuper;
    }

    public String getNomeReal() {
        return nomeReal;
    }

    public void setNomeReal(String nomeReal) {
        this.nomeReal = nomeReal;
    }

    @Override
    public String toString() {
        return id + " - " + nomeSuper + " - " + nomeReal;
    }
    
}
