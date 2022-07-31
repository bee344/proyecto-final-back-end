/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAP.portfolioApp.Security.Controller;

import com.portfolioAP.portfolioApp.Dto.DtoSkill;
import com.portfolioAP.portfolioApp.Entity.Skill;
import com.portfolioAP.portfolioApp.Service.SSkill;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hp
 */
@Controller
@RequestMapping("/skills")
@CrossOrigin(origins = "https://hosting-angular-a7dac.web.app")
public class CSkill {
    @Autowired
    SSkill sSkill;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoSkill dtoskill) {
        if(StringUtils.isBlank(dtoskill.getNombreSk()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sSkill.existsByNombreSk((dtoskill.getNombreSk())))
            return new ResponseEntity(new Mensaje("Ya ha incluido esa habilidad"), HttpStatus.BAD_REQUEST);
        
        Skill skill = new Skill(dtoskill.getNombreSk(), dtoskill.getProgresoSk());
        sSkill.save(skill);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")

    public ResponseEntity<Skill> getById(@PathVariable("id") int id){

        if(!sSkill.existsById(id))

            return new ResponseEntity(new Mensaje("Inexistente"), HttpStatus.NOT_FOUND);

        Skill skill = sSkill.getOne(id).get();

        return new ResponseEntity(skill, HttpStatus.OK);

    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoskill) {
        if(!sSkill.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(sSkill.existsByNombreSk((dtoskill.getNombreSk())) && sSkill.getByNombreSk(dtoskill.getNombreSk()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ya ha incluido esa habilidad"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoskill.getNombreSk()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(dtoskill.getProgresoSk() == null)
            return new ResponseEntity(new Mensaje("El nivel de progreso debe ser incluido"), HttpStatus.BAD_REQUEST);
        
        Skill skill = sSkill.getOne(id).get();
        skill.setNombreSk(dtoskill.getNombreSk());
        skill.setProgresoSk(dtoskill.getProgresoSk());
        
        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Habilidades actualizadas"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!sSkill.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sSkill.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
}
