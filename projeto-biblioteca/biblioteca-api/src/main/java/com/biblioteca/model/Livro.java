package com.biblioteca.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "livros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "data_publicacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @Column(name = "categoria")
    private String categoria;

    @OneToMany(mappedBy = "livro")
    @JsonIgnore
    private List<Emprestimo> emprestimos;

}
