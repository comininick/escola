package com.nicollejer.escola.dto;

import com.nicollejer.escola.modelo.Materia;

public class MateriaDto {

   private String nome;

   private ProfessorDto professor;

   @Deprecated
   public MateriaDto() {
   }

   public MateriaDto(String nome, ProfessorDto professor) {
      this.nome = nome;
      this.professor = professor;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public ProfessorDto getProfessor() {
      return professor;
   }

   public void setProfessor(ProfessorDto professor) {
      this.professor = professor;
   }

   @Override
   public String toString() {
    return "MateriaDto [nome=" + nome + ", professor=" + professor + "]";
   }

   public Materia novaMateria() {
      return new Materia(nome);
   }
}
