package com.sinensia.service;

import java.util.List;

import com.sinensia.model.Formacion;

/**
 * Interfaz que implementaremos en nuestra clase @Service
 * 
 *@see com.sinensia.service.FormacionServiceImpl
 */
public interface FormacionService {

	List<Formacion> getAll();

	List<Formacion> save(Formacion formacion);

}
