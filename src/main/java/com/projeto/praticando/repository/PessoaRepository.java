package com.projeto.praticando.repository;

import com.projeto.praticando.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
