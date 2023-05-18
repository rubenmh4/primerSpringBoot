package com.daw.burguer.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.burguer.modelo.Ingrediente;
import com.daw.burguer.repositorio.IngredienteRepositorio;

@Service
public class IngredienteServicioImpl {

	@Autowired
	private IngredienteRepositorio repositorioIn;
	
	
	public IngredienteServicioImpl(IngredienteRepositorio ingredienteRepositorio ) {
		repositorioIn = ingredienteRepositorio;
	}
	
	public List<Ingrediente> getAll() {
		return this.repositorioIn.getAll();
	}

	public Ingrediente getById(Long id) {
		return this.repositorioIn.getById(id);
	}

	public void create(Ingrediente ingrediente) {
		this.repositorioIn.create(ingrediente);
	}

	public Ingrediente update(Ingrediente ingrediente) {
		return this.repositorioIn.update(ingrediente);
	}

	public void delete(Ingrediente ingrediente) {
		this.repositorioIn.delete(ingrediente);
	}

	public void deleteById(Long id) {
		this.repositorioIn.delete(this.repositorioIn.getById(id));
	}

	
	
}
