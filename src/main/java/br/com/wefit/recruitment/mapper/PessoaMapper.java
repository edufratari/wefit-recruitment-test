package br.com.wefit.recruitment.mapper;

import br.com.wefit.recruitment.dto.request.PessoaRequestDTO;
import br.com.wefit.recruitment.dto.response.PessoaResponseDTO;
import br.com.wefit.recruitment.model.Endereco;
import br.com.wefit.recruitment.model.Pessoa;
import br.com.wefit.recruitment.model.PessoaFisica;
import br.com.wefit.recruitment.model.PessoaJuridica;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    @Mapping(target = "id", ignore = true)
    PessoaFisica toPessoaFisica(PessoaRequestDTO request);

    @Mapping(target = "id", ignore = true)
    PessoaJuridica toPessoaJuridica(PessoaRequestDTO request);

    @Mapping(target = "tipoPessoa", expression = "java(getPessoaTipo(pessoa))")
    @Mapping(target = "cpf", expression = "java(pessoa instanceof PessoaFisica ? ((PessoaFisica) pessoa).getCpf() : null)")
    @Mapping(target = "cnpj", expression = "java(pessoa instanceof PessoaJuridica ? ((PessoaJuridica) pessoa).getCnpj() : null)")
    PessoaResponseDTO toResponseDTO(Pessoa pessoa);

    Endereco toEndereco(PessoaRequestDTO request);

    default String getPessoaTipo(Pessoa pessoa) {
        if (pessoa instanceof PessoaFisica) {
            return "FISICA";
        } else if (pessoa instanceof PessoaJuridica) {
            return "JURIDICA";
        }
        return null;
    }
}
