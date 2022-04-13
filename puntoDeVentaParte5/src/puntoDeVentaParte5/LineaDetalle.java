package puntoDeVentaParte5;

public class LineaDetalle {

	private int cantidad;
	private Producto producto;
	
	//constructores
	public LineaDetalle() {

	}

	public LineaDetalle(int cantidad, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
	}
	//Calculos
	public int calcularSubtotal() {
		return cantidad * producto.getPrecio();
		
	}
		
	//getters y setters
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	

}
