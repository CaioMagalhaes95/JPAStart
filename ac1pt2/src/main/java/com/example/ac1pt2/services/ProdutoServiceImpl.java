package com.example.ac1pt2.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import com.example.ac1pt2.dtos.DadosProdutoDTO;
import com.example.ac1pt2.dtos.ProdutoDTO;
import com.example.ac1pt2.models.Produto;
import com.example.ac1pt2.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService{
    private final ProdutoRepository produtoRepository;


    @Override
    @Transactional
    public Produto salvar(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());

        return produtoRepository.save(produto);
    }

    @Override
    public List<DadosProdutoDTO> obterTodos(){
        return produtoRepository.findAll().stream().map(p -> {
            return DadosProdutoDTO.builder()
            .id(p.getId())
            .nome(p.getNome())
            .preco(p.getPreco())
            .build();
        }).collect(Collectors.toList());
    }

    // @Override
    // public DadosProdutoDTO obterPorId(Long id) {
    //     return produtoRepository.findById(id).map((Produto p) -> {
    //         return DadosProdutoDTO.builder()
    //         .id(p.getId())
    //         .nome(p.getNome())
    //         .preco(p.getPreco())
    //         .build();
    //     })
    // }


    @Override
    @Transactional
    public void remover(Long id){
        produtoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editar(Long id, ProdutoDTO produtoDTO) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
    
            if (produtoDTO != null) {
                produto.setNome(produtoDTO.getNome());
                produto.setPreco(produtoDTO.getPreco());
                
            }
    
            produtoRepository.save(produto);
        } else {
            throw new RuntimeErrorException(null);
        }
    }

    @Override
    public Produto findProduto(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProduto'");
    }

    

}
