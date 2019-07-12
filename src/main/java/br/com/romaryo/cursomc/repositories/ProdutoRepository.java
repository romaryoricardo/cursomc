package br.com.romaryo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.romaryo.cursomc.domain.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	
}
