package gsFit;

import java.util.ArrayList;
import java.util.List;

public class Treino {

	String nome;
	String data;
	int duracao;
	List<Exercicio> listaDeExercicios;
	Professor professor;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(byte duracao) {
		this.duracao = duracao;
	}
	
	public Treino() {
        this.listaDeExercicios = new ArrayList<>();
    }

    public List<Exercicio> getListaDeExercicios() {
        return listaDeExercicios;
    }

    public void setListaDeExercicios(List<Exercicio> listaDeExercicios) {
        this.listaDeExercicios = listaDeExercicios;
    }
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
