package br.com.wefit.recruitment.repository;

import br.com.wefit.recruitment.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository  extends JpaRepository<Pessoa, Long> {

    boolean existsByEmail(String email);

    @Query("SELECT CASE WHEN COUNT(pf) > 0 THEN true ELSE false END FROM PessoaFisica pf WHERE pf.cpf = :cpf")
    boolean existsByCpf(@Param("cpf") String cpf);

    @Query("SELECT CASE WHEN COUNT(pj) > 0 THEN true ELSE false END FROM PessoaJuridica pj WHERE pj.cnpj = :cnpj")
    boolean existsByCnpj(@Param("cnpj") String cnpj);

    /*@Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM PessoaFisica p WHERE p.cpf = :cpf OR p.email = :email")
    boolean existsByCpfOrEmail(@Param("cpf") String cpf, @Param("email") String email);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM PessoaJuridica p WHERE p.cnpj = :cnpj OR p.email = :email")
    boolean existsByCnpjOrEmail(@Param("cnpj") String cnpj, @Param("email") String email);*/

}
