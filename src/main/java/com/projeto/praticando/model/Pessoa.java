package com.projeto.praticando.model;

import com.projeto.praticando.dto.PessoaRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pessoa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "idade")
    private Integer idade;

    public Pessoa(Integer id){
        this.id = id;
    }

    public static Pessoa converterParaPessoa(PessoaRequest pessoaRequest){
        return Pessoa.builder()
                .nome(pessoaRequest.getNome())
                .email(pessoaRequest.getEmail())
                .telefone(pessoaRequest.getTelefone())
                .idade(pessoaRequest.getIdade())
                .build();
    }

}
