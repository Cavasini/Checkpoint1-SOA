package br.com.fiap3espv.spring_boot_project.aluno.repository;

import br.com.fiap3espv.spring_boot_project.aluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
