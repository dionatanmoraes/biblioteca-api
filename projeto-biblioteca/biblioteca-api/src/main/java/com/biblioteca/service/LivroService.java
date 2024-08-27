package com.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public Livro criaLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro obterLivro(Integer id) {
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public Livro alteraLivro(Integer id, Livro livro) {
        livro.setId(id);
        return livroRepository.save(livro);
    }

    public void excluirLivro(Integer id) {
        livroRepository.deleteById(id);
    }

    public List<Livro> obterLivroCategoria(String categoria) {
        return livroRepository.findByCategoria(categoria);
    }
}
