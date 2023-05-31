package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Inmueble;
import com.example.demo.entity.Reserva;



public interface Reserva_Services {
		
	
	public Iterable<Reserva> findAll();
	
//	public Page<POKEMON> findAll(Pageable pageable);
	
		public Optional<Reserva> findById(Long id_reserva);
		
		public Reserva save(Reserva id_reserva);
		
		public void deleteById(Long id_reserva);
		
		public List<Reserva>findAlla();

		
		public List<Reserva>findAllByReserva(Long id_reserva);
}
