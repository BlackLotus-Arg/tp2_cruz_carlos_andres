package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY(673307,53219),
	SALTA(1214441,155488),
	TUCUMAN(1448188,22524),
	CATAMARCA(367828,102602),
	LA_RIOJA(333642,89680),
	SANTIAGO_DEL_ESTERO(876006,136351);
	
	private final Integer poblacion;
	private final Integer superficie;
	
	private Provincia(Integer poblacion, Integer superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}
	
	
	
	public Integer getPoblacion() {
		return poblacion;
	}
	public Integer getSuperficie() {
		return superficie;
	}
	public Float densidadDePoblacion() {
		return Float.valueOf(poblacion)/superficie;
	}
}
