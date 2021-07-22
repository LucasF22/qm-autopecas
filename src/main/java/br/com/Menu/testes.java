package br.com.Menu;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.com.Peca.DAO.*;
import br.com.Peca.Pojo.*;
import br.com.Venda.Venda;
import br.com.Venda.DAO.VendaDAO;

public class testes {

	public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner(System.in);
		PecaDAO pecaDAO = new PecaDAO();
		VendaDAO vendaDAO = new VendaDAO(pecaDAO);
		
		
		vendaDAO.realizaVenda(2, 2);
//		Venda ven = new Venda(1, "Pneu", 4, 99.99F);
//		System.out.printf(ven.getCodigo()+"   "+ven.getNome()+"\n");
			vendaDAO.relatorio();
			
//		System.out.println("- Inserção -");
//		System.out.println("Digite a codigo: ");
//		int codBarras = teclado.nextInt();
//		System.out.println("Digite a nome: ");
//		String nome = teclado.next();
//		System.out.println("Digite modelo: ");
//		String modeloCarro = teclado.next();
//		System.out.println("Digite fabricante: ");
//		String fabricante = teclado.next();
//		System.out.println("Digite custo: ");
//		float pcoCusto = teclado.nextFloat();
//		System.out.println("Digite venda: ");
//		float pcoVenda = teclado.nextFloat();
//		System.out.println("Digite estoque: ");
//		int estoque = teclado.nextInt();
//		System.out.println("Digite categoria: ");
//		String categoria = teclado.next();
//			
//		//001, volante, uno, fiat, 50.00F, 80.00F, 5, Direção  codBarras, nome, modeloCarro, fabricante, pcoCusto, pcoVenda, estoque, categoria
//
//		 if(pecaDAO.inserePeca(new Peca(codBarras, nome, modeloCarro, fabricante, pcoCusto, pcoVenda, estoque, categoria))) {
//			 System.out.println("- Inserção -");
//		 }
		
		
//		System.out.println("Digite a codigo: ");
//		int codBarras = teclado.nextInt();
//		
//		Peca consultaPeca = pecaDAO.consultaPeca(codBarras);
//		
//		if (consultaPeca != null) {
//			System.out.println(consultaPeca);
//		}
		
		
//		List<Peca> pecas = pecaDAO.listarPecasEstoque();
//		
//		for (Peca peca : pecas) {
//			System.out.println(peca);
//		}
		
//		System.out.println("Digite a nome: ");
//		String nomes = teclado.next();
//		
//		List<Peca> porNome = pecaDAO.listaPecasPorNome(nomes);
//		
//		for (Peca peca : porNome) {
//			System.out.println(peca);
//		};
		
//		System.out.println("Digite a codigo: ");
//		int codBarras = teclado.nextInt();
//		
//			if(pecaDAO.removePeca(codBarras)) {
//				System.out.println("Peça removido!");
//			}
		
		
		
		 teclado.close();
		
	}

}
