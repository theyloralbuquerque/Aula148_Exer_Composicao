package entities;

import java.util.Date;

public class HorasContrato {
	
	private Date date;
	private Double valorPorHora;
	private Integer horas;
	
	
	public HorasContrato() { // construtor padrão
		
	}
	
	public HorasContrato(Date date, Double valorPorHora, Integer horas) { // construtor com argumentos
		this.date = date;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Double getValorPorHora() {
		return valorPorHora;
	}
	
	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora; 
	}
	
	public Integer getHoras() {
		return horas;
	}
	
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public double valorTotal() { // método que multiplica o valor por hora * a quantidade de horas trabalhadas.
		return valorPorHora * horas;
	}
}
