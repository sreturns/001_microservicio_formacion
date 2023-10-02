package com.sinensia.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sinensia.dto.CursoDTO;
import com.sinensia.model.Formacion;

/**
 * Clase servicio que implementa los metodos de nuestra interfaz, utilizamos el
 * CursoDto para mapear el recurso de Curso
 *
 * @see com.sinensia.dto.CursoDTO
 * @see com.sinensia.controller.FormacionController
 * @see com.sinensia.service.FormacionService
 */
@Service
public class FormacionServiceImpl implements FormacionService {

	/**
	 * Inyectamos el Restamplate configurado en la clase de configuracion
	 * Application.java
	 */
	@Autowired
	RestTemplate template;

	private final String URL_MICROSERVICIO_CURSOS = "http://localhost:8080/curso";

	/**
	 * Devolvemos la lista en formato del objeto Formacio, mapeandolo a traves de
	 * CursoDto
	 * 
	 * @return List<Formacio>
	 */
	@Override
	public List<Formacion> getAll() {
		List<CursoDTO> list = Arrays.asList(template.getForObject(URL_MICROSERVICIO_CURSOS, CursoDTO[].class));

		// Mapeamos
		List<Formacion> listaFormacion = list.stream().map(cursoDTO -> {
			Formacion formacion = new Formacion();
			formacion.setCurso(cursoDTO.getNombre());
			formacion.setAsignaturas(calculate(cursoDTO.getDuracion()));
			formacion.setPrecio(cursoDTO.getPrecio());
			return formacion;
		}).collect(Collectors.toList());

		return listaFormacion;
	}

	/**
	 * Guardamos el recurso formacion mapeandolo a traves del CursoDto
	 * 
	 * @param formacion
	 * @return List<Formacion>
	 */
	@Override
	public List<Formacion> save(Formacion formacion) {
		int duracion = calculateDuration(formacion.getAsignaturas());

		CursoDTO curso = new CursoDTO(formacion.getCurso(), duracion, formacion.getPrecio());

		template.postForLocation(URL_MICROSERVICIO_CURSOS, curso);

		List<CursoDTO> list = Arrays.asList(template.getForObject(URL_MICROSERVICIO_CURSOS, CursoDTO[].class));

		List<Formacion> listaFormacion2 = list.stream().map(cursoDTO -> {
			Formacion formacion2 = new Formacion();
			formacion2.setCurso(cursoDTO.getNombre());
			formacion2.setAsignaturas(calculate(cursoDTO.getDuracion()));
			formacion2.setPrecio(cursoDTO.getPrecio());
			return formacion2;
		}).collect(Collectors.toList());
		return listaFormacion2;

	}

	/**
	 * Metodo para calcular el numero de asignaturas
	 * 
	 * @param duracion
	 * @return int
	 */
	private int calculate(int duracion) {
		return (duracion >= 50) ? 10 : 5;
	}

	/**
	 * Metodo para calcular la duracion del curso
	 * 
	 * @param asignaturas
	 * @return asiganturas
	 */
	private int calculateDuration(int asignaturas) {
		return asignaturas * 10;
	}

}
