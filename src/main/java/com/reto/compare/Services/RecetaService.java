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

	public List<String> BuscarCoinsidentes(List<String> Receta1Ingredientes, List<String> Receta2Ingredientes) {
		List<String> Coinsidentes = new ArrayList<String>();
		// Recorrer el list de ingredientes activos de receta 1
		for (String ingredienteActivo : Receta1Ingredientes) {
			//obtenemos el index encontrado de la lista de ingredientes activos de receta 2
			Integer indexEncontrado = BuscarEnLista(ingredienteActivo, Receta2Ingredientes);
			//si el index es mayor a 0 se encontro un ingrediente activo que coinside
			if (indexEncontrado > 0) {
				//agregamos a la lista de coinsidentes
				Coinsidentes.add(ingredienteActivo);
				//eliminamos de la lista de la segunda receta para no repetirlo
				Receta2Ingredientes.remove(indexEncontrado);
			}
		}
		// regresamos la lista de ingredientes activos que coinsiden de las 2 recetas
		return Coinsidentes;
	}

	public Integer BuscarEnLista(String buscar, List<String> list) {
		Integer indexEncontrado = 0;
		for (String elementoDeLista : list) {
			indexEncontrado++;
			if (elementoDeLista.contains(buscar)) {
				return indexEncontrado;
			}
		}
		return 0;
	}
}
