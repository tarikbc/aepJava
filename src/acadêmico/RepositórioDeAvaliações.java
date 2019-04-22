package acadêmico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RepositórioDeAvaliações {
	
	private List<Avaliação> avaliações = new ArrayList<Avaliação>();
	
	public void adicionar(Avaliação avaliação) {
		avaliações.add(avaliação);
	}

	public List<Aluno> obterAprovados(Disciplina disciplina, boolean print) {
		List<Avaliação> avaliações = obterAvaliaçõesPorDisciplina(disciplina);
		List<Aluno> alunos = obterAlunos(disciplina);
		List<Aluno> alunosAprovados = new ArrayList<Aluno>();
		Float soma;
		
		for (Aluno aluno: alunos) {
			soma = 0f;
			for (Avaliação avaliação: avaliações) {
				if (avaliação.getAluno() == aluno) soma += avaliação.getNota();
			}
			if (soma / 4 >= 6) {
				alunosAprovados.add(aluno);
				if (print) System.out.println("Aprovado: " + aluno.getNome());
			}
		}
		
		return alunosAprovados;
	}
	
	public List<Avaliação> obterAvaliaçõesPorDisciplina(Disciplina disciplina) {
		List<Avaliação> avaliaçõesDaDiscplina = new ArrayList<Avaliação>();
		
		for (int i = 0; i < avaliações.size(); i++) {
			if (avaliações.get(i).getDisciplina() == disciplina) avaliaçõesDaDiscplina.add(avaliações.get(i));
		}
		
		return avaliaçõesDaDiscplina;
	}
	
	public List<Aluno> obterAlunos(Disciplina disciplina) {
		Set<Aluno> alunosDeAvaliações = new HashSet<Aluno>();
		List<Aluno> alunosDeAvaliaçõesList = new ArrayList<Aluno>();
		
		for (Avaliação avaliação: obterAvaliaçõesPorDisciplina(disciplina)) alunosDeAvaliações.add(avaliação.getAluno());
		for (Aluno aluno: alunosDeAvaliações) alunosDeAvaliaçõesList.add(aluno);
		
		return alunosDeAvaliaçõesList;
	}

}
