/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAP.portfolioApp.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hp
 */
@Getter @Setter
public class DtoAbout {
    @NotBlank
    private String profesion;
    @NotBlank
    private String descripcion;

    public DtoAbout() {
    }

    public DtoAbout(String profesion, String descripcion) {
        this.profesion = profesion;
        this.descripcion = descripcion;
    }
    
    
}
