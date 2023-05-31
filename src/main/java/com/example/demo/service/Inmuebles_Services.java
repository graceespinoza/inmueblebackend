package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Inmueble;



public interface Inmuebles_Services {
	
		public Iterable<Inmueble> findAll();
	
//	public Page<POKEMON> findAll(Pageable pageable);
		public List<Inmueble>findAlla();

		public Optional<Inmueble> findById(Long id_inmueble);
		
		public Inmueble save(Inmueble id_inmueble);
		
		public void deleteById(Long id_inmueble);
		
		public List<Inmueble>findAllByInmueble(Long id_inmueble);
}
