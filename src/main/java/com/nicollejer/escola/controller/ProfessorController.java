package com.nicollejer.escola.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
























