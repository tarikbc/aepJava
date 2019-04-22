package acad�mico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Reposit�rioDeAvalia��es {
	
	private List<Avalia��o> avalia��es = new ArrayList<Avalia��o>();
	
	public void adicionar(Avalia��o avalia��o) {
		avalia��es.add(avalia��o);
	}

	public List<Aluno> obterAprovados(Disciplina disciplina, boolean print) {
		List<Avalia��o> avalia��es = obterAvalia��esPorDisciplina(disciplina);
		List<Aluno> alunos = obterAlunos(disciplina);
		List<Aluno> alunosAprovados = new ArrayList<Aluno>();
		Float soma;
		
		for (Aluno aluno: alunos) {
			soma = 0f;
			for (Avalia��o avalia��o: avalia��es) {
				if (avalia��o.getAluno() == aluno) soma += avalia��o.getNota();
			}
			if (soma / 4 >= 6) {
				alunosAprovados.add(aluno);
				if (print) System.out.println("Aprovado: " + aluno.getNome());
			}
		}
		
		return alunosAprovados;
	}
	
	public List<Avalia��o> obterAvalia��esPorDisciplina(Disciplina disciplina) {
		List<Avalia��o> avalia��esDaDiscplina = new ArrayList<Avalia��o>();
		
		for (int i = 0; i < avalia��es.size(); i++) {
			if (avalia��es.get(i).getDisciplina() == disciplina) avalia��esDaDiscplina.add(avalia��es.get(i));
		}
		
		return avalia��esDaDiscplina;
	}
	
	public List<Aluno> obterAlunos(Disciplina disciplina) {
		Set<Aluno> alunosDeAvalia��es = new HashSet<Aluno>();
		List<Aluno> alunosDeAvalia��esList = new ArrayList<Aluno>();
		
		for (Avalia��o avalia��o: obterAvalia��esPorDisciplina(disciplina)) alunosDeAvalia��es.add(avalia��o.getAluno());
		for (Aluno aluno: alunosDeAvalia��es) alunosDeAvalia��esList.add(aluno);
		
		return alunosDeAvalia��esList;
	}

}
