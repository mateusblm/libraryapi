package io.github.mateusbm.libraryapi.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="livro", schema = "public")
@Data
public class Livro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID) // Id gerado automaticamente
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING) // Enumerado por string no enum GeneroLivro
    @Column(name = "genero", length = 30, nullable = false)
    private GeneroLivro genero;

    @Column(name = "preco", precision = 18, scale = 2) // Numero de 18 posições, aonde duas são decimais
    private Double preco;

    @ManyToOne // Muitos livros para um autor. Many referencia a entidade atual, e one à mapeada(O autor pode ter um ou mais livros)
    @JoinColumn(name = "id_autor") // Referencia a coluna ao id_autor da coluna Autor
    private Autor autor;
}
