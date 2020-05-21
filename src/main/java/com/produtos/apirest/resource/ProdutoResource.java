package com.produtos.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping(value = "produtos")
	public List<Produto> listaProdutos() {

		return produtoRepository.findAll();

	}

	@GetMapping(value = "/produto/{id}")
	public Produto listaProdutoPorId(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);

	}

	@DeleteMapping(value = "/produto/{id}")
	public Produto deletaProduto(@PathVariable(value = "id") long id) {
		return produtoRepository.deleteById(id);
	}
	
	//OUTRA FORMA DE DELETAR PASSANDO O OBJETO
	@DeleteMapping(value = "produto")
	public void deletaProduto(Produto produto) {
		produtoRepository.delete(produto);
	}

	@PostMapping(value = "/produtos")
	public Produto salvaProduto(@RequestBody Produto produto) {

		return produtoRepository.save(produto);

	}
	
	@PutMapping("/produtos")
	public Produto alteraProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

}
