package br.com.api.advmanager.service;

import br.com.api.advmanager.dto.PessoasDTO;
import br.com.api.advmanager.models.Endereco;
import br.com.api.advmanager.models.Pessoa;
import br.com.api.advmanager.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public void cadastrarPessoa(PessoasDTO dados){
        pessoaRepository.save(new Pessoa(dados));
    }



}
