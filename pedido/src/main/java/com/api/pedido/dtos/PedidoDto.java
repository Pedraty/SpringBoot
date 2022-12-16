package com.api.pedido.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PedidoDto {
	
	@NotBlank
	private String nomeCliente;
	@NotNull
	private byte quantidade;
	@NotBlank
	private String nomeProduto;
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public byte getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(byte quantidade) {
		this.quantidade = quantidade;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	
	
}
