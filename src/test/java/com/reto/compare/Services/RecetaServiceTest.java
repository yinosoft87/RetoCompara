package com.reto.compare.Services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class RecetaServiceTest {
	
	RecetaService recetaService = new RecetaService();
	
	@Test
	void BuscarCoinsidentes_Encontrado_test() {
		List<String> lista1 = new ArrayList<String>();
		lista1.add("acido-ascorbico"); 
		lista1.add("paracetamol"); 
		lista1.add("cafeina");
		lista1.add("fenilefrina");
		lista1.add("ranitidina");
		lista1.add("paracetamol"); 
		
		List<String> lista2 = new ArrayList<String>();
		lista2.add("aspirina");
		lista2.add("paracetamol"); 
		lista2.add("naproxeno");
		lista2.add("cafeina");
	
		List<String> esperaba = new ArrayList<String>();
		esperaba.add("paracetamol"); 
		esperaba.add("cafeina");
		
		List<String> resultado = recetaService.BuscarCoinsidentes(lista1, lista2);
		
		assertEquals(esperaba, resultado);
	}
	
	@Test
	void BuscarCoinsidentes_NoEncontro_test() {
		List<String> lista1 = new ArrayList<String>();
		lista1.add("acido-ascorbico"); 
		lista1.add("paracetamol"); 
		lista1.add("cafeina");
		lista1.add("fenilefrina");
		lista1.add("ranitidina");
		
		List<String> lista2 = new ArrayList<String>();
		lista2.add("apidogril"); 
		lista2.add("saldeuvas");
		lista2.add("aspirina");
		lista2.add("naproxeno");
		
		List<String> resultado = recetaService.BuscarCoinsidentes(lista1, lista2);
		
		assertEquals(0, resultado.size());
	}
	
	@Test
	void BuscarEnLista_SiEncontro_test() {
		
		List<String> lista1 = new ArrayList<String>();
		lista1.add("aspirina");
		lista1.add("paracetamol"); 
		lista1.add("naproxeno");
		lista1.add("cafeina");
		
		int resultado = recetaService.BuscarEnLista("paracetamol", lista1);
		
		assertEquals(2, resultado);
	}
	
	@Test
	void BuscarEnLista_NoEncontro_test() {
		List<String> lista1 = new ArrayList<String>();
		lista1.add("acido-ascorbico"); 
		lista1.add("cafeina");
		lista1.add("paracetamol"); 
		lista1.add("fenilefrina");
		lista1.add("ranitidina");
		
		Integer resultado = recetaService.BuscarEnLista("genopraxol", lista1);
		
		assertEquals(0, resultado);
	}
	
	

}
