package com.nicollejer.escola.dto;

public class MateriaDto {
   private Long id;
   private String nome;
   public MateriaDto() {
    
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
   @Override
   public String toString() {
    return "MateriaDto [id=" + id + ", nome=" + nome + "]";
   }  
    
}
