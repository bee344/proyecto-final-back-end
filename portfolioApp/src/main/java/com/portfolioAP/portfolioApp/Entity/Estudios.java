/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAP.portfolioApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hp
 */
@Getter @Setter
@Entity
public class Estudios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreS;
    private String almaMaterS;
    private String fechaS;
    private String descripcionS;

    public Estudios() {
    }

    public Estudios(String nombreS, String almaMaterS, String fechaS, String descripcionS) {
        this.nombreS = nombreS;
        this.almaMaterS = almaMaterS;
        this.fechaS = fechaS;
        this.descripcionS = descripcionS;
    }
    
    
}
