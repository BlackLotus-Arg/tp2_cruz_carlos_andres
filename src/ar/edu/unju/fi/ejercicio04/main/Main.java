package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;



public class Main {

		static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		static Scanner sc = new Scanner(System.in);
		public static void main(String[] args) {
			boolean flag = true;
			while(flag) {
				try {
					mostrarMenu();
					Integer option = sc.nextInt();
					
					switch (option) {
					case 1: {
						altaJugador();
						break;
					}case 2: {
						mostrarJugadores();
						break;
					}case 3: {
						cambiarPosicion();
						break;
					}case 4: {
						eliminarJugador();
						break;
					}case 5: {
						flag=false;
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + option);
					}
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("## error: "+e);
				}
				
			}
			System.out.println("Programa finalizado.");
		}
		
		public static void cambiarPosicion() {
			System.out.println("\n#### Alta de Jugador ####");
			System.out.println("Nombre:");
			String nombre = sc.next(); 
			
			System.out.println("Apellido:");
			String apellido = sc.next();
			
			boolean elJugadorExiste=false;
			
			jugadores.forEach(jugador->{
				if(jugador.getApellido().equals(apellido) && jugador.getNombre().equals(nombre)) {
					boolean flag=true;
					
					Posicion posicion;
					while(flag) {
						System.out.println("Seleccione la posicion (DELANTERO, MEDIO, DEFENSA, ARQUERO):");
						String posicionStr = sc.next();
						posicion = getPosicion(posicionStr);	
						
						if(posicion!=null) {
							jugador.setPosicion(posicion);
							flag=false;
						}
					}
				}
			});
			
			if(!elJugadorExiste) {
				System.out.println("\n## El jugador "+nombre+" "+apellido+" no existe. ##\n");
			}
		}
		
		public static void eliminarJugador() {
			System.out.println("\n#### Alta de Jugador ####");
			System.out.println("Nombre:");
			String nombre = sc.next(); 
			
			System.out.println("Apellido:");
			String apellido = sc.next();
			
			Iterator<Jugador> iterator = jugadores.listIterator();
			
			boolean elJugadorExiste=false;
			
			while(iterator.hasNext()) {
				Jugador jugador = iterator.next();
				if(jugador.getApellido().equals(apellido) && jugador.getNombre().equals(nombre)) {
					iterator.remove();
					elJugadorExiste=true;
					System.out.println("## El jugador "+nombre+" "+apellido+" fue eliminado. ##");
				}
			}
			
			if(!elJugadorExiste) {
				System.out.println("\n## El jugador "+nombre+" "+apellido+" no existe. ##\n");
			}
		}
		
		public static void modificarPosicion() {
			
		}
		
		public static void mostrarJugadores() {
			System.out.println("##################################");
			if(jugadores.isEmpty()) {
				System.out.println("No hay jugadores para mostrar.");
			}else {
				jugadores.forEach(jugador->System.out.println(jugador));
			}
			System.out.println("##################################");
			
		}
		
		public static LocalDate getDateFromString(String dateStr) {
			final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			try {
				return LocalDate.parse(dateStr, formatter);
			} catch (Exception e) {
				System.out.println("## Error: La fecha no se pudo formatear.");
				return null;
			}
		}
		
		public static Posicion getPosicion(String posicion) {
			try {
				return Posicion.valueOf(posicion);
			} catch (IllegalArgumentException  e) {
				System.out.println("## Error: El nombre no corresponde a un valor válido del enum.");
				return null;
			}
		}
		
		public static void altaJugador() {
			System.out.println("\n#### Alta de Jugador ####");
			boolean flag=true;
			try {
				System.out.println("Nombre:");
				String nombre = sc.next();
				System.out.println("Apellido:");
				String apellido = sc.next();
				
				LocalDate fecha = LocalDate.now();
				while(flag) {
					System.out.println("Fecha de Nacimiento (dd/mm/yyyy):");
					String fechaSTR = sc.next();
					fecha=getDateFromString(fechaSTR);
					if(fecha!=null) {
						flag=false;
					}
				}		
				
				System.out.println("Nacionalidad:");
				String nacionalidad = sc.next();
				System.out.println("estatura:");
				Float estatura = sc.nextFloat();
				System.out.println("peso:");
				Float peso = sc.nextFloat();
				
				flag=true;
				
				Posicion posicion=Posicion.ARQUERO;
				while(flag) {
					System.out.println("Seleccione la posicion (DELANTERO, MEDIO, DEFENSA, ARQUERO):");
					String posicionStr = sc.next();
					posicion = getPosicion(posicionStr);
					if(posicion!=null) {
						flag=false;
					}else {
						System.out.println("## debe ingresar la posicion en mayusculas y sin espacios, tal cual se muestra.");
					}
				}
				
				Jugador jugador = new Jugador(nombre, apellido, fecha, nacionalidad, estatura, peso, posicion);
				
				jugadores.add(jugador);
				
			} catch (Exception e) {
				System.out.println("## Error en alta: "+e);
			}
			
			
		}
		
		public static void mostrarMenu() {
			System.out.println(""" 
					1 – Alta de jugador
					2 – Mostrar todos los jugadores.
					3 – Modificar la posición de un jugador (el usuario debe ingresar el nombre y el apellido del 
					jugador)
					4 – Eliminar un jugador (el usuario debe ingresar el nombre y apellido. Utilice Iterator). 
					5 – Salir.
					Elija una opcion:
					""");
		}

	}

