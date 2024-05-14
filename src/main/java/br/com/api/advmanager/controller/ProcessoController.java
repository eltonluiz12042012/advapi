package br.com.api.advmanager.controller;

import br.com.api.advmanager.dto.ListagemProcessosDTO;
import br.com.api.advmanager.dto.ProcessosDTO;
import br.com.api.advmanager.models.Processo;
import br.com.api.advmanager.service.ProcessoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("processos")
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;

    @GetMapping
    public Page<ListagemProcessosDTO> buscarTodosProcessos(Pageable paginas){
        return processoService.buscarTodosProcessos(paginas);

    }

    @PostMapping
    @Transactional
    public ResponseEntity Cadastrar(@RequestBody ProcessosDTO dados){
        var processo = new Processo(dados);
        processoService.salvar(processo);
        return ResponseEntity.ok(processo);
    }
}
