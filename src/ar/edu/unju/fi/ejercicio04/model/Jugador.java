package ar.edu.unju.fi.ejercicio04.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private Float estatura;
	private Float peso;
	private Posicion posicion;
	
	
	
	public Integer calcularEdad() {
		Integer edad = 1;
		return edad;
	}


	

	public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, Float estatura,
			Float peso, Posicion posicion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}




	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre 
				+ ", apellido=" + apellido 
				+ ", fechaNacimiento=" + fechaNacimiento
				+ ", nacionalidad=" + nacionalidad 
				+ ", estatura=" + estatura 
				+ ", peso=" + peso 
				+ ", posicion=" + posicion + "]";
	}




	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}



	public Float getEstatura() {
		return estatura;
	}



	public void setEstatura(Float estatura) {
		this.estatura = estatura;
	}



	public Float getPeso() {
		return peso;
	}



	public void setPeso(Float peso) {
		this.peso = peso;
	}



	public Posicion getPosicion() {
		return posicion;
	}



	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	
}
