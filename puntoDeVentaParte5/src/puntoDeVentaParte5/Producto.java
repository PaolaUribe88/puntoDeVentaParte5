package puntoDeVentaParte5;


public class Producto {
	private String codigo;
	private String nombre;
	private int precio;
	private String categoria;
	private String descripcion;
	
	public Producto() {
		//CONSTRUCTOR VACIO
	}

	public Producto(String codigo, String nombre, int precio, String categoria, String descripcionProducto) {
	//CONSTRUCTOR
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.descripcion = descripcionProducto;
	}

	//GETTER AND SETTER

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}