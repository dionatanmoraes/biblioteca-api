package com.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.model.Emprestimo;
import com.biblioteca.model.Livro;
import com.biblioteca.model.Usuario;
import com.biblioteca.repository.EmprestimoRepository;
import com.biblioteca.repository.LivroRepository;
import com.biblioteca.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public Emprestimo criarEmprestimo(Emprestimo emprestimo) {
        if (emprestimo.getUsuario() == null || emprestimo.getLivro() == null) {
            throw new RuntimeException("Usuario e livro são obrigatório");
        }

        Usuario usuario = usuarioRepository.findById(emprestimo.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Livro livro = livroRepository.findById(emprestimo.getLivro().getId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);

        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo atualizarEmprestimo(Integer id, Emprestimo emprestimoAtualizado) {
        Emprestimo emprestimoExistente = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        emprestimoExistente.setStatus(emprestimoAtualizado.getStatus());
        emprestimoExistente.setDataDevolucao(emprestimoAtualizado.getDataDevolucao());

        return emprestimoRepository.save(emprestimoExistente);
    }

    public List<Emprestimo> listarEmprestimosPorUsuario(Integer UsuarioId) {
        return emprestimoRepository.findByUsuarioId(UsuarioId);
    }
}
