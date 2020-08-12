package com.celiosato.projetonovo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.celiosato.projetonovo.domain.Categoria;
import com.celiosato.projetonovo.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Categoria findId(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto não encontrado") );
	}

	public void delete(Integer id) {
		findId(id);
		repo.deleteById(id);
		
	}

	public Categoria update(Integer id, Categoria obj) {
		Categoria newObj = findId(id);
		newObj.setNome(obj.getNome());
		return repo.save(newObj);
	}

}
