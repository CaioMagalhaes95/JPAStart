package com.example.ac1pt2.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac1pt2.dtos.CategoriaDTO;
import com.example.ac1pt2.dtos.DadosCategoriaDTO;
import com.example.ac1pt2.models.Categoria;
import com.example.ac1pt2.repository.CategoriaRepository;

import jakarta.transaction.Transactional;
@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public Categoria salvar(CategoriaDTO categoriaDTO) {
        Categoria c = new Categoria();

        c.setId(categoriaDTO.getId());
        c.setNome(categoriaDTO.getNome());

        return categoriaRepository.save(c);
        
    }

            @Override
        public CategoriaDTO obterCategoriaPorId(Long id) {
            return categoriaRepository.findById(id).map((Categoria c) -> {
                 return CategoriaDTO.builder()
                    .id(c.getId())
                    .nome(c.getNome())
                    .build();
            }).orElseThrow((null));
               
        }

    @Override
    public void remover(Long id) {
        categoriaRepository.deleteById(id);
    }

   
    @Override
    @Transactional
    public void editar(Long id, CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        
        if (categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
    
            if (categoriaDTO != null) {
                categoria.setNome(categoriaDTO.getNome());
                
                
            }
    
            categoriaRepository.save(categoria);
        } else {
            throw new RuntimeErrorException(null);
        }
    }

    @Override
    public List<CategoriaDTO> obterTodos() {
        List<CategoriaDTO> categorias = categoriaRepository.findAll().stream().map((Categoria c) -> {
            return CategoriaDTO.builder()
            .id(c.getId())
            .nome(c.getNome())
            .build();
        }).collect(Collectors.toList());
        return categorias;
    }

    
    
}
