package br.com.fiap3espv.spring_boot_project.aluno.model;

import br.com.fiap3espv.spring_boot_project.endereco.DadosEndereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record AlunoRequestDTO (
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "^\\d{11}$")
        String cpf,

        @NotBlank
        LocalDate data_nascimento,

        @NotBlank
        @Pattern(regexp = "^[1-9]{2}9\\d{8}$")
        String telefone,

        DadosEndereco endereco

){

}
