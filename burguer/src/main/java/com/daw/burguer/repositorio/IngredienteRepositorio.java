package com.daw.burguer.repositorio;

import java.util.List;


import com.daw.burguer.modelo.Ingrediente;

public interface IngredienteRepositorio {

	public List<Ingrediente> getAll();
	
	public Ingrediente getById(Long id);
	
	public void create(Ingrediente ingrediente);

	public Ingrediente update(Ingrediente ingrediente);

	public void delete(Ingrediente ingrediente);

}
