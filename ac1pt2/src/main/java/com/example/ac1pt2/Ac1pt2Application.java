package com.example.ac1pt2;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1pt2.models.Categoria;
import com.example.ac1pt2.models.Produto;
import com.example.ac1pt2.repository.CategoriaRepository;
import com.example.ac1pt2.repository.ProdutoRepository;

@SpringBootApplication
public class Ac1pt2Application {

	

    @Bean
    public CommandLineRunner init( 
        @Autowired ProdutoRepository produtoRepository,
        @Autowired CategoriaRepository categoriaRepository
    ) {
        return args -> {

            Categoria categoria1 = new Categoria((long) 0, "firstcategory1");
            categoriaRepository.save(categoria1);

            Categoria categoria2 = new Categoria((long) 0, "secondcategory2");
            categoriaRepository.save(categoria2);
            
            

            Produto produto1 = new Produto((long) 0, "Notebook Dell", 1200.0);
            produto1.setCategoriaProduto(categoria1);
            produtoRepository.save(produto1);
             
            Produto produto2 = new Produto((long) 0, "Mouse Logitech", 25.0);
            produto2.setCategoriaProduto(categoria2);
            produtoRepository.save(produto2);

            Produto produto3 = new Produto((long) 0, "Teclado HP", 30.0);
            produto3.setCategoriaProduto(categoria1);
            produtoRepository.save(produto3);



            // Consulta produtos com preço maior que 50.0
            System.out.println("Produtos com preço maior que 50.0:");
            List<Produto> produtosPrecoMaiorQue50 = produtoRepository.findByPrecoGreaterThan(50.0);
            produtosPrecoMaiorQue50.forEach(System.out::println);

            // Consulta produtos com preço menor ou igual a 30.0
            System.out.println("\nProdutos com preço menor ou igual a 30.0:");
            List<Produto> produtosPrecoMenorIgual30 = produtoRepository.findByPrecoLessThanEqual(30.0);
            produtosPrecoMenorIgual30.forEach(System.out::println);

            // Consulta produtos cujo nome começa com "Notebook"
            System.out.println("\nProdutos cujo nome começa com 'Notebook':");
            List<Produto> produtosNomeComecaComNotebook = produtoRepository.findByNomeStartingWith("Notebook");
            produtosNomeComecaComNotebook.forEach(System.out::println);

            System.out.println("Categorias com 'First'");
            List<Categoria> categorias= categoriaRepository.findByNomeStartingWith("first");
            categorias.forEach(System.out::println);
           

           System.out.println("Produtos por categoria:");
            Categoria categoriaProdutos = categoriaRepository.findByIdWithProdutos((long)1);
            System.out.println(categoriaProdutos);
           
        
        };

}

	public static void main(String[] args) {
		SpringApplication.run(Ac1pt2Application.class, args);
	}

}
