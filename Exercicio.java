package gsFit;

public class Exercicio {
	
	private String nome;
	private String equipamento;
	private String serie;
	private int carga;
	private byte tempoDescanso;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}
	
	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public byte getTempoDescanso() {
		return tempoDescanso;
	}

	public void setTempoDescanso(byte tempoDescanso) {
		this.tempoDescanso = tempoDescanso;
	}
	
}
