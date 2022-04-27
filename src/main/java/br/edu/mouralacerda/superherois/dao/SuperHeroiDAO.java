/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mouralacerda.superherois.dao;

import br.edu.mouralacerda.superherois.modelo.SuperHeroi;
import java.util.List;

/**
 *
 * @author jpcasati
 */
public interface SuperHeroiDAO {
    
    public boolean salvar(SuperHeroi sh);
    
    public List<SuperHeroi> listar();
    
    public boolean remover(Integer id);
    
}
