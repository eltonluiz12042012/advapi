package br.com.api.advmanager.service;

import br.com.api.advmanager.dto.ListagemProcessosDTO;
import br.com.api.advmanager.models.Processo;
import br.com.api.advmanager.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class ProcessoService {

    @Autowired
    private ProcessoRepository processoRepository;
    public Page<ListagemProcessosDTO> buscarTodosProcessos(Pageable paginas) {
        return processoRepository.findAll(paginas)
                .map(ListagemProcessosDTO::new);
    }

    public void salvar(Processo processo) {
        processoRepository.save(processo);
    }
}
