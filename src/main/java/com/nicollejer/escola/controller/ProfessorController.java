package com.nicollejer.escola.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicollejer.escola.dto.ProfessorDto;
import com.nicollejer.escola.modelo.Professor;

@RestController //transforma a nossa classe em um controller antigamente chamado de bean
@RequestMapping(value = "/professor") // mapeando a url, navegador chama pelo vetor
public class ProfessorController {

    @GetMapping(value = "/imprimir") //mapeando do metodo imprimir. usando o verbo get -> pegar ou buscar
    public void imprimir(){//void -> não retorna nada
        System.out.println("chamou o metodo imprimir");
    }

    @GetMapping(value = "/ola")
    public String ola(){  //addicionado retorno como String -> tipo: texto //nao quer dizer html
        return "<h1>Nicolle linda</h1>"; //return: devolve a resposta pra quem chamou// nao funciona obv com "alert"
    }

    @GetMapping( value = "/insert")
    public String insert(ProfessorDto professorDto){

        Professor professor = professorDto.novoProfessor();
        System.out.println(professor.toString());


 
    
        return"<h1>tentando salvar o professor dos alunos</h1>";
    }
}
























