package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico domestico = new FelinoDomestico("Tanner",(byte) 5,3.5f);
		
		System.out.println(domestico+"\n\n");
	
		if(Converter.isNotNull(domestico)) {
			FelinoSalvaje salvaje = convertir.convert(domestico);
			convertir.mostrarObjeto(salvaje);
		}
		
	}
	
	static Converter<FelinoDomestico, FelinoSalvaje> convertir = f -> new FelinoSalvaje(f.getNombre(), f.getEdad(), f.getPeso());
}
