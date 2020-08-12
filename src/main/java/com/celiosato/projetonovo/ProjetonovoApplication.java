package com.celiosato.projetonovo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.celiosato.projetonovo.domain.Categoria;
import com.celiosato.projetonovo.repositories.CategoriaRepository;

@SpringBootApplication
public class ProjetonovoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetonovoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Celio");
		Categoria cat2 = new Categoria(null, "Bruna Yumi");
		
		List<Categoria> list = new ArrayList<>();
		list.add(cat1);
		list.add(cat2);
		
		repo.saveAll(list);
	}

}
