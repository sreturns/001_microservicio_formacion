package com.sinensia.dto;

import java.util.Objects;

/**
 * Nuestra clase CursoDto que utilizamos para mapear el recurso que recibimos a
 * traves del microservicio de Curso
 *
 */
public class CursoDTO {

	private int codCurso;
	private String nombre;
	private int duracion;
	private int precio;

	public CursoDTO() {
	}

	/**
	 * 
	 * @param nombre
	 * @param duracion
	 * @param precio
	 */
	public CursoDTO(String nombre, int duracion, int precio) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codCurso, duracion, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoDTO other = (CursoDTO) obj;
		return codCurso == other.codCurso && duracion == other.duracion && Objects.equals(nombre, other.nombre)
				&& precio == other.precio;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
