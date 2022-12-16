package com.api.pedido.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pedido.dtos.PedidoDto;
import com.api.pedido.models.PedidoModel;
import com.api.pedido.serivces.PedidoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("")

public class PedidoController {
	
	//final PedidoService pedidoService;
	
	//public PedidoController (PedidoService pedidoService) {
	//	this.pedidoService = pedidoService;
	//}
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Object> savePedido(@RequestBody @Valid PedidoDto pedidoDto){
		var pedidoModel = new PedidoModel();
		BeanUtils.copyProperties(pedidoDto, pedidoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedidoModel));
	}

	@GetMapping
	public ResponseEntity<List<PedidoModel>> getAllPedido(){
		return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOnePedido(@PathVariable(value = "id")UUID id){
		Optional<PedidoModel> pedidoModelOptional = pedidoService.findById(id);
		if(!pedidoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(pedidoModelOptional.get());
	} 
	
	@DeleteMapping("/{id}")
		public ResponseEntity<Object> deletePedido(@PathVariable(value = "id")UUID id){
		Optional<PedidoModel> pedidoModelOptional = pedidoService.findById(id);
		if(!pedidoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
		}
		pedidoService.delete(pedidoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Pedido deletado com sucesso");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePedido(@PathVariable (value = "id") UUID id, @RequestBody @Valid PedidoDto pedidoDto){
		Optional<PedidoModel> pedidoModelOptional = pedidoService.findById(id);
		
		if(!pedidoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
		}
		
		
		var pedidoModel = new PedidoModel();
		BeanUtils.copyProperties(pedidoDto, pedidoModel);
		pedidoModel.setId(pedidoModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(pedidoService.save(pedidoModel));
	}

}




