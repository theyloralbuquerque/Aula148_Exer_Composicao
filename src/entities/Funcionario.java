package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelProfissional;

public class Funcionario {

	private String nomeFun;
	private NivelProfissional nivelFun;	
	private Double salFixoFun;
	
	private Departamento departamento; // associação de classe.
	private List<HorasContrato> contratos = new ArrayList<>(); // associação de classe "Tem muitos", a classe é associda por meio de Lista.
															   // a Lista já tem que ser instaciada desde a sua criação. 
	public Funcionario() { // construtor padrão
		
	}
	
	public Funcionario(String nomeFun, NivelProfissional nivelFun, Double salFixoFun, Departamento departamento) { // construtor com argumentos.
		this.nomeFun = nomeFun;
		this.nivelFun = nivelFun; // atributos tipo Lista não vão no construtor.
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
	
	public List<HorasContrato> getContratos() { // get do tipo Lista. Lista não tem set.
		return contratos;
	}
	
	public void addContrato(HorasContrato contrato) { // método que adiciona contratos à Lista 
		contratos.add(contrato); 
	}

	public void removeContrato(HorasContrato contrato) { // método que remove contratos da Lista
		contratos.remove(contrato);
	}
	
	public double apurado(int ano, int mes) { // método que calcula o apurado do funcionário em um determinado mês.
		double soma = salFixoFun;
		Calendar cal = Calendar.getInstance(); // Instanciação do Calendar, "Instance" quer dizer no momento atual.
		for (HorasContrato c : contratos) { // "Para cada contrato "c" do tipo "HorasContrato" da Lista "contratos" faça.
			cal.setTime(c.getDate()); // Peguei a data do meu contrato e defini como a data do meu calendário "cal".
			int c_ano = cal.get(Calendar.YEAR); // c_ano recebe o ano de "cal" na repetição do momento.
			int c_mes =	1 + cal.get(Calendar.MONTH); // c_mes recebe o mês de "cal" na repetição do momento.
			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
		
	}
}
