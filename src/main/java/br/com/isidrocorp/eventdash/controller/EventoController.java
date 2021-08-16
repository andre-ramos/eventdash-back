package br.com.isidrocorp.eventdash.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.eventdash.dao.EventoDAO;
import br.com.isidrocorp.eventdash.model.Evento;

@RestController
public class EventoController {
	
	@Autowired
	private EventoDAO dao;
	
	@GetMapping("/eventos")
	public ArrayList<Evento> recuperarTodos(@RequestParam(name="inicio") String inicio, @RequestParam(name="fim") String fim){
		ArrayList<Evento> lista;
		LocalDate dinicio = LocalDate.parse(inicio);
		LocalDate dfim = LocalDate.parse(fim);
		
		lista = dao.findAllByDataEventoBetween(dinicio, dfim);
		return lista;
	}
	

}
