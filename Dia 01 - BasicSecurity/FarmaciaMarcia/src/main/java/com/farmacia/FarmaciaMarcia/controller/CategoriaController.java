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

import com.farmacia.FarmaciaMarcia.model.CategoriaModel;
import com.farmacia.FarmaciaMarcia.repository.CategoriaRepository;

@RestController
@RequestMapping ("/categoria")
@CrossOrigin ("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<java.util.List<CategoriaModel>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}") public ResponseEntity<CategoriaModel> GetById(@PathVariable long id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.badRequest().build()); 
	}
	
	@PostMapping public ResponseEntity <CategoriaModel> Post(@RequestBody CategoriaModel descricao)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(descricao));
	}
	
	@PutMapping public ResponseEntity <CategoriaModel> Put(@RequestBody CategoriaModel descricao)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(descricao));
	}
	
	@DeleteMapping("/{id}")
	public void Delete (@PathVariable long id)
	{
		repository.deleteById(id);
	}

}
