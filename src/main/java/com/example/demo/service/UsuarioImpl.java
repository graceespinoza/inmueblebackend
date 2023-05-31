package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuarios;
import com.example.demo.repository.Usuario_Repository;

@Service
public class UsuarioImpl implements Usuario_Service {

	@Autowired
	public Usuario_Repository repousu;
	
	
	@Override
	public Iterable<Usuarios> findAll() {
		// TODO Auto-generated method stub
		return repousu.findAll();
	}

	@Override
	public List<Usuarios> findAlla() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Usuarios> findById(Long codigo) {
		// TODO Auto-generated method stub
		return repousu.findById(codigo);
	}

	@Override
	public Usuarios save(Usuarios poke) {
		// TODO Auto-generated method stub
		return repousu.save(poke);
	}

	@Override
	public void deleteById(Long codigo) {
		// TODO Auto-generated method stub
		repousu.deleteById(codigo);
	}

	@Override
	public List<Usuarios> findAllByPokemon(Long id_catego) {
		// TODO Auto-generated method stub
		return null;
	}

}
