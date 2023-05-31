package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Inmueble;

public interface Inmueble_repo extends JpaRepository<Inmueble,Long> {

}
