package com.example.jpatables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Produto")
public class Produto {

	@Id
	@SequenceGenerator(name = "sequencia_produto", sequenceName = "sequencia_produto", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_produto")
	private Long id;

	@Column(nullable = false)
	private String nome_produto;
	@Column(nullable = false)
	private Double valor_produto;
	@Column(nullable = false)
	private Integer estoque_produto;
	@Column(nullable = false)
	private String categoria_produto;

	public Produto(String nome_produto,
			Double valor_produto,
			Integer estoque_produto,
			String categoria_produto) 
	{
		this.nome_produto = nome_produto;
		this.valor_produto = valor_produto;
		this.estoque_produto = estoque_produto;
		this.categoria_produto = categoria_produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public Double getValor_produto() {
		return valor_produto;
	}

	public void setValor_produto(Double valor_produto) {
		this.valor_produto = valor_produto;
	}

	public Integer getEstoque_produto() {
		return estoque_produto;
	}

	public void setEstoque_produto(Integer estoque_produto) {
		this.estoque_produto = estoque_produto;
	}

	public String getCategoria_produto() {
		return categoria_produto;
	}

	public void setCategoria_produto(String categoria_produto) {
		this.categoria_produto = categoria_produto;
	}

}
