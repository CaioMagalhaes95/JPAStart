package com.example.ac1pt2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac1pt2.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    
     List<Produto> findByNome(String nome);
}
