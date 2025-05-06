package br.com.wefit.recruitment.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Endereco {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String bairro;
    private String estado;

}
