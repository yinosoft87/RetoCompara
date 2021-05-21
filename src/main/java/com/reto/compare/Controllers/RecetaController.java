package com.reto.compare.Controllers;

import com.reto.compare.Models.*;
import com.reto.compare.Services.RecetaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecetaController {
	@Autowired
	RecetaService recetaService;

	@RequestMapping(value = "/compara", method = RequestMethod.POST, consumes = "application/json")
	public CoinsidentesDeReceta compararRecetas(@RequestBody DosRecetas recetas) {
		return recetaService.IngredientesActivosCoinsidentes(recetas);
	}

}
