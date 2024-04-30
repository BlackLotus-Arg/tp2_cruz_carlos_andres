package ar.edu.unju.fi.ejercicio02.model;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;

public class Efemeride {
	private Integer codigo;
	private Mes mes;
	private Integer dia;
	private String detalle;
	
	
	
	
	
	@Override
	public String toString() {
		return "Efemeride [codigo=" + codigo + ", mes=" + mes + ", dia=" + dia + ", detalle=" + detalle + "]";
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	
	public Mes getMes() {
		return mes;
	}
	public void setMes(Mes mes) {
		this.mes = mes;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}	
}
