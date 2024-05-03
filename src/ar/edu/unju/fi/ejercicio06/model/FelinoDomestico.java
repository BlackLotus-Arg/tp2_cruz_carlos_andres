package ar.edu.unju.fi.ejercicio06.model;

public class FelinoDomestico {
	private String nombre;
	private Byte edad;
	private Float peso;
	
	
	
	@Override
	public String toString() {
		return "FelinoDomestico [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}
	public FelinoDomestico(String nombre, Byte edad, Float peso) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Byte getEdad() {
		return edad;
	}
	public void setEdad(Byte edad) {
		this.edad = edad;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	
	
}
