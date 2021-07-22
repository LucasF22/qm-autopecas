package br.com.Venda.DAO;

import br.com.Venda.Venda;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.Peca.DAO.PecaDAO;
import br.com.Peca.Pojo.*;

public class VendaDAO {

	private List<Venda> vendas;
	private PecaDAO pecaDAO;
	
	//lista de vendas e pecaDAO
	public VendaDAO(PecaDAO pecaDAO) {
		this.vendas = new ArrayList<Venda>();
		this.pecaDAO = pecaDAO;
	}


	public VendaDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean realizaVenda(int codBarras, int quantidade) {
		Peca peca = pecaDAO.consultaPeca(codBarras);

		if(peca == null) {
			return false;//adicionar exceção
		}
		if(quantidade >= peca.getEstoque()) {
			return false;//adicionar exceção
		}

		Venda venda = new Venda(codBarras, peca.getNome(), quantidade, peca.getPcoVenda());
		
		System.out.println(venda.getCodigo()+"|||||||"+venda.getValor() );
		
		vendas.add(venda);	
		
		//ok falta o valor total
		System.out.println("Deseja confirmar pedido?\n(digite 1 - Para sim ou 0 - Para não)");
		Scanner teclado = new Scanner(System.in);
		int opcao = teclado.nextInt();
		opcao = 1;
		teclado.close();
		if(opcao == 1) {
			int total = peca.getEstoque() - quantidade;
			pecaDAO.alteraEstoque(total, peca);
			return true;
		}
		
	return true;		
	}
	
	public void relatorio() throws IOException {
		
		try {
			FileWriter fw = new FileWriter("relatorioVenda.txt");
			
			fw.write("------Faturamento do dia-------\nCódigo\tNome\tQuantidade\tValor");
			//fw.write("\nCódigo\tNome\tQuantidade\tValor");
			
			List<Venda> vendasList = vendas;
			
			double total = 0;
			for(Venda venda : vendasList) {
				fw.write("\n"+venda.imprimeVenda());
				fw.write("\n");

				total += venda.getQuantidade() * venda.getValor();
			}
			
			fw.write("\nTotal faturado: R$"+total);
			
			fw.close();
		}catch(IOException e) {
			System.err.println("Erro");
			
		}
	}
}
