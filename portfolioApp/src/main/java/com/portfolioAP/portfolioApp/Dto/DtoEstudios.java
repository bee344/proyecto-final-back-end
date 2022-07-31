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

public class DtoEstudios {
    @NotBlank
    private String nombreS;
    @NotBlank
    private String almaMaterS;
    @NotBlank
    private String fechaS;
    @NotBlank
    private String descripcionS;

    public DtoEstudios() {
    }

    public DtoEstudios(String nombreS, String almaMaterS, String fechaS, String descripcionS) {
        this.nombreS = nombreS;
        this.almaMaterS = almaMaterS;
        this.fechaS = fechaS;
        this.descripcionS = descripcionS;
        
    }
}
