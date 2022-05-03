/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mouralacerda.superherois.dao;

import br.edu.mouralacerda.superherois.modelo.Franquia;
import java.util.List;

/**
 *
 * @author jpcasati
 */
public interface FranquiaDAO {
    
    public boolean salvar(Franquia f);
    
    public List<Franquia> listar();
    
    public Franquia selecionar(Integer id);
    
}
