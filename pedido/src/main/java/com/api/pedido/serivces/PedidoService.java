package com.api.pedido.serivces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pedido.models.PedidoModel;
import com.api.pedido.repositories.PedidoRepository;

@Service

public class PedidoService {

	//final PedidoRepository pedidoRepository;
	
	//public PedidoService (PedidoRepository pedidoRepository) {
	//	this.pedidoRepository = pedidoRepository;
	//}
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Transactional
	public PedidoModel save(PedidoModel pedidoModel) {
		return pedidoRepository.save(pedidoModel);
	}

	public List<PedidoModel> findAll() {
		
		return pedidoRepository.findAll();
	}

	public Optional<PedidoModel> findById(UUID id) {
		return pedidoRepository.findById(id);
	}
	
	@Transactional
	public void delete(PedidoModel pedidoModel) {
		pedidoRepository.delete(pedidoModel);
		
	}


}
