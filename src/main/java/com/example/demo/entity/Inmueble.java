package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity()
@Table(name="inmueble")
public class Inmueble implements Serializable{

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_inmueble;
	
	@Column(name="nombre", length=50)
	private String nombre;
	
	@Column(name="direccion", length=150)
	private String direccion;
	
	@Column(name="precio", length=50)
	private int precio;
	
	@Column(name="estado", length=1)
	private String estado;
	
	@Column(name="tipo_inmuble", length=150)
	private String tipo_inmuble;
	
	@ManyToOne
	@JoinColumn(name="usuarios")
	private Usuarios usuarios;

	
	
	
	public Inmueble() {
		super();
	}

	

	public Inmueble(Long id_inmueble, String nombre, String direccion, int precio, String estado, String tipo_inmuble,
			Usuarios usuarios) {
		super();
		this.id_inmueble = id_inmueble;
		this.nombre = nombre;
		this.direccion = direccion;
		this.precio = precio;
		this.estado = estado;
		this.tipo_inmuble = tipo_inmuble;
		this.usuarios = usuarios;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public Long getId_inmueble() {
		return id_inmueble;
	}

	public void setId_inmueble(Long id_inmueble) {
		this.id_inmueble = id_inmueble;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getTipo_inmuble() {
		return tipo_inmuble;
	}

	public void setTipo_inmuble(String tipo_inmuble) {
		this.tipo_inmuble = tipo_inmuble;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
