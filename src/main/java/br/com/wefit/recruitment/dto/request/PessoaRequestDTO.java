package br.com.wefit.recruitment.dto.request;

import br.com.wefit.recruitment.enums.Perfil;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class PessoaRequestDTO {

    @NotNull
    private Perfil perfil;

    @NotBlank
    private String tipoPessoa;

    @CNPJ
    private String cnpj;

    @CPF
    private String cpf;

    @CPF
    private String cpfResponsavel;

    @NotBlank
    @Size(min = 3, max = 80)
    private String nome;

    @NotBlank
    private String celular;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Telefone inválido")
    private String telefone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Email
    private String confirmacaoEmail;

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

    @AssertTrue
    private boolean termos;

}