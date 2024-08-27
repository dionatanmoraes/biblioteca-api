package com.biblioteca.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Emprestimo;
import com.biblioteca.service.EmprestimoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<Emprestimo> createEmprestimo(@RequestBody Emprestimo emprestimo) {
        Emprestimo novoEmprestimo = emprestimoService.criarEmprestimo(emprestimo);
        return ResponseEntity.ok(novoEmprestimo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> updateEmprestimo(@PathVariable Integer id, @RequestBody Emprestimo emprestimo) {
        return ResponseEntity.ok(emprestimoService.atualizarEmprestimo(id, emprestimo));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Emprestimo>> getEmprestimoPorUsuario(@PathVariable Integer usuarioId) {
        return ResponseEntity.ok(emprestimoService.listarEmprestimosPorUsuario(usuarioId));
    }
}
