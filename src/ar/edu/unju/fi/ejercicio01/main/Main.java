package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;


public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public static void main(String[] args) {

		boolean flag = true;
		while(flag) {
			try {
				showMenu();
				Integer option = sc.nextInt();
				
				switch (option) {
				case 1: {
					crearProducto();
					break;
				}
				case 2: {
					mostrarProducto();
					break;
				}
				case 3:{
					ModificarProducto();
					break;
				}
				case 4:{
					System.out.println("Programa finalizado.");
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + option);
				}
				
				flag=option==4?false:true;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println(e);

			}	
		}
		sc.close();
	}
	
	public static void ModificarProducto() {
		try {
			System.out.println("\n---- Modificar Producto ------");
			
			System.out.println("codigo de producto a modificar: ");
			Integer codigo = sc.nextInt();
			

			for(Producto p:productos) {
				if(p.getCodigo()==codigo) {
					setProductProps(p);
					break;
				}else {
					throw new Exception("El producto con ese codigo no existe!");
				}
			}
			
			
			
		} catch (Exception e) {
			System.out.println("## Error: "+e);
		}
		
		
	}
	
	public static void mostrarProducto() {
		System.out.println("\n################################");
		if(productos.isEmpty()) {
			System.out.println("La lista no contine productos.");
		}else {
			for(Producto p:productos) {
				System.out.println(p);
			}
		}
		System.out.println("################################\n");
	}
	
	public static void setProductProps(Producto producto) {
		boolean flag=true;
		System.out.println("Descripcion:");
		String descripcion = sc.next();
		
		System.out.println("Precio Unitario:");
		Float precio = sc.nextFloat();
		
		Integer origen = 0;
		while(flag) {	
			mostrarMenuOrigenFabricacion();
			origen = sc.nextInt();
			if(origen>=1 && origen<=4) {
				flag=false;
			}
		}
		flag=true;
		Integer categoria = 0;
		while(flag) {
			mostrarMenuCategoria();
			categoria = sc.nextInt();
			if(categoria>=1 && categoria<=4) {
				flag=false;
			}	
		}
		
		producto.setDescripcion(descripcion);
		producto.setPrecioUni(precio);
		switch (origen) {
			case 1: {
				producto.setOrigenFabricacion(Producto.OrigenFabricacion.ARGENTINA);
				break;
			}case 2:{
				producto.setOrigenFabricacion(Producto.OrigenFabricacion.CHINA);
				break;
			}case 3:{
				producto.setOrigenFabricacion(Producto.OrigenFabricacion.BRASIL);
				break;
			}case 4:{
				producto.setOrigenFabricacion(Producto.OrigenFabricacion.URUGUAY);
				break;
			}
		}
		switch (categoria) {
		case 1: {
			producto.setCategoria(Producto.Categoria.TELEFONIA);
			break;
		}case 2:{
			producto.setCategoria(Producto.Categoria.INFORMATICA);
			break;
		}case 3:{
			producto.setCategoria(Producto.Categoria.ELECTROHOGAR);
			break;
		}case 4:{
			producto.setCategoria(Producto.Categoria.HERRAMIENTAS);
			break;
		}	
	}	

	}
	
	public static void crearProducto() {
		try {
			
			System.out.println("\n---- Alta de Producto ------");
			
			System.out.println("Codigo:");
			Integer codigo = sc.nextInt();
			
			
			Producto producto = new Producto();
			
			producto.setCodigo(codigo);
			
			setProductProps(producto);
		
			productos.add(producto);
			
		} catch (Exception e) {
			sc.nextLine();
			System.out.println("## Error : "+e);
		}	
	}
	
	public static void mostrarMenuOrigenFabricacion() {
		System.out.println("""
				\n---- Origen de fabricación ------
				1 - Argentina
				2 - China
				3 - Brasil
				4 – Uruguay
				Elija una opción: 
				""");
		
	}
	
	public static void mostrarMenuCategoria() {
		System.out.println("""
				\n------ Categoría ------
				1 – Telefonía
				2 – Informática
				3 – Electro hogar
				4 – Herramientas
				Elija una opción:
				""");
	}
	
	public static void showMenu() {
		System.out.println("""
				\nElija una opcion:
				1 - Crear Producto
				2 - Mostrar productos
				3 - Modificar Productos (sólo puede modificar: descripció unitario, origen o categoria)
				4 - Salir
				""");
	}

}
