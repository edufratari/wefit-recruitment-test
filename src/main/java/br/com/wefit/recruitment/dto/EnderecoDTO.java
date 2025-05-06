package br.com.wefit.recruitment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoDTO {

    @NotBlank
    private String cep;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;

    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String bairro;

    @NotBlank
    private String estado;

}