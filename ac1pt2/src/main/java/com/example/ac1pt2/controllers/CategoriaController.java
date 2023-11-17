package com.example.ac1pt2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac1pt2.dtos.CategoriaDTO;
import com.example.ac1pt2.dtos.DadosCategoriaDTO;
import com.example.ac1pt2.models.Categoria;
import com.example.ac1pt2.services.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria salvar(@RequestBody CategoriaDTO categoriaDTO){
        Categoria c = categoriaService.salvar(categoriaDTO);
        return c;
    }

    @GetMapping
    public List<CategoriaDTO> getCategorias(){
        return categoriaService.obterTodos();
    }

    @GetMapping("{id}")
    public CategoriaDTO obterCategoria(@RequestParam Long id){
        return categoriaService.obterCategoriaPorId(id);
    }

    // @GetMapping("{id}")
    // public DadosCategoriaDTO obterCategoriaPorId(@PathVariable Long id){
    //     return categoriaService.obterCategoriaPorId(id);
    // }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover (@PathVariable Long id){
        categoriaService.remover(id);
    }

    @PutMapping("{id}")
    public void editCategoria(@PathVariable Long id, @RequestBody CategoriaDTO dto){
        categoriaService.editar(id, dto);
    }
}
