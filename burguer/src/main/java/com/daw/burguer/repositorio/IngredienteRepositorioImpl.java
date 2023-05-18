package com.daw.burguer.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.daw.burguer.modelo.Ingrediente;

import jakarta.annotation.PostConstruct;

@Qualifier("memoria")
@Repository
public class IngredienteRepositorioImpl implements IngredienteRepositorio {

	List<Ingrediente> listaIngredientes;

	
	
	@PostConstruct
	void init() {
		listaIngredientes = new ArrayList<>();
		listaIngredientes.add(new Ingrediente(1L, "Sésamo", 2.3));
		listaIngredientes.add(new Ingrediente(2L ,"Chapata", 1.2));
		listaIngredientes.add(new Ingrediente(3L ,"Cristal", 4.0));
		listaIngredientes.add(new Ingrediente(4L ,"Maíz", 1.5));
	}
	
	@Override
	public List<Ingrediente> getAll() {
		return listaIngredientes;
	}

	@Override
	public Ingrediente getById(Long id) {
		return listaIngredientes.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

	}

	@Override
	public void create(Ingrediente ingrediente) {
		if (getById(ingrediente.getId()) == null)
			listaIngredientes.add(ingrediente);	}

	@Override
	public Ingrediente update(Ingrediente ingrediente) {
		int posicion = listaIngredientes.indexOf(ingrediente);
		if (posicion >= 0) {
			listaIngredientes.set(posicion, ingrediente);
			return ingrediente;
		}
		return null;
	}

	@Override
	public void delete(Ingrediente ingrediente) {
		listaIngredientes.remove(ingrediente);
	}

}
