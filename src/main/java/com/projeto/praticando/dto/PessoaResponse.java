package com.projeto.praticando.dto;

import com.projeto.praticando.model.Pessoa;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class PessoaResponse {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private Integer idade;

    //método para converter objeto pessoa para PessoaResponse
    public static PessoaResponse converterParaPessoaResponse(Pessoa pessoa){
        var response = new PessoaResponse();
        BeanUtils.copyProperties(pessoa, response);
        return response;
    }
}
