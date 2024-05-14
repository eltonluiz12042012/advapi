package br.com.api.advmanager.controller;

import br.com.api.advmanager.dto.DadosUpdatePessoa;
import br.com.api.advmanager.dto.ListagemPessoasDto;
import br.com.api.advmanager.dto.PessoasDTO;
import br.com.api.advmanager.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
   private PessoaService pessoaService;


   @PostMapping
   @Transactional
    public void cadastrar(@RequestBody @Valid PessoasDTO pessoa){
      pessoaService.cadastrarPessoa(pessoa);
   }


   /**
    * Para controlar a quantidade de registros por página use o parâmetro size, e para controlar a página usar page
    *  http://localhost:8090/pessoas?size=1&page=2
    *  Se quiser ordernar use o sort
    *  http://localhost:8090/pessoas?sort=email,asc
    *
    *  @PageableDefault(size = 10, sort = {"email",},direction = Sort.Direction.DESC)
    *  Define um padrão de paginação e ordenação.
   **/
   @GetMapping
   public Page<ListagemPessoasDto> listarTodasASPessoas(@PageableDefault(size = 10, sort = {"email",},direction = Sort.Direction.DESC) Pageable paginacao){
       return pessoaService.buscarPessoas(paginacao);
   }

   @PutMapping
   @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosUpdatePessoa pessoasDTO){
       var pessoa = pessoaService.buscarPessoaPorId(pessoasDTO.id());
       pessoa.dadosUpdate(pessoasDTO);
       return ResponseEntity.ok(new PessoasDTO(pessoa));
   }

   @DeleteMapping("/{id}")
   @Transactional
    public ResponseEntity exclusaoLogica(@PathVariable Long id){
       var pessoa = pessoaService.buscarPessoaPorId(id);
       pessoa.desativar();
       return ResponseEntity.noContent().build();
   }

   @GetMapping("/{id}")
    public ResponseEntity buscarPessoaPorId(@PathVariable Long id){
       var pessoa = pessoaService.buscarPessoaPorId(id);
       return ResponseEntity.ok(new PessoasDTO(pessoa));
   }


}
