package com.sinensia.model;

import java.util.Objects;

/**
 * 
 * @see com.sinensia.controller.FormacionController
 * @see com.sinensia.service.FormacionService
 * @see com.sinensia.service.FormacionServiceImpl
 */
public class Formacion {

	private String curso;
	private int asignaturas;
	private int precio;

	public Formacion() {
	}

	/**
	 * 
	 * @param curso
	 * @param asignaturas
	 * @param precio
	 */
	public Formacion(String curso, int asignaturas, int precio) {
		this.curso = curso;
		this.asignaturas = asignaturas;
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asignaturas, curso, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formacion other = (Formacion) obj;
		return asignaturas == other.asignaturas && Objects.equals(curso, other.curso) && precio == other.precio;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(int asignaturas) {
		this.asignaturas = asignaturas;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
