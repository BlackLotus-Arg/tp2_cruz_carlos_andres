package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoTarjeta implements Pago{
	
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private Double montoPagado;
	
	
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, Double monto) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		realizarPago(monto);
	}
	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		System.out.println(""" 
				Número de tarjeta: %.2f
				Fecha de pago: %.2f
				Monto pagado: %.2f
				""".formatted(numeroTarjeta,fechaPago,montoPagado));
		
	}
	@Override
	public void realizarPago(Double monto) {
		// TODO Auto-generated method stub
		this.montoPagado=monto*1.15;
	}
}
