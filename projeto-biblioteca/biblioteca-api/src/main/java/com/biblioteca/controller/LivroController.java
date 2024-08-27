package com.biblioteca.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Livro;
import com.biblioteca.service.LivroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {
    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> creatLivro(@RequestBody Livro livro) {
        return ResponseEntity.ok(livroService.criaLivro(livro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivro(@PathVariable Integer id) {
        return ResponseEntity.ok(livroService.obterLivro(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Integer id, @RequestBody Livro livro) {
        return ResponseEntity.ok(livroService.alteraLivro(id, livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Integer id){
        livroService.excluirLivro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Livro>> getLivroCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(livroService.obterLivroCategoria(categoria));
    }
}
