package br.com.wefit.recruitment.service;

import br.com.wefit.recruitment.dto.request.PessoaRequestDTO;
import br.com.wefit.recruitment.dto.response.PessoaResponseDTO;
import br.com.wefit.recruitment.enums.TipoPessoa;
import br.com.wefit.recruitment.exception.NotFoundException;
import br.com.wefit.recruitment.mapper.PessoaMapper;
import br.com.wefit.recruitment.model.Pessoa;
import br.com.wefit.recruitment.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaResponseDTO salvar(PessoaRequestDTO pessoaRequestDTO) {
        validar(pessoaRequestDTO);

        Pessoa pessoa;

        if ("JURIDICA".equalsIgnoreCase(pessoaRequestDTO.getTipoPessoa())) {
            pessoa = pessoaMapper.toPessoaJuridica(pessoaRequestDTO);
        } else {
            pessoa = pessoaMapper.toPessoaFisica(pessoaRequestDTO);
        }

        pessoa.setEndereco(pessoaMapper.toEndereco(pessoaRequestDTO));

        return pessoaMapper.toResponseDTO(pessoaRepository.save(pessoa));
    }

    public PessoaResponseDTO buscarPorId(Long id) {
         var pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));

         return pessoaMapper.toResponseDTO(pessoa);
    }

    private void validar(PessoaRequestDTO pessoaRequestDTO) {
        if (pessoaRepository.existsByEmail(pessoaRequestDTO.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }

        if (!pessoaRequestDTO.getEmail().equals(pessoaRequestDTO.getConfirmacaoEmail())) {
            throw new IllegalArgumentException("E-mail e confirmação de email não coincidem!");
        }

        if (!pessoaRequestDTO.isTermos()) {
            throw new IllegalArgumentException("É necessário aceitar os termos de uso!");
        }

        if(TipoPessoa.FISICA.toString().equals(pessoaRequestDTO.getTipoPessoa())) {
            if (pessoaRepository.existsByCpf(pessoaRequestDTO.getCpf())) {
                throw new IllegalArgumentException("CPF já cadastrado.");
            }
        } else {
            if (pessoaRepository.existsByCnpj(pessoaRequestDTO.getCnpj())) {
                throw new IllegalArgumentException("CNPJ já cadastrado.");
            }
        }
    }

}