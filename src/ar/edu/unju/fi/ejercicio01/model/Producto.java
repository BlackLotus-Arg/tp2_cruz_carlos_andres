package ar.edu.unju.fi.ejercicio01.model;

public class Producto {
	private Integer codigo;
	private String descripcion;
	private Float precioUni;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
	
	
	public enum OrigenFabricacion {
			ARGENTINA,
			CHINA,
			BRASIL,
			URUGUAY
	};
	public enum Categoria {
		TELEFONIA,
		INFORMATICA,
		ELECTROHOGAR,
		HERRAMIENTAS
	}
	
	
	
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUni=" + precioUni
				+ ", origenFabricacion=" + origenFabricacion + ", categoria=" + categoria + "]";
	}

	public Producto() {
		
	}
	
	public Producto(Integer codigo, String descripcion, Float precioUni,
			ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion origenFabricacion,
			ar.edu.unju.fi.ejercicio01.model.Producto.Categoria categoria) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUni = precioUni;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Float getPrecioUni() {
		return precioUni;
	}
	public void setPrecioUni(Float precioUni) {
		this.precioUni = precioUni;
	}
	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}
	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	};
	
	
	
}
