package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name="nombre", length=50)
	private String nombre;
	
	@Column(name="cedula", length=10)
	private int cedula;
	
	@Column(name="direccion", length=50)
	private String direccion;
	
	@Column(name="email", length=50)
	private String email;
	
	@Column(name="contrasena", length=50)
	private String contrasena;
	
	@Column(name="celular", length=10)
	private int celular;
	
	@Column(name="rol", length=10)
	private String rol;

	public Usuarios() {
		super();
	}

	public Usuarios(Long codigo, String nombre, int cedula, String direccion, String email, String contrasena,
			int celular, String rol) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cedula = cedula;
		this.direccion = direccion;
		this.email = email;
		this.contrasena = contrasena;
		this.celular = celular;
		this.rol = rol;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
	
	
}
