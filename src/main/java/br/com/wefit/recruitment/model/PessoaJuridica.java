package br.com.wefit.recruitment.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("JURIDICA")
@Data
public class PessoaJuridica extends Pessoa {

    @Column(unique = true)
    private String cnpj;
    
    @Column(nullable = false)
    private String cpfResponsavel;
    
}