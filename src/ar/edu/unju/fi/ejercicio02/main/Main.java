package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {
	static ArrayList<Efemeride> efemerides = new ArrayList<Efemeride>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean flag = true;
		
		while(flag) {
			mostrarMenu();
			Integer opcion = sc.nextInt();
			switch (opcion) {
			case 1: 
				altaEfemeride();
				break;
			case 2:
				mostrarEfemerides();
				break;
			case 3:
				eliminarEfemeride();
				break;
			case 4:
				modificarEfemeride();
				break;
			case 5:
				System.out.println("Programa finalizado.");
				break;
			default:
				throw new IllegalArgumentException("Unexpected: " + opcion);
			}
		}
	}
	
	public static void modificarEfemeride() {
		System.out.println("\nIngrese el codigo de la efemeride a modificar:");
		Integer codigo = sc.nextInt();
		
		for(Efemeride e:efemerides) {
			if(e.getCodigo()==codigo) {
				setEfemeride(e);
			}else {
				System.out.println("No existe efemeride con ese codigo!!");
			}
		}
	}
	
	public static void eliminarEfemeride() {
		System.out.println("\nIngrese el codigo de la efemeride a eliminar:");
		Integer codigo = sc.nextInt();
		efemerides.removeIf(e->e.getCodigo()==codigo);
	}
	
	public static void mostrarEfemerides() {
		System.out.println("\n##############################");
		if(efemerides.isEmpty()) {
			System.out.println("El array no contiene Efemerides!!");
		}else {
			efemerides.forEach(e->System.out.println(e));
		}
		System.out.println("##############################\n");	
		
	}
	
	public static void altaEfemeride() {
		Efemeride efemeride = new Efemeride();
		setEfemeride(efemeride);
		efemerides.add(efemeride);
	}
	
	public static void setEfemeride(Efemeride efemeride) {
		try {
			System.out.println("\n#### Crear Efemeride ####");
			
			System.out.println("codigo:");
			Integer codigo = sc.nextInt();
			
			Integer mes=0;
			boolean flag = true;
			while(flag) {
				System.out.println("Numero del mes [1,12]:");
				mes = sc.nextInt();
				if(1<=mes && mes<=12) {
					flag=false;
				}else {
					System.out.println("\n ## valor no valido!!## \n");
				}
			}
			
			Integer dia=0;
			flag=true;
			while(flag) {
				System.out.println("dia:");
				dia = sc.nextInt();
				if(1<=dia && dia<=31) {
					flag=false;
				}else {
					System.out.println("\n ## valor no valido!!## \n");
				}
			}
			
			System.out.println("detalle:");
			String detalle = sc.next();
			
			efemeride.setCodigo(codigo);
			efemeride.setDia(dia);
			efemeride.setDetalle(detalle);
			switch (mes) {
			case 1: 
				efemeride.setMes(Mes.ENERO);
				break;
			case 2:
				efemeride.setMes(Mes.FEBRERO);
				break;
			case 3:
				efemeride.setMes(Mes.MARZO);
				break;
			case 4:
				efemeride.setMes(Mes.ABRIL);
				break;
			case 5:
				efemeride.setMes(Mes.MAYO);
				break;
			case 6:
				efemeride.setMes(Mes.JUNIO);
				break;
			case 7:
				efemeride.setMes(Mes.JULIO);
				break;
			case 8:
				efemeride.setMes(Mes.AGOSTO);
				break;
			case 9:
				efemeride.setMes(Mes.SEPTIEMBRE);
				break;
			case 10:
				efemeride.setMes(Mes.OCTUBRE);
				break;
			case 11:
				efemeride.setMes(Mes.NOVIEMBRE);
				break;
			case 12:
				efemeride.setMes(Mes.DICIEMBRE);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + mes);
			}
			
		} catch (Exception e) {
			System.out.println("### Error: "+e);
		}
	}
	
	
	public static void mostrarMenu(){
		System.out.println("""
				\n1 – Crear efeméride
				2 – Mostrar efemérides
				3 – Eliminar efeméride
				4 – Modificar efeméride
				5 – Salir.
				ingrese una opcion:
				""");
	}
}
