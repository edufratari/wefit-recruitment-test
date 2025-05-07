package br.com.wefit.recruitment.dto.response;

import br.com.wefit.recruitment.enums.Perfil;
import lombok.Data;

@Data
public class PessoaResponseDTO {
    private Long id;
    private String tipoPessoa;
    private String nome;
    private String cpf;
    private String cnpj;
    private String email;
    private Perfil perfil;
}