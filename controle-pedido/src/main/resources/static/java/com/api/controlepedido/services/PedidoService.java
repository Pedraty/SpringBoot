package com.api.controlepedido.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.controlepedido.models.PedidoModel;
import com.api.controlepedido.repositories.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;

	
	@Transactional
	public Object save(PedidoModel pedidoModel) {
		return pedidoRepository.save(pedidoModel);
	}


	public boolean existsByLicensePlateCar(String licensePlateCar) {
		return pedidoRepository.existsByLicensePlateCar(licensePlateCar);
	}


	public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
		return pedidoRepository.existsByParkingSpotNumber(parkingSpotNumber);
	}


	public boolean existsByApartmentAndBlock(String apartment, String block) {
		return pedidoRepository.existsByApartmentAndBlock(apartment, block);
	}


	public List<PedidoModel> findAll() {
		return pedidoRepository.findAll();
	}


	public Optional<PedidoModel> findById(UUID id) {
		return pedidoRepository.findById(id);
	}
	
	
}
