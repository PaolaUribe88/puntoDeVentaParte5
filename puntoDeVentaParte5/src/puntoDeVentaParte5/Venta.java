package puntoDeVentaParte5;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class Venta {

	private LocalDateTime fecha = LocalDateTime.now();
	private ArrayList<LineaDetalle> lineasDetalle = new ArrayList<>();
	
	//Contructores
	public Venta() {
		
	}

	public Venta(LocalDateTime fecha, ArrayList<LineaDetalle> lineaDetalle) {
		this.fecha = fecha;
		this.lineasDetalle = lineaDetalle;
	}
	public void agregarLineaDetalle(LineaDetalle lineaDetalle) {
		this.lineasDetalle.add(lineaDetalle);
	}
		public int calcularTotal() {
			int total = 0;
			for (LineaDetalle lineaDetalle : lineasDetalle) {
				total = total + lineaDetalle.calcularSubtotal();
			}
			return total;
		
	}
		
	//GETTER AND SETTERS
	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public ArrayList<LineaDetalle> getLineaDetalle() {
		return lineasDetalle;
	}

	public void setLineaDetalle(ArrayList<LineaDetalle> lineaDetalle) {
		this.lineasDetalle = lineaDetalle;
	}
	
	
	

}
