package com.nicollejer.escola.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nicollejer.escola.modelo.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

    
} 
