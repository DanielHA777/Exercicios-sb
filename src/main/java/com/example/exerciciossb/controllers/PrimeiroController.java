package com.example.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // o spring considera essa classe como restcontroller
public class PrimeiroController {     // sempre q digitar algo no navegador e dar enter é uma requisição do tipo get
	//@RequestMapping(method = RequestMethod.GET, path = "/ola") // mapeia uma requisição para o metodo, metodo get
	// path define ola como requisição get para retornar ola spring boot
	@GetMapping(path = {"/ola", "/saudacao"}) // 2 url para chamar ola spring boot // array
	public String ola() {
		return "ola Spring boot";
	}
	//rest controler procura as classes com anotação e faz o mapeamento para determinado metodo ser chamado
	//até agora:
	//baixou o zip start.io -> importou o projeto maven com todas as dependencias de automatico-> executou o metodo main e usou 2 anottations
	//@GetMapping(path = {"/saudacao"}) // ja tem um metodo mapeado para essa url, da erro
	@PostMapping(path = "/saudacao") // funciona, 
	public String saudacao() {
		return "ola Spring boot (POST)!";
	}
}
