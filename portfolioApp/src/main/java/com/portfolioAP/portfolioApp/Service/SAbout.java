/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAP.portfolioApp.Service;

import com.portfolioAP.portfolioApp.Entity.About;
import com.portfolioAP.portfolioApp.Repository.RAbout;
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
public class SAbout {
    @Autowired
    RAbout rAbout;
    
    public List<About> list() {
        return rAbout.findAll();
    }
    
    public Optional<About> getOne(int id) {
        return rAbout.findById(id);
    }
    
    public Optional<About> getByProfesion(String profesion){
        return rAbout.findByProfesion(profesion);
    }
    
    public void save(About est) {
        rAbout.save(est);
    }
    
    public void delete(int id) {
        rAbout.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rAbout.existsById(id);
    }
    
    public boolean existsByProfesion(String profesion) {
        return rAbout.existsByProfesion(profesion);
    }
}
