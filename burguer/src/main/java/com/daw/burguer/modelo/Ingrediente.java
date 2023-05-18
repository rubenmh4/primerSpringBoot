package com.daw.burguer.modelo;

import java.util.Objects;


public class Ingrediente {

	
	private Long id;
	private String descripcion;
	private double peso;
	
	public Ingrediente() {}

	public Ingrediente(Long id, String descripcion, double peso) {
		this.descripcion = descripcion;
		this.peso = peso;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
	}

}
