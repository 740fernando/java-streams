package br.com.dio.collection.streamAPI.model.entities;

public class Contato {

	private String nome;
	private Integer number;
	
	public Contato(String nome, Integer number) {
		super();
		this.nome = nome;
		this.number = number;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
}
