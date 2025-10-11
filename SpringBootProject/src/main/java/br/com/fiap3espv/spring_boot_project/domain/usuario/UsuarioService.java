package br.com.fiap3espv.spring_boot_project.domain.usuario;

import br.com.fiap3espv.spring_boot_project.controller.UsuarioController;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario criarUsuario(DadosCadastroUsuario dados){
        if(repository.existsUsuarioByLogin(dados.login())){
            throw new IllegalArgumentException("Login já existente!");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setLogin(dados.login());
        novoUsuario.setSenha(passwordEncoder.encode(dados.senha()));
        novoUsuario.setRole(dados.role() != null ? dados.role() : Role.USER);

        return repository.save(novoUsuario);
    }

    public void alterarSenha(String login, DadosAlterarSenha dados) {
        Usuario usuario = (Usuario) repository.findByLogin(login);

        if(usuario == null){
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        if (!passwordEncoder.matches(dados.senhaAtual(), usuario.getPassword())) {
            throw new IllegalArgumentException("Senha atual incorreta");
        }

        usuario.setSenha(passwordEncoder.encode(dados.novaSenha()));
        repository.save(usuario);
    }

    public List<UsuarioResponseDTO> listarUsuarios(){
        List<Usuario> usuarios = repository.findAll();

        return usuarios.stream()
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getLogin(),
                        usuario.getPassword(),
                        usuario.getRole().toString()
                ))
                .collect(Collectors.toList()).reversed();
    }

    public void deletarUsuario(Long id){
        repository.deleteById(id);
    }

}
