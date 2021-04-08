package com.example.exerciciossb.models.Repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.exerciciossb.models.Entity.Produto;
                                          // permite consultas pagina e etc
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{
    @Query
	//public Iterable<Produto> findByNomeContaininIgnoreCase(String parteNome);

	Iterable<Produto> findAll(PageRequest page);

	Iterable<Produto> findByNomeContaininIgnoreCase(String parteNome);
   // findBynomeContaining
	//findByNomeIsConatining
	//FindByNomeContains
	//FindByNomeStarsWith
	//FindByNomeEndsWith
	//findByNomeNotContaining oposto do containing
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> serachByNameLike(@Param("nome") String nome);

}
