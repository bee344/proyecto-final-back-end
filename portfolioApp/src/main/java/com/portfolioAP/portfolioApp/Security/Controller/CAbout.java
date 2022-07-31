/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAP.portfolioApp.Security.Controller;

import com.portfolioAP.portfolioApp.Dto.DtoAbout;
import com.portfolioAP.portfolioApp.Entity.About;
import com.portfolioAP.portfolioApp.Service.SAbout;
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
@RequestMapping("/about")
@CrossOrigin(origins = "http://localhost:4200/")
public class CAbout {
    @Autowired
    SAbout sAbout;
    
    @GetMapping("/lista")
    public ResponseEntity<List<About>> list() {
        List<About> list = sAbout.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoAbout dtoabout) {
        if(StringUtils.isBlank(dtoabout.getProfesion()))
            return new ResponseEntity(new Mensaje("El nombre de la profesión es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoabout.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        if(sAbout.existsByProfesion((dtoabout.getProfesion())))
            return new ResponseEntity(new Mensaje("Esa profesión ya existe"), HttpStatus.BAD_REQUEST);
        
        About about = new About(dtoabout.getProfesion(), dtoabout.getDescripcion());
        sAbout.save(about);
        
        return new ResponseEntity(new Mensaje("Datos agregados"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<About> getById(@PathVariable("id") int id){

        if(!sAbout.existsById(id))

            return new ResponseEntity(new Mensaje("Inexistente"), HttpStatus.NOT_FOUND);

        About about = sAbout.getOne(id).get();

        return new ResponseEntity(about, HttpStatus.OK);

    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoAbout dtoabout) {
        if(!sAbout.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(sAbout.existsByProfesion((dtoabout.getProfesion())) && sAbout.getByProfesion(dtoabout.getProfesion()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa profesión ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoabout.getProfesion()))
            return new ResponseEntity(new Mensaje("El nombre de la profesión es obligatorio"), HttpStatus.BAD_REQUEST);
        
        About about = sAbout.getOne(id).get();
        about.setProfesion(dtoabout.getProfesion());
        about.setDescripcion(dtoabout.getDescripcion());
        
        sAbout.save(about);
        return new ResponseEntity(new Mensaje("Descripción actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!sAbout.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sAbout.delete(id);
        
        return new ResponseEntity(new Mensaje("Estudios eliminados"), HttpStatus.OK);
    }
}
