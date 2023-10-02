package com.sinensia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.model.Formacion;
import com.sinensia.service.FormacionService;

/**
 * RestController para realizar nuestros metodos Http
 * 
 * @author Sergio
 * @see com.sinensia.dto.CursoDTO
 * @see com.sinensia.service.FormacionServiceImpl
 * @see com.sinensia.service.FormacionService
 * @see com.sinensia.inicio.Application
 */
@RestController
public class FormacionController {

	/**
	 * Inyectamos nuestra interfaz del servicio
	 */
	@Autowired
	FormacionService service;

	/**
	 * 
	 * @return List<Formacion>
	 */
	@GetMapping(value = "formacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> getAll() {
		return service.getAll();
	}

	/**
	 * 
	 * @param formacion
	 * @return List<Formacion>
	 */
	@PostMapping(value = "formacion", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> save(@RequestBody Formacion formacion) {
		return service.save(formacion);
	}

}
