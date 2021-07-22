package br.com.Venda;

public class Venda {
	private int codigo;
	private String nome;
	private int quantidade;	
	private double valor;
	
	public Venda(int codigo, String nome, int quantidade, double valor) {
		this.codigo = codigo;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public Venda() {
		// TODO Auto-generated constructor stub
	}

	public String imprimeVenda() {
		// TODO Auto-generated method stub
		return String.format("%d %-20s %-5d %-15.2f", this.codigo, this.nome, this.quantidade, this.valor);

	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", nome=" + nome + ", quantidade=" + quantidade + ", valor=" + valor + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	

	
	
	
	
}
