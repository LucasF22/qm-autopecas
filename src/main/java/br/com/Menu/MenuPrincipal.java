package br.com.Menu;

import java.util.List;
import java.util.Scanner;

import br.com.Peca.DAO.PecaDAO;
import br.com.Peca.Pojo.Peca;
import br.com.Venda.DAO.VendaDAO;

public class MenuPrincipal {
	static void gestaoPeca(Scanner teclado, PecaDAO pecaDAO) {
	int opcaoCadastro = 0;
	do {
		System.out.println("====================================");
		System.out.println("========== Gest�o de Pe�as ==========");
		System.out.println("====================================");
		System.out.println("**       1 - Casdastrar           **");
		System.out.println("**       2 - Consultar            **");
		System.out.println("**       3 - Listar pe�as         **");
		System.out.println("**       4 - Listar por nome      **");
		System.out.println("**       5 - listar por modelo    **");
		System.out.println("**       6 - Listar por categoria **");
		System.out.println("**       7 - remover pe�a         **");
		System.out.println("**       0 - Menu Principal       **");
		System.out.println("====================================");
		System.out.println("====================================");
		System.out.println("Digite o n�mero da op��o desejada: ");
		int selecao = teclado.nextInt();
		
		opcaoCadastro = selecao;
		switch (selecao) {
			case 1:{
				casdastrarPeca(teclado, pecaDAO);
				break;
			}
			case 2:{
				consultarPeca(teclado, pecaDAO);
				break;
			}
			case 3:{
				listarPe�as(pecaDAO);
				break;
			}
			case 4:{
				listarPorNome(teclado, pecaDAO); 
				break;
			}
			case 5:{
				listarPorModelo(teclado, pecaDAO);
				break;
			}
			case 6:{
				listarPorCategoria(teclado, pecaDAO);
				break;
			}
			case 7:{
				removerPeca(teclado, pecaDAO);
				break;
			}
			
			default:
				System.out.println("Op��o Inv�lida!");
				break;
		}
	} while (opcaoCadastro != 0);
	System.out.println("test 0");
	teclado.close();
		
	}
//	public Peca(int codBarras, String nome, String modeloCarro, String fabricante, float pcoCusto, float pcoVenda,
//			int estoque, String categoria)
	public static void casdastrarPeca(Scanner teclado, PecaDAO pecaDAO) {
		System.out.println("Digite o codigo de barras: ");
		int codBarras  = teclado.nextInt();
		System.out.println("Digite o nome da Pe�a: ");
		teclado.nextLine();
		String nome = teclado.nextLine();
		System.out.println("Digite o modelo do Carro: ");
		String modelo = teclado.nextLine();
		System.out.println("Digite o fabricante: ");
		String fabricante = teclado.nextLine();
		System.out.println("Digite o pre�o de custo Pe�a: ");
		float pcoCusto = teclado.nextFloat();
		System.out.println("Digite o pre�o de venda da Pe�a: ");
		float pcoVenda = teclado.nextFloat();
		System.out.println("Digite o quantidade em estoque: ");
		int estoque = teclado.nextInt();
		System.out.println("Digite a categoria da pe�a: ");
		String categoria = teclado.nextLine();
		try {
			pecaDAO.inserePeca(new Peca(codBarras, nome, modelo, fabricante, pcoCusto, pcoVenda, estoque, categoria));
			
			System.out.println("Cadastro realizado com sucesso!");
		}catch(Exception e) {
			e.getMessage(); 
			System.err.println("Erro ao cadastrar Pe�a!");
		}
	}
	public static void consultarPeca(Scanner teclado, PecaDAO pecaDAO) {
		System.out.println("C�digo barras a ser consultada: ");
		int codBarras = teclado.nextInt();
		Peca peca = pecaDAO.consultaPeca(codBarras);
		
		if(peca == null) {
			System.out.println("Peca n�o encontrada!");
			return;
		}
	}
	public static void listarPe�as(PecaDAO pecaDAO) {
		try {	
			List<Peca> pecas = pecaDAO.listarPecasEstoque();
			if(pecas == null) {
				System.out.println("Peca n�o encontrada!");
				return;
			}
			for(Peca peca :pecas) {
				System.out.println(peca);
			}
		}catch(Exception e) {
			e.getMessage(); 
			System.err.println("Erro ao Listar pe�as!");
		}
	}
	public static void listarPorNome(Scanner teclado, PecaDAO pecaDAO) {
		teclado.nextLine();
		System.out.println("Filtar pe�a por nome: ");
		String nome = teclado.nextLine();
		try {
			List<Peca> pecas = pecaDAO.listaPecasPorNome(nome);
			if(pecas == null) {
				System.out.println("Peca n�o encontrada!");
				return;
			}
			for(Peca peca :pecas) {
				System.out.println(peca);
			}
		}catch(Exception e) {
			e.getMessage(); 
			System.err.println("Erro ao Listar Pe�as por nome!");
		}
	}
	public static void listarPorModelo(Scanner teclado, PecaDAO pecaDAO) {
		teclado.nextLine();
		System.out.println("Filtar pe�a por modelo: ");
		String modelo = teclado.nextLine();
		try {
			List<Peca> pecas = pecaDAO.listaPecasPorModCarro(modelo);
			if(pecas == null) {
				System.out.println("Peca n�o encontrada!");
				return;
			}
			for(Peca peca :pecas) {
				System.out.println(peca);
			}
		}catch(Exception e) {
			e.getMessage(); 
			System.err.println("Erro ao Listar Pe�a por modelo!");
		}
	}
	public static void listarPorCategoria(Scanner teclado, PecaDAO pecaDAO) {
		teclado.nextLine();
		System.out.println("Filtar pe�a por categoria: ");
		String categoria = teclado.nextLine();
		try {
			List<Peca> pecas = pecaDAO.listaPecasPorCategoria(categoria);
			if(pecas == null) {
				System.out.println("Peca n�o encontrada!");
				return;
			}
			for(Peca peca :pecas) {
				System.out.println(peca);
			}
		}catch(Exception e) {
			e.getMessage(); 
			System.err.println("Erro ao cadastrar Pe�a!");
		}
	}
	public static void removerPeca(Scanner teclado, PecaDAO pecaDAO) {
		System.out.println("C�digo de barras da pe�a a ser removida: ");
		int codBarras = teclado.nextInt();
		try {
			pecaDAO.removePeca(codBarras);
			System.out.println("Pe�a removida com sucesso!");
		}catch(Exception e) {
			e.getMessage(); 
			System.err.println("Erro ao remover pe�a.");
		}
	}
	 
	
	public static void menuVenda(Scanner teclado) {
		
		int opcao = 0;		
		do {
			System.out.println("====================================");
			System.out.println("========== Menu de Venda ===========");
			System.out.println("====================================");
			System.out.println("**       1 - Realizar Venda       **");
			System.out.println("**       2 - Relat�rio do dia     **");
			System.out.println("**       0 - Voltar               **");
			System.out.println("====================================");
			System.out.println("====================================");
			
			System.out.println("Digite o n�mero da op��o desejada: ");
			int selecionado = teclado.nextInt();
			opcao = selecionado;
			
			switch (selecionado) {
				case 1:{
					
					break;
				}
				case 2:{
					
					break;
				}
				default:
					System.out.println("Op��o Inv�lida!");
					break;
			}
		} while (opcao != 0);
	}
	//Venda(int codigo, String nome, int quantidade, double valor)
	public void realizaVenda(Scanner teclado, VendaDAO vendaDAO) {
		System.out.println();
		System.out.println();
		
	}
	public void relatorioDia() {
		
	}
	public static void main(String[] args) {
		PecaDAO pecaDAO = new PecaDAO();
		
		Scanner teclado = new Scanner(System.in);
		int opcao = 0;
		
		do {
			System.out.println("====================================");
			System.out.println("========== Menu Principal ==========");
			System.out.println("====================================");
			System.out.println("**       1 - Gest�o de Pe�as      **");
			System.out.println("**       2 - Venda                **");
			System.out.println("**       0 - Sair                 **");
			System.out.println("====================================");
			System.out.println("====================================");
			
			System.out.println("Digite o n�mero da op��o desejada: ");
			int selecionado = teclado.nextInt();
			opcao = selecionado;
			
			switch (selecionado) {
				case 1:{
					gestaoPeca(teclado, pecaDAO);
					break;
				}
				case 2:{
					menuVenda(teclado);
					break;
				}
				default:
					System.out.println("Op��o Inv�lida!");
					break;
			}
		} while (opcao != 0);
		System.out.println("Voc� Saiu do programa!");
		
		teclado.close();
	}

}


