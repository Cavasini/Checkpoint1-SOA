package br.com.fiap3espv.spring_boot_project.controller;

import br.com.fiap3espv.spring_boot_project.domain.usuario.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<Usuario> registrar(@RequestBody DadosCadastroUsuario dados){
        usuarioService.criarUsuario(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update")
    public ResponseEntity<Usuario> Atualizar(@RequestBody DadosCadastroUsuario dados){
        usuarioService.criarUsuario(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/me/senha")
    public ResponseEntity<?> alterarSenha(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody @Valid DadosAlterarSenha dados) {
        usuarioService.alterarSenha(userDetails.getUsername(), dados);
        return ResponseEntity.noContent().build();
    }

}
