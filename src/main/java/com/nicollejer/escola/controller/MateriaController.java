package com.nicollejer.escola.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicollejer.escola.dto.MateriaDto;
import com.nicollejer.escola.modelo.Materia;
import com.nicollejer.escola.modelo.Professor;
import com.nicollejer.escola.repository.MateriaRepository;
import com.nicollejer.escola.repository.ProfessorRepository;

@RestController
@RequestMapping(value = "/materia")
public class MateriaController { 

    @Autowired
    private MateriaRepository materiaRepository;
    private ProfessorRepository professorRepository;

     
    @GetMapping(value = "/listaMateria")
    public List<Materia> findAll(){
        return materiaRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Materia> buscarMateriaPorId(@PathVariable Long id){
        Optional<Materia> materiaBanco = materiaRepository.findById(id);
        return ResponseEntity.ok(materiaBanco.get());
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<?> insert(@RequestBody MateriaDto materiaDto){

        //coloca a matéria no obj     //busca a materia no banco
        Materia materia =           materiaRepository.buscarMateria(materiaDto.getNome());     

        Professor professor =       professorRepository.findByNome(materiaDto.getProfessor().getNome());

        //se não achou no banco a matéria o objeto esta nulo
        if (professor == null) {

            Materia novaMateria = new Materia(materiaDto.getNome());

           Professor novoProfessor = new Professor(materiaDto.getProfessor().getNome(), materiaDto.getProfessor().getCpf());
            professorRepository.save(novoProfessor);
 
        } else {
             System.out.println("já existe o professor");
        }


        //se não achou no banco a matéria o objeto esta nulo
        if (materia == null) {

           Materia novaMateria = new Materia(materiaDto.getNome());
           materiaRepository.save(novaMateria);

        } else {
            System.out.println("já existe a materia");
        }


    return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> atualizar(@PathVariable Long id, @RequestBody Materia materiaDto ){
       Materia materia = materiaRepository.findById(id).get();

       materia.setNome(materiaDto.getNome());
       materia.setProfessor(materiaDto.getProfessor());

       materiaRepository.save(materia);
       return ResponseEntity.ok(materia);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        materiaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}



