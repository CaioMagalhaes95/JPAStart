package com.example.ac1pt2.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosProdutoDTO {
    private Long id;
    private String nome;
    private Double preco;

}
