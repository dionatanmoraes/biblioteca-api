package com.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {

    List<Emprestimo> findByUsuarioId(Integer usuarioId);
}
