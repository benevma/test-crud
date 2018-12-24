package main.java.bean;

public class UtenteBean {
	
	long id;
	String nome;
	int eta;

	public UtenteBean(String nome, int eta) {
		id=System.currentTimeMillis();
		this.nome=nome;
		this.eta=eta;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}

	public long getId() {
		return id;
	}
	
}
