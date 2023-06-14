package entities;

public class Departamento {
	
	private String nome;
	
	public Departamento() { // construtor padrão
	}
	
	public Departamento(String nome) { // construtor com argumento
		this.nome = nome;
	}
	
	public String getNome() { // get
		return nome;
	}
	
	public void setName(String nome) { // set
		this.nome = nome;
	}

}
