package acad�mico;

public class Avalia��o {
	private float nota;
	private Disciplina disciplina;
	private Aluno aluno;
	
	public Avalia��o(Aluno aluno, Disciplina disciplina, float nota) throws Exception {
		if(nota>10.0f || nota<0.0f) {
			throw new Exception("Nota inv�lida");
		}
		this.nota = nota;
		this.disciplina = disciplina;
		this.aluno = aluno;
	}
	
	public float getNota() {
		return nota;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
}
