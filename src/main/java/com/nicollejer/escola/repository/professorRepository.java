package com.nicollejer.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicollejer.escola.modelo.Professor;

public interface professorRepository extends JpaRepository <Professor, Long>{
    
}
