package com.farmacia.FarmaciaMarcia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.FarmaciaMarcia.model.ProdutoModel;
import com.farmacia.FarmaciaMarcia.repository.ProdutoRepository;


@RestController
@RequestMapping ("/produto")
@CrossOrigin ("*")

public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<java.util.List<ProdutoModel>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}") public ResponseEntity<ProdutoModel> GetById(@PathVariable long id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.badRequest().build()); 
	}
	
	@PostMapping public ResponseEntity <ProdutoModel> Post(@RequestBody ProdutoModel nome)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nome));
	}
	
	@PutMapping public ResponseEntity <ProdutoModel> Put(@RequestBody ProdutoModel nome)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nome));
	}
	
	@DeleteMapping("/{id}")
	public void Delete (@PathVariable long id)
	{
		repository.deleteById(id);
	}

}
