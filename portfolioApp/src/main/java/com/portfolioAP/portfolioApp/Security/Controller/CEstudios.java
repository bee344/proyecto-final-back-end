/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAP.portfolioApp.Security.Controller;

import com.portfolioAP.portfolioApp.Dto.DtoEstudios;
import com.portfolioAP.portfolioApp.Entity.Estudios;
import com.portfolioAP.portfolioApp.Service.SEstudios;
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
@RequestMapping("/estudios")
@CrossOrigin(origins = "http://localhost:4200")
public class CEstudios {
    @Autowired
    SEstudios sEstudios;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudios>> list() {
        List<Estudios> list = sEstudios.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoEstudios dtoestu) {
        if(StringUtils.isBlank(dtoestu.getNombreS()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoestu.getFechaS()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        if(sEstudios.existsByNombreS((dtoestu.getNombreS())))
            return new ResponseEntity(new Mensaje("Esos estudios ya existen"), HttpStatus.BAD_REQUEST);
        
        Estudios estudios = new Estudios(dtoestu.getNombreS(), dtoestu.getAlmaMaterS(), dtoestu.getFechaS(), dtoestu.getDescripcionS());
        sEstudios.save(estudios);
        
        return new ResponseEntity(new Mensaje("Estudios agregados"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")

    public ResponseEntity<Estudios> getById(@PathVariable("id") int id){

        if(!sEstudios.existsById(id))

            return new ResponseEntity(new Mensaje("Inexistente"), HttpStatus.NOT_FOUND);

        Estudios estudios = sEstudios.getOne(id).get();

        return new ResponseEntity(estudios, HttpStatus.OK);

    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEstudios dtoestu) {
        if(!sEstudios.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(sEstudios.existsByNombreS((dtoestu.getNombreS())) && sEstudios.getByNombreS(dtoestu.getNombreS()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esos estudios ya existen"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoestu.getNombreS()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoestu.getAlmaMaterS()))
            return new ResponseEntity(new Mensaje("El nombre de la institucion es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoestu.getFechaS()))
            return new ResponseEntity(new Mensaje("La fecha de graduacion es obligatoria, si no se ha graduado ponga 'En curso'"), HttpStatus.BAD_REQUEST);
        
        Estudios estudios = sEstudios.getOne(id).get();
        estudios.setNombreS(dtoestu.getNombreS());
        estudios.setAlmaMaterS(dtoestu.getAlmaMaterS());
        estudios.setFechaS(dtoestu.getFechaS());
        estudios.setDescripcionS(dtoestu.getDescripcionS());
        
        sEstudios.save(estudios);
        return new ResponseEntity(new Mensaje("Estudios actualizados"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!sEstudios.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sEstudios.delete(id);
        
        return new ResponseEntity(new Mensaje("Estudios eliminados"), HttpStatus.OK);
    }
}
