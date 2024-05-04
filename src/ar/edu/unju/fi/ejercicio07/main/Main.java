package ar.edu.unju.fi.ejercicio07.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Comparator;

import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio05.main.Main.miProducto;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		ArrayList<miProducto> productos = new ArrayList<>();
		
		cargarLista.accept(productos);
		
		boolean flag = true;
		while(flag) {
			System.out.println(menuPrincipal.get());
			Integer option=0;
			try {
				option = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Error al ingresar opcion en menu principal: "+e);
			}
			
			switch (option) {
			
			case 1:
				System.out.println("#### PRODUCTOS EN STOCK ####");
				mostrarProductos.accept(productos, true);
				break; 
				
			case 2:
				
				System.out.println("#### PRODUCTOS SIN STOCK ####");
				mostrarProductos.accept(productos, false);
				break; 
			case 3:
				
				ArrayList<miProducto> productosIncrementados = (ArrayList<miProducto>) productos.stream()
						.map(incrementarPrecio)
						.collect(Collectors.toList());
				
				System.out.println("#### PRECIOS AUMENTADOS ####");
				productosIncrementados.forEach(System.out::println);
				break; 
				
			case 4:
				
				System.out.println("#### PRODUCTOS DE ELECTROHOGAR EN STOCK ####");
				productos.stream()
				.filter(electroHogarEnStock)
				.forEach(System.out::println);;
				break; 
				
			case 5:
				
				System.out.println("#### PRODUCTOS ORDENADOS POR PRECIO ASC ####");
				productos.sort(ordenarPorPrecio);
				productos.stream().forEach(System.out::println);
				break; 
				
			case 6:
				
				System.out.println("#### PRODUCTOS CON NOMBRES EN MAYUSCULAS ####");
				productos.stream()
				.map(nombreMayusculas)
				.forEach(System.out::println);
				break; 
				
			case 7:
				flag = false;
				break;
			default:
				throw new IllegalArgumentException();
			}
		}
		System.out.println("#### PROGRAMA FINALIZADO ####");
		sc.close();
	}
	
	static Comparator<miProducto> ordenarPorPrecio = (p1,p2)->Float.compare(p2.getPrecioUni(), p1.getPrecioUni());
	
	static Function<miProducto, miProducto> nombreMayusculas = p ->{
		p.setDescripcion(p.getDescripcion().toUpperCase());
		return p;
	};
	
	static Predicate<miProducto> electroHogarEnStock = p -> p.isEstado() && (p.getCategoria().equals(Categoria.ELECTROHOGAR));
		
	static Function<miProducto, miProducto> incrementarPrecio = p-> {
		Float nuevoPrecio=p.getPrecioUni()*1.2f;
		p.setPrecioUni(nuevoPrecio);
		return p;
	};
	
	static BiConsumer<ArrayList<miProducto>,Boolean> mostrarProductos = (prods, bool)->{
		prods.stream()
		.filter(p->p.isEstado()==bool)
		.forEach(p->System.out.println(p));
	};
	
	static Supplier<String> menuPrincipal = ()->"""
			\n#### MENU PRINCIPAL ####
			1 – Mostrar miProductos (solo se muestran los miProductos con estado true).
			2 – Mostrar los miProductos faltantes (muestra miProductos con estado false)
			3 – Incrementar los precios de los miProductos en un 20%
			4 – Mostrar los miProductos que corresponden a la categoría Electrohogar y estén disponibles para la venta.
			5 – Ordenar los miProductos por precio de forma descendente.
			6 - Mostrar los miProductos con los nombres en mayúsculas. 
			7 - Salir.
			"""
	;
	
	static Consumer<ArrayList<miProducto>> cargarLista = prods -> {
		prods.add(new miProducto(1, "Licuadora", 13300.3f, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR,true));
		prods.add(new miProducto(2, "Cafetera", 11200.3f, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR,true));
		prods.add(new miProducto(3, "Television", 766100.3f, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR,false));
		prods.add(new miProducto(4, "Play Station 5", 1316100.3f, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR,false));
		prods.add(new miProducto(5, "Heladera", 341500.3f, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR,true));
		prods.add(new miProducto(6, "Taladro", 275422.3f, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS,false));
		prods.add(new miProducto(7, "Amoladora", 312444.3f, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS,false));
		prods.add(new miProducto(8, "Hidrolavadora", 435200.3f, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS,false));
		prods.add(new miProducto(9, "Amperimetro", 134200.3f, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS,true));
		prods.add(new miProducto(10, "Motosierra", 398700.3f, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS,false));
		prods.add(new miProducto(11, "Laptop Lenovo", 745100.3f, OrigenFabricacion.CHINA, Categoria.INFORMATICA,true));
		prods.add(new miProducto(12, "GeForce RTX 2060", 1644066.3f, OrigenFabricacion.CHINA, Categoria.INFORMATICA,false));
		prods.add(new miProducto(13, "Radeon RX580", 1124000.3f, OrigenFabricacion.CHINA, Categoria.INFORMATICA,true));
		prods.add(new miProducto(14, "Radeon RX580", 1204000.3f, OrigenFabricacion.CHINA, Categoria.INFORMATICA,true));
		prods.add(new miProducto(15, "Procesador Ryzen 9", 1654300.3f, OrigenFabricacion.CHINA,Categoria.INFORMATICA,true));
	};
}
