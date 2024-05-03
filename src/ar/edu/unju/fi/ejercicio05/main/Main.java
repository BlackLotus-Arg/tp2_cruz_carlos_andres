package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<miProducto> productos = new ArrayList<>();
	static ArrayList<miProducto> compras = new ArrayList<>();

	public static void main(String[] args) {
		
		instanciarProductos();
		
		boolean flag = true;

		while (flag) {
			System.out.println(menuPrincipal.get());
			
			Integer opcion = sc.nextInt();

			switch (opcion) {
			case 1: {
				productos.forEach(producto -> System.out.println(producto));
				break;
			}
			case 2: {
				realizarCompra();
				break;
			}
			case 3: {
				flag=false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
		}
		System.out.println("Programa finalizado.");
		sc.close();
	}
	
	public static void instanciarProductos() {
		productos.add(
				new miProducto(1, "Licuadora", 13300.3f, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
		productos.add(new miProducto(2, "Cafetera", 11200.3f, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
		productos.add(
				new miProducto(3, "Television", 766100.3f, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, false));
		productos.add(new miProducto(4, "Play Station 5", 1316100.3f, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR,
				true));
		productos.add(
				new miProducto(5, "Heladera", 341500.3f, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, false));

		productos.add(new miProducto(6, "Taladro", 275422.3f, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, false));
		productos.add(new miProducto(7, "Amoladora", 312444.3f, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, true));
		productos.add(
				new miProducto(8, "Hidrolavadora", 435200.3f, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
		productos.add(
				new miProducto(9, "Amperimetro", 134200.3f, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, true));
		productos.add(new miProducto(10, "Motosierra", 398700.3f, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS,
				false));

		productos.add(
				new miProducto(11, "Laptop Lenovo", 745100.3f, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		productos.add(new miProducto(12, "GeForce RTX 2060", 1644066.3f, OrigenFabricacion.CHINA, Categoria.INFORMATICA,
				false));
		productos.add(
				new miProducto(13, "Radeon RX580", 1124000.3f, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false));
		productos.add(
				new miProducto(14, "Radeon RX580", 1204000.3f, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false));
		productos.add(new miProducto(15, "Procesador Ryzen 9", 1654300.3f, OrigenFabricacion.CHINA,
				Categoria.INFORMATICA, false));
	}

	public static void realizarCompra() {
		System.out.println("\n### Realizar Compra ###");
		boolean flag = true;
		while (flag) {

			int codigo = obtenerCodigoPorConsola();

			for (miProducto p : productos) {
				if (p.getCodigo() == codigo) {
					if (p.isEstado()) {
						compras.add(p);
						
						System.out.println("\n" + p.getDescripcion() + " agregado exitosamente.");
						
						continuarCompra(flag);
						
					} else {
						System.out.println("\nEl producto no esta en Stock.");
						
						continuarCompra(flag);
						
						int metodoDePago = setOpcionesDePago();
						
						Double montoTotal = 0.0;
						for(miProducto c:compras) {
							montoTotal+=c.getPrecioUni();
						}
						
						LocalDate fechaCompra = LocalDate.now();
						
						switch (metodoDePago) {
						case 1: {
							PagoEfectivo pagoEfectivo = new PagoEfectivo(fechaCompra, montoTotal);
							pagoEfectivo.imprimirRecibo();
							break;
						}
						case 2: {
							System.out.println("Ingrese el numero de tarjeta.");
							String numTarjeta = sc.next();
							PagoTarjeta pagoTarjeta = new PagoTarjeta(numTarjeta, fechaCompra, montoTotal);
							pagoTarjeta.imprimirRecibo();
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + metodoDePago);
						}
					}
				}
			}
		}
	}
	
	static int setOpcionesDePago() {
			while (true) {
				try {
					System.out.println("""
							1 – Pago efectivo
							2- Pago con tarjeta.
							Seleccione el metodo de pago.
							""");
					int codigo = sc.nextInt();
					if (1 <= codigo && codigo <= 2) {
						return codigo;
					} else {
						System.out.println("\n### Codigo no valido ###");
					}
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("## Error en codigo metodo de Pago: " + e + "\n");
				}
			}

	}
	
	static void continuarCompra(boolean flag) {
		mostrarCarroDeCompras();
		
		System.out.println("\nsi desea continuar ingrese S, sino ingrese cualquier tecla");
		
		String res = sc.next();
		
		flag=res.toUpperCase().equals("S")?true:false;
		
	}
	
	static void mostrarCarroDeCompras() {
		System.out.println("Carro de Compras: ");
		compras.forEach(c->System.out.println(c.getDescripcion()+" $"+c.getPrecioUni()));
	}

	static int obtenerCodigoPorConsola() {
		
		while (true) {
			try {
				System.out.println("ingrese el codigo del producto");
				int codigo = sc.nextInt();
				if (1 <= codigo && codigo <= 15) {
					return codigo;
				} else {
					System.out.println("\n### Codigo no valido ###");
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("## Error en codigo de producto: " + e + "\n");
			}
		}
	}

	static Supplier<String> menuPrincipal = () -> "\n1 – Mostrar productos " + "\n2 – Realizar compra" + "\n3 – Salir"
			+ "\nSeleccione una opcion:";

	
	
	static public class miProducto extends Producto {

		private boolean estado;

		public miProducto(Integer codigo, String descripcion, Float precioUni, OrigenFabricacion origenFabricacion,
				Categoria categoria, boolean estado) {
			super(codigo, descripcion, precioUni, origenFabricacion, categoria);

			this.estado = estado;
		}

		@Override
		public String toString() {
			return "\nCodigo: " + super.getCodigo() + "\n  Nombre: " + super.getDescripcion() + "\n  Categoria: "
					+ super.getCategoria() + "\n  Origen: " + super.getOrigenFabricacion() + "\n  Precio Un. "
					+ super.getPrecioUni() + "\n  En Stock: " + estado;
		}

		public miProducto(boolean estado) {
			super();
			this.estado = estado;
		}

		public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}

	}

}
