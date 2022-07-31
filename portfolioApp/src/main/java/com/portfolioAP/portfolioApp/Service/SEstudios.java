/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAP.portfolioApp.Service;

import com.portfolioAP.portfolioApp.Entity.Estudios;
import com.portfolioAP.portfolioApp.Repository.REstudios;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */

@Service
@Transactional
public class SEstudios {
    @Autowired
    REstudios rEstudios;
    
    public List<Estudios> list() {
        return rEstudios.findAll();
    }
    
    public Optional<Estudios> getOne(int id) {
        return rEstudios.findById(id);
    }
    
    public Optional<Estudios> getByNombreS(String nombreS){
        return rEstudios.findByNombreS(nombreS);
    }
    
    public void save(Estudios est) {
        rEstudios.save(est);
    }
    
    public void delete(int id) {
        rEstudios.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rEstudios.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreS) {
        return rEstudios.existsByNombreS(nombreS);
    }
}
