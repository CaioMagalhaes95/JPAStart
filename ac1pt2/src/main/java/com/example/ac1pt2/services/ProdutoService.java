package com.example.ac1pt2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac1pt2.dtos.DadosCategoriaDTO;
import com.example.ac1pt2.dtos.DadosProdutoDTO;
import com.example.ac1pt2.dtos.ProdutoDTO;
import com.example.ac1pt2.models.Produto;

@Service
public interface ProdutoService {
    Produto salvar(ProdutoDTO ProdutoDTO);
    ProdutoDTO obterPorId(Long id);
    void remover(Long id);
    void editar(Long id, ProdutoDTO ProdutoDto);
    List<ProdutoDTO> obterTodos();
    Produto findProduto(Long id);
    
}