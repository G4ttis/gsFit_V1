package gsFit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {

	private String problemasDeSaude;
	private LocalDate dataMatricula;
    private double peso;
    private double altura;
    private List<Treino> treinos;
    
    public String getProblemasDeSaude() {
        return problemasDeSaude;
    }

    public void setProblemasDeSaude(String problemasDeSaude) {
        this.problemasDeSaude = problemasDeSaude;
    }
    
    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }

    public void adicionarTreino(Treino treino) {
        if (treinos == null) {
            treinos = new ArrayList<>();
        }
        treinos.add(treino);
    }

    public void removerTreino(Treino treino) {
        if (treinos != null) {
            treinos.remove(treino);
        }
    }
    
}

