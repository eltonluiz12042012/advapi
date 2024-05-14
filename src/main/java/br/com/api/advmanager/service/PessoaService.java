package br.com.api.advmanager.service;

import br.com.api.advmanager.dto.ListagemPessoasDto;
import br.com.api.advmanager.dto.PessoasDTO;
import br.com.api.advmanager.models.Endereco;
import br.com.api.advmanager.models.Pessoa;
import br.com.api.advmanager.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public void cadastrarPessoa(PessoasDTO dados){
        pessoaRepository.save(new Pessoa(dados));
    }


    public Page<ListagemPessoasDto> buscarPessoas(Pageable paginacao) {
        return pessoaRepository.findAllByAtivoTrue(paginacao)
                .map(ListagemPessoasDto::new);

    }

    public Pessoa buscarPessoaPorId(Long id) {
        return pessoaRepository.getReferenceById(id);
    }
}
