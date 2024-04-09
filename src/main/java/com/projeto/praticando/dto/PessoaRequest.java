package com.projeto.praticando.dto;

import com.projeto.praticando.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class PessoaRequest {

    @Length(min = 3, max = 50, message = "Nome")
    @NotBlank(message = "Nome")
    private String nome;
    @NotBlank(message = "Email")
    private String email;
    @Pattern(regexp = "\\([\\d]{2}\\)[\\d]{5}[- .][\\d]{4}", message = "Telefone")
    @NotBlank(message = "Telefone")
    private String telefone;
    private Integer idade;
}
