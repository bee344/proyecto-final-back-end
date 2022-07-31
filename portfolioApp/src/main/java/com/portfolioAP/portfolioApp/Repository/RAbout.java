/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioAP.portfolioApp.Repository;

import com.portfolioAP.portfolioApp.Entity.About;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hp
 */
    
@Repository
public interface RAbout extends JpaRepository<About, Integer> {
    public Optional<About> findByProfesion(String profesion);
    public boolean existsByProfesion(String profesion);
    
}
