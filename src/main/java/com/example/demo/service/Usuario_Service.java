package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Usuarios;



public interface Usuario_Service {
	
		public Iterable<Usuarios> findAll();
	

		public List<Usuarios>findAlla();
		
		public Optional<Usuarios> findById(Long codigo);
		
		public Usuarios save(Usuarios codigo);
		
		public void deleteById(Long codigo);
		
		public List<Usuarios>findAllByPokemon(Long id_catego);
	

}
