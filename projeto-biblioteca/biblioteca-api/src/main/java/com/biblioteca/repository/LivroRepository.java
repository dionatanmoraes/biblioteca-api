package com.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    List<Livro> findByCategoria(String categoria);
}
