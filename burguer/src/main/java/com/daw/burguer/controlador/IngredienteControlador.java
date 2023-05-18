package com.daw.burguer.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.burguer.modelo.Ingrediente;
import com.daw.burguer.servicio.IngredienteServicioImpl;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteControlador {

	@Autowired
	private IngredienteServicioImpl ingredienteServicio;

	@GetMapping("/")
	public String listarIngredientes(Model modelo) {
		modelo.addAttribute("listaIngrediente", ingredienteServicio.getAll());
		return "ingrediente/listaIngrediente";
	}

	@GetMapping("/{id}")
	public String verIngrediente(@PathVariable(name = "id") Long id, Model modelo) {
		Ingrediente item = ingredienteServicio.getById(id);
		if (item == null)
			return "redirect:..";
		modelo.addAttribute("ingrediente", item);
		return "ingrediente/ver";
	}

	@GetMapping("/borrar/{id}")
	public String borrarPan(@PathVariable Long id) {
		Ingrediente ingrediente = ingredienteServicio.getById(id);
		ingredienteServicio.delete(ingrediente);
		return "redirect:/ingrediente/";
	}

	@GetMapping("/editar/{id}")
	public String editarIngrediente(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("ingrediente", ingredienteServicio.getById(id));
		return "ingrediente/editar";
	}

	@PostMapping("/editar/{id}")
	public String postEditar(@PathVariable Long id, @ModelAttribute("ingrediente") Ingrediente item, Model modelo) {
		Ingrediente ingrediente = ingredienteServicio.getById(id);
		ingrediente.setId(id);
		ingrediente.setDescripcion(item.getDescripcion());
		ingrediente.setPeso(item.getPeso());

		ingredienteServicio.update(ingrediente);
		return "redirect:/ingrediente/";
	}

	@GetMapping("/nuevo")
	public String añadirIngrediente(Model modelo) {
		Ingrediente ingrediente = new Ingrediente();
		modelo.addAttribute("ingrediente", ingrediente);
		return "ingrediente/nuevo";
	}

	@PostMapping("/nuevo")
	public String postAñadir(@ModelAttribute("ingrediente") Ingrediente item) {
		ingredienteServicio.create(item);
		return "redirect:/ingrediente/";
	}

}
