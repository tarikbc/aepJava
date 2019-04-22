package acadêmico;

public class Aluno {
	private String nome;
	private int ra;
	
	public Aluno (int ra, String nome) {
		this.ra = ra;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getRA() {
		return ra;
	}
	
}
