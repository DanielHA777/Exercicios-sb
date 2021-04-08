package com.example.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exerciciossb.models.Entity.Cliente;

@RestController
@RequestMapping("/clientes") // sem o path também funciona
public class ClienteController {
    @GetMapping(path = "/cliente/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28, "predro", "123.123.12323");
	}
    //passando parametros pela url, pode ser uma serie de parametros, 
    //pode usar o search/q= no navegador do google e passar parametros
    @GetMapping("/{id}") // valor pode ser modificado, 
    public Cliente obterClientePorId1(@PathVariable int id) { // essa anottation pega o valor q vc passou na url e traz pra ca, valor digitado no navegador
    	return new Cliente(id, "maria", "999.999.999-99");
    }
    @GetMapping
    public Cliente obterClientePorId2( 
    		@RequestParam(name = "id", defaultValue = "1") int id) { 
    	return new Cliente(id, "joao", "111.111.111-11");
    }
}
