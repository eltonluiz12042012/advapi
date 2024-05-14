package br.com.api.advmanager.models;


import br.com.api.advmanager.dto.EnderecoDTO;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Embeddable
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(EnderecoDTO dados) {
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
    }

    public void updateEndereco(EnderecoDTO dados) {
        if(dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if(dados.cep() != null) {
            this.cep = dados.cep();
        }
        if(dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if(dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if(dados.uf() != null) {
            this.uf = dados.uf();
        }
        if(dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if(dados.numero() != null) {
            this.numero = dados.numero();
        }
    }
}
