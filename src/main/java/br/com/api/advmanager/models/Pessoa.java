package br.com.api.advmanager.models;

import br.com.api.advmanager.dto.PessoasDTO;
import br.com.api.advmanager.models.enums.EstadoCivil;
import br.com.api.advmanager.models.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;

@Entity(name = "Pessoa")
@Table(name="pessoas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sexo;
    private LocalDate dataNascimento;
    private String email;
    private String cpf;
    private String rg;
    private String cnpj;
    private String profissao;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;
    private String nacionalidade;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    private boolean ativo;
    @Embedded
    private Endereco endereco;
    private String telefone;
    private String celular;
    private String telefoneComercial;

    public Pessoa(PessoasDTO dados) {
        this.nome = dados.nome();
        this.sexo = dados.sexo();
        this.dataNascimento = dados.dataNascimento();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.rg = dados.rg();
        this.cnpj = dados.cnpj();
        this.profissao = dados.profissao();
        this.tipoPessoa = dados.tipoPessoa();
        this.nacionalidade = dados.nacionalidade();
        this.estadoCivil = dados.estadoCivil();
        this.ativo = dados.ativo();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
        this.celular = dados.celular();
        this.telefoneComercial = dados.telefoneComercial();
    }
}
