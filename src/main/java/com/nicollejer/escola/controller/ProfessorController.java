package com.nicollejer.escola.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nicollejer.escola.dto.ProfessorDto;
import com.nicollejer.escola.modelo.Professor;
import com.nicollejer.escola.repository.professorRepository;

@RestController //transforma a nossa classe em um controller antigamente chamado de bean
@RequestMapping(value = "/professor") // mapeando a url, navegador chama pelo vetor
public class ProfessorController {

    @Autowired
    private professorRepository professorRepository;    

    @GetMapping(value = "/imprimir") //mapeando do metodo imprimir. usando o verbo get -> pegar ou buscar
    public void imprimir(){//void -> não retorna nada
        System.out.println("chamou o metodo imprimir");
    }

    @GetMapping(value = "/ola")
    public String ola(){  //addicionado retorno como String -> tipo: texto //nao quer dizer html
        return "<h1>Nicolle linda</h1>"; //return: devolve a resposta pra quem chamou// nao funciona obv com "alert"
    }

    @GetMapping( value = "/listaprofessor")
    public List<Professor> findAll(){
        return professorRepository.findAll();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

     @GetMapping( value = "/{id}")
    public ResponseEntity<Professor> ProfessorDoBanco (@PathVariable Long id){
        Optional<Professor> ProfessorDoBanco = professorRepository.findById(id);

          return ResponseEntity.ok(ProfessorDoBanco);
    } 

    @GetMapping( value = "/consultaPorNome")
    public ResponseEntity<Professor> buscarprofessorpornome (@PathVariable String nome){
        Professor buscarprofessorpornome = professorRepository.findByIdNome (nome);

          return ResponseEntity.ok(buscarprofessorpornome.get());
    } 
    
    @PostMapping( value = "/insert")
    public ResponseEntity<?> insert(@RequestBody ProfessorDto professorDto){

        Professor professor = professorDto.novoProfessor();

        professorRepository.save(professor);

        System.out.println(professor.toString());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                                            .path("/id")
                                            .buildAndExpand(professor.getId())
                                            .toUri();

        return ResponseEntity.created(uri).body(professor);        
    }

}























