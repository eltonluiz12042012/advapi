package br.com.api.advmanager.dto;

import br.com.api.advmanager.models.Endereco;
import br.com.api.advmanager.models.enums.EstadoCivil;
import br.com.api.advmanager.models.enums.TipoPessoa;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public record PessoasDTO(
        Long id,
        String nome,
        LocalDate dataNascimento,
        String email,
        String cpf,
        String rg,
        String cnpj,
        TipoPessoa tipoPessoa,
        String profissao,
        String nacionalidade,
        EstadoCivil estadoCivil,
        String sexo,
        boolean ativo,
        EnderecoDTO endereco,
        String telefone,
        String celular,
        String telefoneComercial) {
}
