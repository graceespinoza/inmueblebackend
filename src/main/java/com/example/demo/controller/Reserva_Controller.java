package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import com.example.demo.entity.Inmueble;
import com.example.demo.entity.Reserva;
import com.example.demo.entity.Usuarios;
import com.example.demo.service.Reserva_Services;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class Reserva_Controller {
	
	@Autowired 
	Reserva_Services reseservi;
	
	@PostMapping("/add")
	public ResponseEntity<Reserva> save(@RequestBody Reserva poke){
		
		try {
			Reserva pokeguardad = reseservi.save(poke);
			return ResponseEntity.created(new URI("/reservas" + pokeguardad.getId_reserva())).body(pokeguardad);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtener (@PathVariable (value = "id") Long id_reserva){
		Optional<Reserva> poke = reseservi.findById(id_reserva);
    	
    	if(!poke.isPresent()) {
    		return ResponseEntity.notFound().build();
    		
    	}
    		return ResponseEntity.ok(poke);
	}
	
	//actualizar editar
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Reserva pokemdetais, @PathVariable(value = "id")Long id_reserva){
		
		Optional<Reserva> pok = reseservi.findById(id_reserva);
		
		if(!pok.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		pok.get().setEstado(pokemdetais.getEstado());
		pok.get().setFecha(pokemdetais.getFecha());
		pok.get().setHora(pokemdetais.getHora());
		pok.get().setTipo(pokemdetais.getTipo());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(reseservi.save(pok.get()));
	}
	//elimar
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long id_reserva){
		if(!reseservi.findById(id_reserva).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		reseservi.deleteById(id_reserva);
		return ResponseEntity.ok().build();
	}
	//lee todo los pokemones
	
	@GetMapping
	public List<Reserva> readAll(){
		List<Reserva> poki = StreamSupport
				.stream(reseservi.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return poki;
}
}
