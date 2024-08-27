package com.biblioteca.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emprestimo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    @JsonBackReference
    private Livro livro;

    
    @PastOrPresent
    @Column(name = "data_emprestimo")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataEmprestimo;

    
    @Column(name = "data_devolucao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataDevolucao;

    
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDENTE,
        DEVOLVIDO
    }

}
