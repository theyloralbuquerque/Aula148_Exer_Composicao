package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelProfissional;

public class Funcionario {

	private String nomeFun;
	private NivelProfissional nivelFun;	
	private Double salFixoFun;
	
	private Departamento departamento; // associa��o de classe.
	private List<HorasContrato> contratos = new ArrayList<>(); // associa��o de classe "Tem muitos", a classe � associda por meio de Lista.
															   // a Lista j� tem que ser instaciada desde a sua cria��o. 
	public Funcionario() { // construtor padr�o
		
	}
	
	public Funcionario(String nomeFun, NivelProfissional nivelFun, Double salFixoFun, Departamento departamento) { // construtor com argumentos.
		this.nomeFun = nomeFun;
		this.nivelFun = nivelFun; // atributos tipo Lista n�o v�o no construtor.
		this.salFixoFun = salFixoFun;
		this.departamento = departamento;
	}
	
	public String getNomeFun() {
		return nomeFun;
	}
	
	public void setNameFun(String nomeFun) {
		this.nomeFun = nomeFun;
	}
	
	public NivelProfissional getNivelFun() {
		return nivelFun;
	}
	
	public void setNivel(NivelProfissional nivelFun) {
		this.nivelFun = nivelFun;
	}
	
	public Double getSalFixoFun() {
		return salFixoFun;
	}
	
	public void setSalFixoFun(Double salFixoFun) {
		this.salFixoFun = salFixoFun;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public List<HorasContrato> getContratos() { // get do tipo Lista. Lista n�o tem set.
		return contratos;
	}
	
	public void addContrato(HorasContrato contrato) { // m�todo que adiciona contratos � Lista 
		contratos.add(contrato); 
	}

	public void removeContrato(HorasContrato contrato) { // m�todo que remove contratos da Lista
		contratos.remove(contrato);
	}
	
	public double apurado(int ano, int mes) { // m�todo que calcula o apurado do funcion�rio em um determinado m�s.
		double soma = salFixoFun;
		Calendar cal = Calendar.getInstance(); // Instancia��o do Calendar, "Instance" quer dizer no momento atual.
		for (HorasContrato c : contratos) { // "Para cada contrato "c" do tipo "HorasContrato" da Lista "contratos" fa�a.
			cal.setTime(c.getDate()); // Peguei a data do meu contrato e defini como a data do meu calend�rio "cal".
			int c_ano = cal.get(Calendar.YEAR); // c_ano recebe o ano de "cal" na repeti��o do momento.
			int c_mes =	1 + cal.get(Calendar.MONTH); // c_mes recebe o m�s de "cal" na repeti��o do momento.
			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
		
	}
}
