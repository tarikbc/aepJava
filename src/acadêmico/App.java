package acadêmico;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
	public static void main(String[] args) {
		Random rand = new Random(System.currentTimeMillis());
		String[] nomeAlunos = {
				"Marcelo", "João", "Ana", "Tiago", "José",
				"Renato", "Maria", "Jhonatan", "Paula", "Lucas"
		};
		String[] disciplinaNomes = {"História", "Matemática", "Física", "Sociologia", "Filosofia"};
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		RepositorioDeAvaliações rep = new RepositorioDeAvaliações();
		
		// Gera disicplinas
		for (String disciplina: disciplinaNomes) disciplinas.add(new Disciplina(disciplina));
		
		// Gera avaliações
		for (int i = 0; i < disciplinas.size(); i++) {
			int numeroReprovados = 0;
			
			for (int j = 0; j < nomeAlunos.length; j++) {
				Aluno aluno = new Aluno(nomeAlunos[j], Math.abs(rand.nextInt()));
				boolean reprovado = (rand.nextInt() % 2 == 0) && (numeroReprovados < i);
				if (numeroReprovados < i && j > 5) reprovado = true;
				if (reprovado) numeroReprovados++;
				
				List<Float> notas = (reprovado) ? gerarReprovado() : gerarAprovado();
				
				
				
				for (Float nota: notas) {
					Avaliação avaliação = new Avaliação(nota, disciplinas.get(i), aluno);
					rep.adicionar(avaliação);
				}
			}
		
		}
		
		for (Disciplina disciplina: disciplinas) {
			System.out.println("Nome da disciplina: " + disciplina.getNome());
			rep.obterAprovados(disciplina, true);
			System.out.println("");
		}
		
		for (Disciplina disciplina: disciplinas) {
			System.out.println("Nome da disciplina: " + disciplina.getNome());
			System.out.println("Aprovados: " + rep.obterAprovados(disciplina, false).size());
		}
	}
	
	// Gera 4 notas de um aluno reprovado
	public static List<Float> gerarReprovado() {
		List<Float> notas = new ArrayList<Float>();
		do {
			notas.clear();
			for (int i = 0; i < 4; i++) notas.add((float)Math.ceil(Math.random() * 10));
		}
		while(calcularMedia(notas) >= 6);
		
		return notas;
	}
	
	// Gera 4 notas de um aluno aprovado
	public static List<Float> gerarAprovado() {
		List<Float> notas = new ArrayList<Float>();
		do {
			notas.clear();
			for (int i = 0; i < 4; i++) notas.add((float)Math.ceil(Math.random() * 10));
		}
		while(calcularMedia(notas) < 6);
		
		return notas;
	}
	
	// Calcula a media de um array de floats
	public static Float calcularMedia(List<Float> arr) {
		Float soma = (float)0;
		for (int i = 0; i < arr.size(); i++) soma += arr.get(i);
		return soma / arr.size();
	}
}
