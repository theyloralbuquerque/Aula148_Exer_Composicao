package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.Funcionario;
import entities.HorasContrato;
import entities.enums.NivelProfissional;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // cria um formato de String que pode ser convertido para Date.
		
		System.out.print("Digite o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Digite os dados do funcion�rio:");
		System.out.print("Nome: ");
		String nomeFun = sc.nextLine();
		System.out.print("Digite o n�vel do funcion�rio: ");
		String nivelFun = sc.next();
		System.out.print("Digite o sal�rio fixo do funcion�rio: ");
		double salFixoFun = sc.nextDouble();
		
		Funcionario funcionario = new Funcionario(nomeFun, NivelProfissional.valueOf(nivelFun), salFixoFun, new Departamento(nomeDepartamento));
		/* aqui instanciou-se o objeto "funcionario" do tipo Funcionario, passando como par�mentro 
		 * a String "nomeFun", o valor da String "nivelFun" que ser� convertido em um tipo enumerado 
		 * da classe "NivelProfissional", o double "salFixoFun" e a String "nomeDepartamento" que 
		 * dentro dessa instancia��o ser� mandada para a classe "Departamento" e convertida em um tipo
		 * "Departamento".
	     */
		
		System.out.print("Quantos contratos o funcion�rio tem? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Digite os dados do contrato #" + i + ": ");
			System.out.print("Data (dd/MM/yyyy): ");
			Date dataContrato = sdf.parse(sc.next()); /* vari�vel "dataContrato" do tipo Date, que para receber a String que o usu�rio digitar.		
													   * teve que ser instanciada uma var�vel chamada "sdf" do tipo SimpleDateFormat,
													   * que cria um formato de String que aceita o m�todo .parse(), que converte String em Date.
													   */
			System.out.print("Valor recebido por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Dura��o (horas): ");
			int horas = sc.nextInt();
			
			HorasContrato contrato = new HorasContrato(dataContrato, valorPorHora, horas);
			// Instancia��o da classe HorasContrato passando como par�metro os valores digitados. 
			funcionario.addContrato(contrato);
			// Aqui acima o objeto funcionario est� chamando o m�todo "addContrato", passando como par�metro o objeto "contrato" instanciado anteriormente.
			// O m�todo vai adicionar os dados do objeto "contrato" e adicionar� na Lista "contratos".
		}
		
		System.out.println();
		System.out.print("Digite o m�s e ano para calcular o apurado (MM/YYYY): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2)); // .substring() pega os caracteres em determinadas posi��es na vari�vel.
		int ano = Integer.parseInt(mesEAno.substring(3));   // Integer.parseInt() converte os caracteres que est�o dentro dos par�nteses em Integer.
		System.out.println("Funcion�rio: " + funcionario.getNomeFun());
		System.out.println("Departamento: " + funcionario.getDepartamento().getNome());
		/* na linha acima se chamou o objeto funcionario e o get de Departamento,
		 * a partir do objeto departamento se chamou o getName() de departamento, 
		 * dentro do objeto departamento.
		 */
		System.out.println("Apurado no per�do " + mesEAno + ": " + String.format("%.2f",  funcionario.apurado(ano, mes)));
		// na linha acima � chamado o m�todo "apurado" dentro objeto funcionario, passando como par�metro "ano" e "mes".  
		
		
		sc.close();
	}

}
