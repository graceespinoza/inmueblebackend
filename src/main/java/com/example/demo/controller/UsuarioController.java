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

import com.example.demo.entity.Usuarios;
import com.example.demo.service.Usuario_Service;

@RestController
@RequestMapping("/usuAd")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	
	
	@Autowired 
	Usuario_Service servipoke;


	@PostMapping("/add")
	public ResponseEntity<Usuarios> save(@RequestBody Usuarios poke){
		try {
			Usuarios pokeguardad = servipoke.save(poke);
			return ResponseEntity.created(new URI("/usuAd" + pokeguardad.getCodigo())).body(pokeguardad);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtener (@PathVariable (value = "id") Long codigo){
		Optional<Usuarios> poke = servipoke.findById(codigo);
    	
    	if(!poke.isPresent()) {
    		return ResponseEntity.notFound().build();
    		
    	}
    		return ResponseEntity.ok(poke);
	}
	
	//actualizar editar
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Usuarios pokemdetais, @PathVariable(value = "id")Long codigo){
		
		Optional<Usuarios> pok = servipoke.findById(codigo);
		
		if(!pok.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		pok.get().setNombre(pokemdetais.getNombre());
		pok.get().setCelular(pokemdetais.getCelular());
		pok.get().setCedula(pokemdetais.getCedula());
		pok.get().setEmail(pokemdetais.getEmail());
		pok.get().setDireccion(pokemdetais.getDireccion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(servipoke.save(pok.get()));
	}
	//elimar
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> delete (@PathVariable(value = "codigo") Long codigo){
		if(!servipoke.findById(codigo).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		servipoke.deleteById(codigo);
		return ResponseEntity.ok().build();
	}
	//lee todo los pokemones
	
	@GetMapping
	public List<Usuarios> readAll(){
		List<Usuarios> poki = StreamSupport
				.stream(servipoke.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return poki;
	}
}
