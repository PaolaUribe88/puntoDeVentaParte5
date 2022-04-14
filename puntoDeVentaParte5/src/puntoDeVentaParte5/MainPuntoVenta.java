package puntoDeVentaParte5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
	/**
	 * 
	 * @author Jessie Uribe
	 *
	 */

	public class MainPuntoVenta {

		static ArrayList<Producto> productos = new ArrayList<>();
		static Scanner scanner = new Scanner(System.in);
		private static final int MENU_AGREGAR_PRODUCTO = 1;
		private static final int MENU_VER_PRODUCTO = 2;
		private static final int MENU_SALIR = 0;
				
		public static void main(String[] args) {
			menu();

		}

		private static void menu() {
			int opcion = 1;
			do {
				
				System.out.println("[1.] Agregar producto");
				System.out.println("[2.] Ver lista de productos");
				System.out.println("[0.] Salir");
				System.out.println("[Elija una opcion :]");
				
				opcion = scanner.nextInt();
				
				switch(opcion) {
					case MENU_AGREGAR_PRODUCTO:
						agregarProductos();
						break;
					case MENU_VER_PRODUCTO:
						verProductos();
						break;
					case MENU_SALIR:
						break;
				}
				
			}while(opcion != MENU_SALIR);
			
		}

		private static void agregarProductos() {
			scanner.nextLine();
			
			System.out.println("Ingrese Codigo del producto");
			String codigo = scanner.nextLine();
			System.out.println("Ingrese Nombre del producto");
			String nombre = scanner.nextLine();
			System.out.println("Ingrese Categoria del producto");
			String categoria = scanner.nextLine();
			System.out.println("Ingrese Precio del producto");
			int precio= scanner.nextInt();
			scanner.nextLine();
			System.out.println("Ingrese Descripcion del producto");
			String descripcion = scanner.nextLine();
			
			Producto producto = new Producto(codigo,nombre,precio,categoria,descripcion);
			productos.add(producto);
			
			System.out.printf("Se añadio el producto '%s' de la categoria '%s' con un precio de '%d' . Su descripcion es '%s' %n.",
					producto.getCodigo(),
					producto.getNombre(),
					producto.getPrecio(),
					producto.getCategoria(),
					producto.getDescripcion());
		}

		private static void verProductos() {
			System.out.println("Lista de productos");
			System.out.println("==========================");
			for(Producto producto : productos) {
				System.out.printf(" Nombre producto: %s %n Categoria producto: %s %n Descripcion producto: %s %n Precio producto: %d %n",
						producto.getNombre(),
						producto.getCategoria(),
						producto.getDescripcion(),
						producto.getPrecio());
			}
			
		}

	 
	    private static String generarContenidoArchivosCSV(){
		        String cabeceraCsv      = "CODIGO, PRODUCTO, VALOR";
		        String contenidoArchivo = cabeceraCsv + "\n";
		        contenidoArchivo += "ch1, Chicle Menta, 200, Golosinas, Menta Fresca \n";
		        contenidoArchivo += "ch2, Chicle Fruta, 200, Golosinas, Frutos Rojos \n";
		        contenidoArchivo += "ch3, Cafe Nescafe 280 g, 2200, Cafeteria, Dolca menos fuerte \n";
		        // abreviaciÃ³n de esto:
		       //contenidoArchivo = contenidoArchivo + "\n";
		       contenidoArchivo += "ch4, Azucar, 1300, Cafeteria, Rubia\n";
		       return contenidoArchivo;
		      }
	}
