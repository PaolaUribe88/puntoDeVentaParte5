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

		private static ArrayList<Producto> productos = new ArrayList<Producto>();
		private static ArrayList<Venta> ventas= new ArrayList<Venta>();
		//productos en el objeto del array
		
		//constantes
		public final static int OPCION_MENU_SALIR = 0;//Constante
		public final static int OPCION_MENU_VENTAS = 7;//Constante
		public final static int OPCION_MENU_CARGA_PRODUCTOS = 6;//Constante
		public final static int OPCION_MENU_PAGAR = 5;//Constante
		public final static int OPCION_MENU_CARRO = 4;//Constante
		public final static int OPCION_MENU_ELIMINAR = 3;//Constante
		public final static int OPCION_MENU_PRODUCTOS = 2;//Constante
		public final static int OPCION_MENU_CREAR = 1;//Constante
		
		public static void main(String[] args) {
			 crearArchivoCsvDinamico();//LLAMAMOS AL METODO PARA CREAR ARCHIVO CSV DINAMICO
			 
			int opcionSeleccionada;
			do {
				opcionSeleccionada = menu();
				switch (opcionSeleccionada) {
					case OPCION_MENU_CREAR:
						crearProducto();
						break;
					case OPCION_MENU_PRODUCTOS:
						verProducto();
						break;
					case OPCION_MENU_ELIMINAR:
						eliminarProducto();
						break;
					case OPCION_MENU_CARRO:
						agregarProductosAlCarro();
						break;	
					case OPCION_MENU_CARGA_PRODUCTOS:
						cargarProductosiniciales();
						break;	
					case OPCION_MENU_VENTAS:
						reporteVentas();
						break;
			
							
			   }
			}while(opcionSeleccionada !=  OPCION_MENU_SALIR);
	//do-while ES CREAR UN BUCLE(SIGNIFICA MIENTRA) HACER MIENTRAS LA CONDICION SE CUMPLA(SALIR)
			
			System.out.printf("Seleccionó la Opción %d Saliendo...", opcionSeleccionada);
	/*System.out.printf() --String format
	* %s = String, %d = Número entero, %f= número con decimales, %n = Salto de linea
	*imprimimos la seleccion del usuario (%d(interpolada) y concatenada ala clase scanner que tiene como variable 
	*opcionSeleccionada*/
		}
		private static void VEProductosAgregados() {
			// TODO Auto-generated method stub
			
		}
		private static void agregarProductos() {
			// TODO Auto-generated method stub
			
		}
		private static void reporteVentas() {
			System.out.println(" Ventas\n********\n");
			System.out.println("Fecha \t Monto");
			for(Venta venta: ventas) {
				System.out.printf("%td %tB %tY %tH: %tM \t %d"
						, venta.getFecha()
						, venta.getFecha()
						, venta.getFecha()
						, venta.getFecha()
						, venta.getFecha()
						, venta.calcularTotal());
			}
			System.out.printf("%n%n");
		}
		private static void crearProducto() {//metodo
	     //volvemos a utilizar la clase scanner lo vamos a guardar en un array 
			Scanner scanner = new Scanner(System.in);
			System.out.println("Ingrese un Codigo para su producto:");
			String codigoProducto = scanner.nextLine();
			
			System.out.println("Ingrese un Nombre para su producto:");
			String nombreProducto = scanner.nextLine();//nexline para cadena de texto = string
			
			System.out.println("Ingrese un Precio para su producto:");
			int precioProducto = scanner.nextInt();//numeros enteros
			
			System.out.println("Ingrese categoria del producto:");
			String categoriaProducto = scanner.nextLine();//nexline para cadena de texto = string
			
			System.out.println("Ingrese Descripcion del producto:");
			String descripcionProducto = scanner.nextLine();//
			
			Producto productoNuevo = new Producto(codigoProducto, nombreProducto, precioProducto, categoriaProducto, descripcionProducto);
			productos.add(productoNuevo);
		}
		private static void verProducto() {//metodo
			System.out.println("PRODUCTOS:\n***********");
			for(Producto producto : productos ) {
				System.out.printf("Código:%s Producto: %s Precio: %d Categoria: %s Descripcion: %s%n"
						, producto.getCodigo()
						, producto.getNombre()
						, producto.getPrecio()
						, producto.getCategoria()
						, producto.getDescripcion());
			}
			System.out.println("");
		}
		private static void cargarProductosiniciales() {
			productos.add(new Producto("[ch1]","Chicle Menta",200,"Golosinas","Menta Fresca"));
			productos.add(new Producto("[ch2]","Chicle Fruta",200,"Golosinas","Frutos Rojos"));
			productos.add(new Producto("[ch3]","Cafe Nescafe 280 g",2200,"Cafeteria","Dolca menos fuerte"));
		}
		private static void eliminarProducto() {
			System.out.println("Escriba el producto a eliminar:");
			Scanner scanner = new Scanner(System.in);
			String codigo = scanner.nextLine();
			
			Producto producto = buscarProducto(codigo);
			if (producto != null) {
				productos.remove( producto );
				System.out.printf("Se ha Eliminado el producto: %s", producto.getNombre());
			}		else {
					System.out.printf("no se encontro el producto con ese codigo: %s %n%n", codigo);
				}
			}
		
		private static Producto buscarProducto(String codigo) {
			// for(tipodato nombrevariable: variable array 
			for (Producto producto: productos){ //Producto es la clase, producto es nombre de la variable y porductos es variable array
				//compara si son iguales sin importar si el codigo esta en minus o mayus
				if (producto.getCodigo().equalsIgnoreCase(codigo)){
					return producto;
				}
			}
			return null;
		}
		
		private static void agregarProductosAlCarro() {
			Venta venta = new Venta();
			boolean seguirAgregandoProductos = true;
			do {
			//1. Muestro todos los producos
			verProducto();
			//2. Pregutar al usuariocodigoo de producto que quiere comprar
			System.out.println("Escriba el codigo del producto que desea comprar");
			Scanner scanner =new Scanner(System.in);
			String codigo = scanner.nextLine();
			Producto producto = buscarProducto(codigo);
			//para buscar el producto segun el codigo
			
			//3. catidad a comprar
			System.out.println("Cantidad que desea comprar");
			int cantidad = scanner.nextInt();
			
			//4.Crear linea de detalle
			LineaDetalle lineasDetalle = new LineaDetalle(cantidad,producto);
			venta.agregarLineaDetalle(lineasDetalle);
			
			//5. Si quiere agregar productos
			
			System.out.println("Desea agregar mas productos al carro: [Si/No]");
			String seguirAgregandoProductosStr = scanner.next();
			
			//CondicionVerdaderaOFalsa?siesVerdadero: si es Falso
			seguirAgregandoProductos = seguirAgregandoProductosStr.equalsIgnoreCase("SI")? true: false;
			}while (seguirAgregandoProductos);
			
			Scanner scanner = new Scanner (System.in);
			System.out.println("¿La Venta fue pagada?[Si/No]");
			boolean ventaPagada = scanner.nextLine().equalsIgnoreCase("SI")? true: false;
			if(ventaPagada) {
				ventas.add(venta);
			}
		}
			//MENU
		private static int menu() {
			System.out.println("\n**********************\n  Menu Punto de Venta\n**********************\n");
			System.out.println("[1] Crear Producto");
			System.out.println("[2] Ver Productos");
			System.out.println("[3] Eliminar Productos");
			System.out.println("[4] Agregar Productos");
			System.out.println("[5] Pagar");
			System.out.println("[6] Cargar Productos");
			System.out.println("[7] Ventas");
			System.out.println("[0] Salir");
			System.out.println("\nPor favor digite la opcion deseada");
			//instanciando a la clase Scanner que figura en la linea 1
			Scanner scanner = new Scanner(System.in);
			int opcionSeleccionada = scanner.nextInt();
			return opcionSeleccionada;
		}
		//ARCHIVO CSV
		
	    private static void crearArchivoCsv(){
	        String nombreArchivo   = "reporte-punto-ventas.csv";
	        String contenidoArchivoReporte = generarContenidoArchivosCSV();

	        try {
	          FileWriter writer = new FileWriter(nombreArchivo);
	          writer.write(contenidoArchivoReporte);
	          writer.close();
	        }catch(IOException ioe){
	          //mensaje para el usuario
	          System.out.println("Hubo un problema al escribir el reporte.");
	          System.out.println("Contacte con el administrador.");
	          //por implementar archivo de log
	        }
	      }
		 private static void crearArchivoCsvDinamico(){

		  String carpetaUsuario = System.getProperty("user.home");
	      String nombreArchivo   = "reporte-punto-ventas.csv";
	      //t dato nombre de variable = nombre de variable concatenada con nomrbre de variable
	      String rutaCompletaArchivo = carpetaUsuario + File.separator + nombreArchivo;
	      String contenidoArchivoReporte = generarContenidoArchivosCSV();

	    try {
	      FileWriter writer = new FileWriter(rutaCompletaArchivo);
	      System.out.printf("Escribiendo archivo: %s%n", rutaCompletaArchivo);
	      writer.write(contenidoArchivoReporte);
	      writer.close();
	    }catch(IOException ioe){
	      //mensaje para el usuario
	      System.out.println("Hubo un problema al escribir el reporte.");
	      System.out.println("Contacte con el administrador.");
	      //por implementar archivo de log
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