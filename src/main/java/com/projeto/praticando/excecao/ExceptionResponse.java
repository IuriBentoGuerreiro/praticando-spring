package com.projeto.praticando.excecao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {

    private String mensagem;
    private String detalhes;
}
