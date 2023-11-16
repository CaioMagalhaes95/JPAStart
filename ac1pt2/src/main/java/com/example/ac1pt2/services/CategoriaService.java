package com.example.ac1pt2.services;

import java.util.List;

import com.example.ac1pt2.dtos.CategoriaDTO;
import com.example.ac1pt2.dtos.DadosCategoriaDTO;
import com.example.ac1pt2.models.Categoria;

public interface CategoriaService {

    Categoria salvar(CategoriaDTO CategoriaDTO);
    CategoriaDTO obterCategoriaPorId(Long id);
    void remover(Long id);
    void editar(Long id, CategoriaDTO CategoriaDto);
    List<CategoriaDTO> obterTodos();
   
} 