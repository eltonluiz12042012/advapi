package br.com.api.advmanager.dto;

import br.com.api.advmanager.models.Pessoa;
import br.com.api.advmanager.models.enums.EstadoCivil;
import br.com.api.advmanager.models.enums.TipoPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosUpdatePessoa(
        @NotNull
        Long id,

        String nome,
        LocalDate dataNascimento,
        String email,
        @Pattern(regexp = "\\d{11}")
        String cpf,


        @Pattern(regexp = "\\d{7,10}")
        String rg,

        @Pattern(regexp = "\\{14}")
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
    public DadosUpdatePessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getEmail(), pessoa.getCpf(), pessoa.getRg(), pessoa.getCnpj(), pessoa.getTipoPessoa(), pessoa.getProfissao(), pessoa.getNacionalidade(), pessoa.getEstadoCivil(), pessoa.getSexo(),pessoa.isAtivo(), new EnderecoDTO(pessoa.getEndereco()), pessoa.getTelefone(), pessoa.getCelular(), pessoa.getTelefoneComercial());
    }
}
