package br.com.wefit.recruitment.model;

import br.com.wefit.recruitment.enums.TipoPerfil;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pessoa", discriminatorType = DiscriminatorType.STRING)
@Data
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPerfil perfil;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String celular;

    private String telefone;

    @Column(nullable = false, unique = true)
    private String email;

    @Embedded
    private Endereco endereco;

    @Column(nullable = false)
    private boolean termos;

}
