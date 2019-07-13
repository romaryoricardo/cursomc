package br.com.romaryo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.romaryo.cursomc.domain.Cidade;


@Repository
public interface CidadeRespository extends JpaRepository<Cidade, Integer> {

}
