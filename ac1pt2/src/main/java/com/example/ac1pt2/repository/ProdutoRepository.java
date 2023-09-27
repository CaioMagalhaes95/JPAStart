package com.example.ac1pt2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac1pt2.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    
     List<Produto> findByPrecoGreaterThan(Double valor);

    List<Produto> findByPrecoLessThanEqual(Double preco);

    List<Produto> findByNomeStartingWith(String nome);
}
