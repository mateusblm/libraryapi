package io.github.mateusbm.libraryapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="autor", schema = "public")
@Getter
@Setter
public class Autor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID) // Id gerado automaticamente
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false) // Varchar(100), not null
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;

    @OneToMany(mappedBy = "autor" // Dentro da entidade livro como esta mapeado o autor
    ) // Um autor para muitos livros, MappedBy diz que essa entidade não tem essa coluna
    private List<Livro> livros;

    @Deprecated
    public  Autor(){
        // Para uso do framework
    }  // Necessário para buscas no banco de dados via JPA

    public Autor(String nome, LocalDate dataNascimento, String nacionalidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }
}