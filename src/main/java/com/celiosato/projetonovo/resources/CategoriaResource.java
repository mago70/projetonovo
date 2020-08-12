package com.celiosato.projetonovo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.celiosato.projetonovo.domain.Categoria;
import com.celiosato.projetonovo.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		return obj;
	}
	
	@GetMapping(value = "/{id}")
	public Categoria findId(@PathVariable Integer id) {
		Categoria obj = service.findId(id);
		return obj;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody Categoria obj) {
		obj.setId(id);
		obj = service.update(id, obj);
		
	}


}
