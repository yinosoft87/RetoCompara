package com.reto.compare.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.reto.compare.Models.*;

@Service
public class RecetaService {

	public CoinsidentesDeReceta IngredientesActivosCoinsidentes(DosRecetas dosRecetas) {
		List<String> Receta1Ingredientes = dosRecetas.getReceta1();
		List<String> Receta2Ingredientes = dosRecetas.getReceta2();

		CoinsidentesDeReceta oCoinsidentes = new CoinsidentesDeReceta();
		oCoinsidentes.setCoincidentes(BuscarCoinsidentes(Receta1Ingredientes, Receta2Ingredientes));
		return oCoinsidentes;
	}

	private List<String> BuscarCoinsidentes(List<String> Receta1Ingredientes, List<String> Receta2Ingredientes) {
		List<String> Coinsidentes = new ArrayList<String>();
		for (String ingredienteActivo : Receta1Ingredientes) {
			Integer indexEncontrado = BuscarEnLista(ingredienteActivo, Receta2Ingredientes);
			if (indexEncontrado > 0) {
				Coinsidentes.add(ingredienteActivo);
				Receta2Ingredientes.remove(indexEncontrado);
			}
		}
		return Coinsidentes;
	}

	private Integer BuscarEnLista(String buscar, List<String> list) {
		List<String> encrontrados = new ArrayList<String>();
		Integer indexEncontrado = 0;
		for (String elementoDeLista : list) {
			if (elementoDeLista.contains(buscar)) {
				encrontrados.add(elementoDeLista);
				indexEncontrado++;
			}
		}
		return indexEncontrado;
	}
}
