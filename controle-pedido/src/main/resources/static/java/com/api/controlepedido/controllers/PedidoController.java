package com.api.controlepedido.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.controlepedido.dtos.PedidoDto;
import com.api.controlepedido.models.PedidoModel;
import com.api.controlepedido.services.PedidoService;

import jakarta.validation.Valid;

//É o controle da nossa API
@RestController

//responsável por receber informações de multiplas origens
@CrossOrigin(origins = "*", maxAge = 3600)

//Carrega a página de pedido
@RequestMapping("/pedido")

public class PedidoController {

	// ponto de injeção do service
	@Autowired
	PedidoService pedidoService;

	@PostMapping
	// ResponseEntity para criar um corpo para resposta, o object serve para possuir
	// diferentes tipos
	// de retornos
	public ResponseEntity<Object> savePedido(@RequestBody @Valid PedidoDto pedidoDto) {
		//antes de criar uma nova instância para salvar os dados, é preciso validar se esses dados
		//já não foram inseridos
		
		if (pedidoService.existsByLicensePlateCar(pedidoDto.getLicensePlateCar())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: A placa do carro já está em uso!");
		}
		if (pedidoService.existsByParkingSpotNumber(pedidoDto.getParkingSpotNumber())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: A vaga já está em uso!");
		}
		if (pedidoService.existsByApartmentAndBlock(pedidoDto.getApartment(), pedidoDto.getBlock())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: A vaga já está registrada para este apartamento/bloco!");
		}
		
		
		
		var pedidoModel = new PedidoModel();
		// crio uma nova instância de pedidoModel

		// Agora vamos utilizar uma maneira bem rápida de converter dto para model
		// utilizando o BeanUtils
		
		//                    inicial(Dto) -> final(Model)
		BeanUtils.copyProperties(pedidoDto, pedidoModel);
		pedidoModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		
		//Construindo a resposta onde o status é o método HTTP created e o retorno, que é o
		//pedido salvo com a data e etc...
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedidoModel));
	}
	
	@GetMapping
	public ResponseEntity<List<PedidoModel>> getAllPedidos(){
		return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOnePedido(@PathVariable(value = "id") UUID id){
		Optional<PedidoModel> pedidoModelOptional = pedidoService.findById(id);
		if (!pedidoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrada nenhuma vaga");
		}
		return ResponseEntity.status(HttpStatus.OK).body(pedidoModelOptional.get());
	}
	
	
	
}
