package com.api.pedido.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.pedido.models.PedidoModel;

@Repository		

public interface PedidoRepository extends JpaRepository<PedidoModel, UUID>{


}
