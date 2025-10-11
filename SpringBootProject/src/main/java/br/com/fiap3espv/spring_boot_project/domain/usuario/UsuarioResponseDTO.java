package br.com.fiap3espv.spring_boot_project.domain.usuario;

public record UsuarioResponseDTO(Long id, String login, String password, String role) {
}
