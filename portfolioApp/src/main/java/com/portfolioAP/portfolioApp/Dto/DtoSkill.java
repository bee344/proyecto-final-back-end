/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAP.portfolioApp.Dto;


import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author hp
 */
@Getter @Setter
public class DtoSkill {
    @NotBlank
    private String nombreSk;
    @Range(min = 1, max = 100, message= "Debe informar un porcentaje de progreso")
    private Integer progresoSk;
    @NotBlank

    public DtoSkill(String nombreSk, Integer progresoSk) {
        this.nombreSk = nombreSk;
        this.progresoSk = progresoSk;
    }

    public DtoSkill() {
    }
}
