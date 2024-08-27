package com.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Usuario;
import com.biblioteca.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.criarUsuario(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.obterUsuario(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Integer id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
