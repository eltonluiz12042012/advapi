package br.com.api.advmanager.controller;

import br.com.api.advmanager.dto.PessoasDTO;
import br.com.api.advmanager.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
   private PessoaService pessoaService;


   @PostMapping
   @Transactional
    public void cadastrar(@RequestBody PessoasDTO pessoa){
      pessoaService.cadastrarPessoa(pessoa);
   }

}
