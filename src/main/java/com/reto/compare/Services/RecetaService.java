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

	public List<String> BuscarCoinsidentes(List<String> Receta1Ingredientes,List<String> Receta2Ingredientes) {
		List<String> Coinsidentes = new ArrayList<String>();
		for (String ingredienteActivo : Receta1Ingredientes) {
			if (BuscarEnLista(ingredienteActivo, Receta2Ingredientes) > 0) {
				Coinsidentes.add(ingredienteActivo);
				Receta2Ingredientes.remove(ingredienteActivo);
			}
		}
		return Coinsidentes;
	}

	public int BuscarEnLista(String buscar, List<String> list) {
		int indexEncontrado = 0;
		for (String elementoDeLista : list) {
			indexEncontrado++;
			if (elementoDeLista.contains(buscar)) {
				return indexEncontrado;
			}
		}
		return 0;
	}
}
