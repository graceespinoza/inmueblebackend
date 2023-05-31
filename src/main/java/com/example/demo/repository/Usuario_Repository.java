package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Usuarios;

public interface Usuario_Repository extends JpaRepository<Usuarios, Long> {

}
