package com.api.controlepedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ControlePedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlePedidoApplication.class, args);
	}
	@GetMapping("/")
	String index() {
		return "Olá Mundo";
	}

}
