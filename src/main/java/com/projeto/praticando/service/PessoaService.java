package com.projeto.praticando.service;

import com.projeto.praticando.dto.PessoaRequest;
import com.projeto.praticando.model.Pessoa;
import com.projeto.praticando.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar (PessoaRequest pessoaRequest){
        return pessoaRepository.save(Pessoa.converterParaPessoa(pessoaRequest));
    }

    public Pessoa pegarPorId (Integer id){
        return pessoaRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Recurso não encontrado")
        );
    }

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public void deletar(Integer id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa atualizar(Integer id, PessoaRequest pessoaRequest){
        Pessoa pessoaSalva = pegarPorId(id);
        BeanUtils.copyProperties(pessoaRequest, pessoaSalva, "id");
        return pessoaRepository.save(pessoaSalva);
    }
}
