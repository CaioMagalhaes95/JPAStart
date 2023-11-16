package com.example.ac1pt2.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac1pt2.dtos.DadosProdutoDTO;
import com.example.ac1pt2.dtos.ProdutoDTO;
import com.example.ac1pt2.models.Produto;
import com.example.ac1pt2.services.ProdutoService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@RequestBody ProdutoDTO produtoDTO){
        return produtoService.salvar(produtoDTO);
        
    }

    @GetMapping
    public List<ProdutoDTO> getProdutos(){
        return produtoService.obterTodos();
    }

    @GetMapping("{id}")
    public Produto obterProdutoPorId(@RequestParam Long id) {
        return produtoService.findProduto(id);
    }

    // @GetMapping("{id}")
    // public DadosProdutoDTO getProdutoPorId(@PathVariable Long id){
    //     return produtoService.obterProdutoPorId(id);
    // }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        produtoService.remover(id);
    }

    @PutMapping("{id}")
    public void editProduto(@PathVariable Long id, @RequestBody ProdutoDTO dto){
        produtoService.editar(id, dto);
    }
    
    
}
