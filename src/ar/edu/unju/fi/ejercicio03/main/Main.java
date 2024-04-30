package ar.edu.unju.fi.ejercicio03.main;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		
		Provincia[] provincias = Provincia.values();
		
		
		
		for(Provincia p:provincias) {
			System.out.println(p.densidadDePoblacion());
			
			System.out.println("""
					Provincia: %s
					--Poblacion: %s 
					--Superficie: %s
					--Densidad poblacional: %.2f
					""".formatted(
							p,
							p.getPoblacion(),
							p.getSuperficie(),
							p.densidadDePoblacion()
					));
		}
	}

}
