package com.example.exerciciossb.controllers;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exerciciossb.models.Entity.Produto;
import com.example.exerciciossb.models.Repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
   @Autowired    // automatcmaente coloca um objeto dentro dele, adiciona uma implementação
	private ProdutoRepository produtoRepository;
	
	// faz parte do corpo da resposta // salva e altera ao mesmo tempo
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
   public @ResponseBody Produto novoProduto(/*@Valid*/ Produto produto) {//produto valido
		//Produto produto = new Produto(nome, preco, desconto);
		//System.out.println(produto.repository);
		produtoRepository.save(produto);
		return produto;
	}
	//obter lista com todos os pordutos
	@GetMapping
	public Iterable<Produto> obterProdutos() { // retorna todos os produtos do bd
		return produtoRepository.findAll(); // retorna a interface interablle, interavel de produto
	}
	//busca por nome ou letra
	@GetMapping(path="/nome/{rteNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) { 
		return produtoRepository.findByNomeContaininIgnoreCase(parteNome); 
	}
	
	//consulta paginada
	@GetMapping(path = "/pagina/{numeroPagina}")
	public Iterable<Produto> obterProdutoPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdPagina){
	if(qtdPagina >= 5) qtdPagina = 5;
		PageRequest page = PageRequest.of(numeroPagina, qtdPagina); // pagina 0 e 3 elementos
		return produtoRepository.findAll(page); // page como parametro
	}
	
	// busca por id
	@GetMapping(path="/id")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);  // busca por id
	}
	//alterando dados no bd
	//@PutMapping
	//public Produto alterarProduto(/*@Valid*/Produto produto) {
		//produtoRepository.save(produto);
	//	return produto;
	//}*/
	//excluir ppor id
	@DeleteMapping(path = "/{id}")
	public void excluirProdutoPorId(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
}
