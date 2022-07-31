/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAP.portfolioApp.Service;

import com.portfolioAP.portfolioApp.Entity.Skill;
import com.portfolioAP.portfolioApp.Repository.RSkill;
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
public class SSkill {
    @Autowired
    RSkill rSkill;
    
    public List<Skill> list() {
        return rSkill.findAll();
    }
    
    public Optional<Skill> getOne(int id) {
        return rSkill.findById(id);
    }
    
    public Optional<Skill> getByNombreSk(String nombreSk){
        return rSkill.findByNombreSk(nombreSk);
    }
    
    public void save(Skill sk) {
        rSkill.save(sk);
    }
    
    public void delete(int id) {
        rSkill.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return rSkill.existsById(id);
    }
    
    public boolean existsByNombreSk(String nombreSk) {
        return rSkill.existsByNombreSk(nombreSk);
    }
}
