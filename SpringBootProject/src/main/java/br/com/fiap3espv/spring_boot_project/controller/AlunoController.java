package br.com.fiap3espv.spring_boot_project.controller;

import br.com.fiap3espv.spring_boot_project.aluno.model.Aluno;
import br.com.fiap3espv.spring_boot_project.aluno.model.AlunoRequestDTO;
import br.com.fiap3espv.spring_boot_project.aluno.model.AlunoResponseDTO;
import br.com.fiap3espv.spring_boot_project.aluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;


    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listarAlunos(){
        List<AlunoResponseDTO> listaAlunos = alunoRepository.findAll().stream().map(AlunoResponseDTO::new).toList();
        return ResponseEntity.ok(listaAlunos);
    }

    @PostMapping
    public ResponseEntity cadastrarAluno(@RequestBody AlunoRequestDTO request){
        alunoRepository.save(new Aluno(request));
        return ResponseEntity.ok().build();
    }
}
