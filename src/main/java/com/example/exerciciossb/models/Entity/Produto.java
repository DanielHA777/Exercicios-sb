package com.example.exerciciossb.models.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.exerciciossb.models.Repository.ProdutoRepository;
import com.sun.istack.NotNull;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@NotNull 
private String nome;

@Autowired    // automatcmaente coloca um objeto dentro dele, adiciona uma implementação
	@Transient
public ProdutoRepository repository;

//@min(0
private double preco;
//@Min(0)
//@Mas(1)
private double desconto;


public Produto(String nome, double preco, double desconto) {
	super();
	this.nome = nome;
	this.preco = preco;
	this.desconto = desconto;
}


public ProdutoRepository getRepository() {
	return repository;
}


public void setRepository(ProdutoRepository repository) {
	this.repository = repository;
}


public double getPreco() {
	return preco;
}


public void setPreco(double preco) {
	this.preco = preco;
}


public double getDesconto() {
	return desconto;
}


public void setDesconto(double desconto) {
	this.desconto = desconto;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}



}
