package com.nicollejer.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nicollejer.escola.modelo.Professor;

public interface professorRepository extends JpaRepository <Professor, Long>{
    @Query (value = "select * from professor where nome like ?", nativeQuery = true)
    public void findByIdNome(String nome);
}
