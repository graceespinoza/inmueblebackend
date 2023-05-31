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
import com.example.demo.service.Inmuebles_Services;

@RestController
@RequestMapping("/inmuebles")
@CrossOrigin(origins = "*")
public class Inmueble_Controller {
	@Autowired 
	Inmuebles_Services inmuservis;
	
	@PostMapping("/add")
	public ResponseEntity<Inmueble> save(@RequestBody Inmueble poke){
		try {
			Inmueble pokeguardad = inmuservis.save(poke);
			return ResponseEntity.created(new URI("/inmuebles" + pokeguardad.getId_inmueble())).body(pokeguardad);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtener (@PathVariable (value = "id") Long id_inmueble){
		Optional<Inmueble> poke = inmuservis.findById(id_inmueble);
    	
    	if(!poke.isPresent()) {
    		return ResponseEntity.notFound().build();
    		
    	}
    		return ResponseEntity.ok(poke);
	}
	
	//actualizar editar
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Inmueble pokemdetais, @PathVariable(value = "id")Long id_inmueble){
		
		Optional<Inmueble> pok = inmuservis.findById(id_inmueble);
		
		if(!pok.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		pok.get().setDireccion(pokemdetais.getDireccion());
		pok.get().setNombre(pokemdetais.getNombre());
		pok.get().setPrecio(pokemdetais.getPrecio());
		pok.get().setTipo_inmuble(pokemdetais.getTipo_inmuble());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(inmuservis.save(pok.get()));
	}
	//elimar
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long id_inmueble){
		if(!inmuservis.findById(id_inmueble).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		inmuservis.deleteById(id_inmueble);
		return ResponseEntity.ok().build();
	}
	//lee todo los pokemones
	
	@GetMapping
	public List<Inmueble> readAll(){
		List<Inmueble> poki = StreamSupport
				.stream(inmuservis.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return poki;
	}
}
