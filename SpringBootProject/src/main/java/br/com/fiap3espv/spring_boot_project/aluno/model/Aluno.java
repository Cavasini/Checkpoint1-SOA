package br.com.fiap3espv.spring_boot_project.aluno.model;

import br.com.fiap3espv.spring_boot_project.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "alunos")
@Entity(name = "alunos")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;
    String email;
    String cpf;
    LocalDate data_nascimento;
    String telefone;

    @Embedded
    Endereco endereco;

    public Aluno(AlunoRequestDTO alunoRequestDTO){
        this.nome = alunoRequestDTO.nome();
        this.email = alunoRequestDTO.email();
        this.cpf = alunoRequestDTO.cpf();
        this.data_nascimento = alunoRequestDTO.data_nascimento();
        this.telefone = alunoRequestDTO.telefone();
        this.endereco = new Endereco(alunoRequestDTO.endereco());
    }

}
