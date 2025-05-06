package br.com.wefit.recruitment.dto;

import br.com.wefit.recruitment.enums.TipoPerfil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
public abstract class PessoaRequestDTO {

    @NotBlank
    private String tipoPessoa;

    @NotNull
    private TipoPerfil perfil;

    @NotBlank
    @Size(min = 3, max = 80)
    private String nome;

    @NotBlank
    private String celular;

    @NotBlank
    private String telefone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Email
    private String confirmacaoEmail;

    @Valid
    @NotNull
    private EnderecoDTO endereco;

    @AssertTrue
    private boolean aceitouTermos;

    @CPF
    private String cpf;

    @CNPJ
    private String cnpj;

    @CPF
    private String cpfResponsavel;
}