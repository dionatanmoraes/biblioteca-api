package com.biblioteca.service;

import org.springframework.stereotype.Service;

import com.biblioteca.model.Usuario;
import com.biblioteca.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getEmail() == null
                || usuario.getDataCadastro() == null || usuario.getTelefone() == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario obterUsuario(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario atualizarUsuario(Integer id, Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
