package br.com.fiap3espv.spring_boot_project.aluno.model;

import br.com.fiap3espv.spring_boot_project.endereco.DadosEndereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record AlunoResponseDTO(
        String nome,
        String email,
        String cpf,
        LocalDate data_nascimento,
        String telefone) {

    public AlunoResponseDTO(Aluno aluno){
        this(aluno.nome, aluno.email, aluno.cpf, aluno.data_nascimento,aluno.telefone);
    }
}
