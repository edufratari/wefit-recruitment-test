package br.com.wefit.recruitment.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaFisicaDTO extends PessoaRequestDTO {

    private String cpf;

}