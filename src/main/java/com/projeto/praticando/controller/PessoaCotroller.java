package com.projeto.praticando.controller;

import com.projeto.praticando.dto.PessoaRequest;
import com.projeto.praticando.dto.PessoaResponse;
import com.projeto.praticando.service.PessoaService;
import com.projeto.praticando.model.Pessoa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Tag(name = "Pessoa")
@RestController
@RequestMapping("/pessoa")
public class PessoaCotroller {

    @Autowired
    private PessoaService pessoaService;

    @Operation(summary = "Salvar pessoa")
    @PostMapping
    public ResponseEntity<PessoaResponse> salvar(@Valid @RequestBody PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaService.salvar(pessoaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(PessoaResponse.converterParaPessoaResponse(pessoa));
    }

    @Operation(summary = "Listar pessoa(s)")
    @GetMapping
    public List<PessoaResponse> listar(){
        return pessoaService.listar().stream()
                .map(pessoa -> PessoaResponse.converterParaPessoaResponse(pessoa))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Pegar pessoa por id")
    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> pegarPorId(@PathVariable Integer id){
        Pessoa pessoa = pessoaService.pegarPorId(id);
        return ResponseEntity.ok(PessoaResponse.converterParaPessoaResponse(pessoa));
    }

    @Operation(summary = "Atualizar pessoa")
    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody PessoaRequest pessoaRequest){
        Pessoa pessoaSalva = pessoaService.atualizar(id,pessoaRequest);
        return ResponseEntity.ok(PessoaResponse.converterParaPessoaResponse(pessoaSalva));
    }

    @Operation(summary = "Deletar pessoa")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        pessoaService.deletar(id);
    }
}
