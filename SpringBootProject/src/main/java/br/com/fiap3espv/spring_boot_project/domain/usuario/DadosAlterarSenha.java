package br.com.fiap3espv.spring_boot_project.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosAlterarSenha(
        @NotBlank
        String senhaAtual,

        @Size(min = 6)
        String novaSenha
) {}
