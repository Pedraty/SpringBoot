package com.example.jpatables;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaTablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaTablesApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ProdutoRepository produtoRepository) {
		
		return args -> {
			Produto coxinha = new Produto(
					"Coxinha",
					2.00,
					100,
					"Salgado"
					);
			
			produtoRepository.save(coxinha);
		};
	}
}
