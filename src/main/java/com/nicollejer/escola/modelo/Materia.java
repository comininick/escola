package com.nicollejer.escola.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Materia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    @ManyToOne
    @JoinColumn(name = "fk_professor")
    private Professor professor;

    @Deprecated
    public Materia() {
    }

    public Materia(String nome) {
        this.nome = nome;
    }
    
    public Materia(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    @Override
    public String toString() {
        return "Materia [id=" + id + ", nome=" + nome + ", professor=" + professor + "]";
    }

    

}
