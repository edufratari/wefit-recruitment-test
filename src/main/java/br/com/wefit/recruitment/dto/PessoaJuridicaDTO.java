package br.com.wefit.recruitment.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaJuridicaDTO extends PessoaRequestDTO {

    private String cnpj;
    private String cpfResponsavel;

}