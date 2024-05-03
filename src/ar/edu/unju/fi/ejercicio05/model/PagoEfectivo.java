package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private Double montoPagado;
	private LocalDate fechaPago;
	
	
	
	public PagoEfectivo(LocalDate fechaPago, Double monto) {
		super();
		this.fechaPago = fechaPago;
		realizarPago(monto);
	}
	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		System.out.println(""" 
				Fecha de pago: %.2f
				Monto pagado: %.2f
				""".formatted(fechaPago,montoPagado));
	}
	@Override
	public void realizarPago(Double monto) {
		// TODO Auto-generated method stub
		this.montoPagado = monto*0.9;
	}
}
