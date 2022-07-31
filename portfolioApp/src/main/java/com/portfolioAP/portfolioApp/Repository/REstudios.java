/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioAP.portfolioApp.Repository;

import com.portfolioAP.portfolioApp.Entity.Estudios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hp
 */
@Repository
public interface REstudios extends JpaRepository<Estudios, Integer> {
    public Optional<Estudios> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}
