package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Inmueble;
import com.example.demo.entity.Reserva;
import com.example.demo.repository.Reserva_repo;
@Service
public class ReservaInmu implements Reserva_Services{

	
	@Autowired
	public Reserva_repo  reserepol;

	@Override
	public Iterable<Reserva> findAll() {
		// TODO Auto-generated method stub
		return reserepol.findAll();
	}

	@Override
	public Optional<Reserva> findById(Long id_reserva) {
		// TODO Auto-generated method stub
		return reserepol.findById(id_reserva);
	}

	@Override
	public Reserva save(Reserva poke) {
		// TODO Auto-generated method stub
		return reserepol.save(poke);
	}

	@Override
	public void deleteById(Long id_reserva) {
		// TODO Auto-generated method stub
		reserepol.deleteById(id_reserva);
	}

	@Override
	public List<Reserva> findAllByReserva(Long id_reserva) {
		// TODO Auto-generated method stub
		List<Reserva> respuesta= new ArrayList<>();
		List<Reserva> poki = reserepol.findAll();
		for(int i=0; i<poki.size(); i++) {
			if(poki.get(i).getInmueble().getId_inmueble()==id_reserva){
				respuesta.add(poki.get(i));
				}
			
		}
		return respuesta;
	}

	@Override
	public List<Reserva> findAlla() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
