package br.com.wefit.recruitment.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("FISICA")
@Data
public class PessoaFisica extends Pessoa {

    @Column(unique = true)
    private String cpf;

}
