package br.com.api.advmanager.dto;

import br.com.api.advmanager.models.Pessoa;
import br.com.api.advmanager.models.enums.TipoPessoa;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ListagemPessoasDto(
        Long id,
        String nome,
        String email,
        TipoPessoa tipoPessoa,
        String profissao,
        LocalDate dataNascimento,
        String sexo
) {
    public ListagemPessoasDto(Pessoa p){
        this(p.getId(), p.getNome(), p.getEmail(), p.getTipoPessoa(), p.getProfissao(), p.getDataNascimento(), p.getSexo());

    }
}
