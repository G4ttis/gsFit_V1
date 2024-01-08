package gsFit;

import java.util.List;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.ArrayList;

public class Academia {
	
	private List<Exercicio> listaDeExercicios; 
	private List<Aluno> listaDeAlunos;
	private List<Professor> listaDeProfessores;
	private List<Treino> listaDeTreinos;
	
	public List<Exercicio> getListaDeExercicios() {
		return listaDeExercicios;
	}
	
	public void setListaDeExercicios(List<Exercicio> listaDeExercicios) {
		this.listaDeExercicios = listaDeExercicios;
	}
	
	public List<Aluno> getListaDeAlunos() {
		return listaDeAlunos;
	}
	
	public void setListaDeAlunos(List<Aluno> listaDeAlunos) {
		this.listaDeAlunos = listaDeAlunos;
	}
	
	public List<Professor> getListaDeProfessores() {
		return listaDeProfessores;
	}
	
	public void setListaDeProfessores(List<Professor> listaDeProfessores) {
		this.listaDeProfessores = listaDeProfessores;
	}
	
	public List<Treino> getListaDeTreinos() {
        return listaDeTreinos;
    }

    public void setListaDeTreinos(List<Treino> listaDeTreinos) {
        this.listaDeTreinos = listaDeTreinos;
    }
    
    // Métodos para verificar/buscar CPF cadastrados
    
    public boolean existeAlunoComCPF(String cpf) {
        if (listaDeAlunos != null) {
            for (Aluno aluno : listaDeAlunos) {
                if (aluno.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public Aluno encontrarAlunoPorCPF(String cpf) {
        if (listaDeAlunos != null) {
            for (Aluno aluno : listaDeAlunos) {
                if (aluno.getCpf().equals(cpf)) {
                    return aluno;
                }
            }
        }
        return null;
    }
    
    public boolean existeProfessorComCPF(String cpf) {
        if (listaDeProfessores != null) {
            for (Professor professor : listaDeProfessores) {
                if (professor.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public Professor encontrarProfessorPorCPF(String cpf) {
        if (listaDeProfessores != null) {
            for (Professor professor : listaDeProfessores) {
                if (professor.getCpf().equals(cpf)) {
                    return professor;
                }
            }
        }
        return null;
    }
    
	// Métodos - Aluno -------------------------------------------------------------------------------------------------------------------
    
	public void cadastrarAluno(String nome, String email, String cpf, String telefone, LocalDate dataNascimento, double peso, double altura, String problemasDeSaude) {
	    if (listaDeAlunos == null) {
	        listaDeAlunos = new ArrayList<>();
	    }

	    if (existeAlunoComCPF(cpf)) {
	        JOptionPane.showMessageDialog(null, "Já existe um aluno cadastrado com este CPF!");
	        return;
	    }

	    Aluno novoAluno = new Aluno();
	    novoAluno.setNome(nome);
	    novoAluno.setEmail(email);
	    novoAluno.setCpf(cpf);
	    novoAluno.setTelefone(telefone);
	    novoAluno.setDataNascimento(dataNascimento);
	    novoAluno.setPeso(peso);
	    novoAluno.setAltura(altura);
	    novoAluno.setProblemasDeSaude(problemasDeSaude);
	    
	    listaDeAlunos.add(novoAluno);

	    JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
	}
	
	public void excluirAluno(String cpf) {
	    if (listaDeAlunos != null) {
	        Aluno alunoParaExcluir = null;

	        // Procurar o aluno com o CPF fornecido
	        for (Aluno aluno : listaDeAlunos) {
	            if (aluno.getCpf().equals(cpf)) {
	                alunoParaExcluir = aluno;
	                break;
	            }
	        }

	        // Remover o aluno se encontrado
	        if (alunoParaExcluir != null) {
	            listaDeAlunos.remove(alunoParaExcluir);
	            JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
	        } else {
	            JOptionPane.showMessageDialog(null, "Não foi encontrado um aluno com o CPF fornecido.");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Não há alunos cadastrados.");
	    }
	}
	
	public void alterarAluno(String cpf) {
	    if (listaDeAlunos != null) {
	        Aluno alunoParaAlterar = null;

	        // Procurar o aluno com o CPF fornecido
	        for (Aluno aluno : listaDeAlunos) {
	            if (aluno.getCpf().equals(cpf)) {
	                alunoParaAlterar = aluno;
	                break;
	            }
	        }

	        // Alterar os dados se o aluno for encontrado
	        if (alunoParaAlterar != null) {
	            String novoNome = JOptionPane.showInputDialog("Informe o novo nome do aluno:");
	            String novoEmail = JOptionPane.showInputDialog("Informe o novo email do aluno:");
	            String novoTelefone = JOptionPane.showInputDialog("Informe o novo telefone do aluno:");
	            LocalDate novaDataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Informe a nova data de nascimento do aluno (AAAA-MM-DD):"));
	            double novoPeso = Double.parseDouble(JOptionPane.showInputDialog("Informe o novo peso do aluno:"));
	            double novaAltura = Double.parseDouble(JOptionPane.showInputDialog("Informe a nova altura do aluno:"));
	            String novosProblemasDeSaude = JOptionPane.showInputDialog("Informe os novos problemas de saúde do aluno:");

	            alunoParaAlterar.setNome(novoNome);
	            alunoParaAlterar.setEmail(novoEmail);
	            alunoParaAlterar.setTelefone(novoTelefone);
	            alunoParaAlterar.setDataNascimento(novaDataNascimento);
	            alunoParaAlterar.setPeso(novoPeso);
	            alunoParaAlterar.setAltura(novaAltura);
	            alunoParaAlterar.setProblemasDeSaude(novosProblemasDeSaude);

	            JOptionPane.showMessageDialog(null, "Dados do aluno alterados com sucesso!");
	        } else {
	            JOptionPane.showMessageDialog(null, "Não foi encontrado um aluno com o CPF fornecido.");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Não há alunos cadastrados.");
	    }
	}
	
	public void listarAlunos() {
	    if (listaDeAlunos == null || listaDeAlunos.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Não há alunos cadastrados.");
	        return;
	    }

	    StringBuilder mensagem = new StringBuilder("Lista de Alunos:\n");
	    int quantidadeElementos = listaDeAlunos.size();
    	mensagem.append("Quantidade de alunos cadastros é de: ").append(quantidadeElementos).append("\n");

	    for (Aluno aluno : listaDeAlunos) {
	        mensagem.append("Nome: ").append(aluno.getNome()).append("\n");
	        mensagem.append("CPF: ").append(aluno.getCpf()).append("\n");
	        mensagem.append("Email: ").append(aluno.getEmail()).append("\n");
	        mensagem.append("Telefone: ").append(aluno.getTelefone()).append("\n");
	        mensagem.append("Data de Nascimento: ").append(aluno.getDataNascimento()).append("\n");
	        mensagem.append("Peso: ").append(aluno.getPeso()).append("\n");
	        mensagem.append("Altura: ").append(aluno.getAltura()).append("\n");
	        mensagem.append("Problemas de Saúde: ").append(aluno.getProblemasDeSaude()).append("\n");
	        mensagem.append("\n");
	    }

	    JOptionPane.showMessageDialog(null, mensagem.toString());
	}


	//* Métodos - Professor -------------------------------------------------------------------------------------------------------------------
	
	public void cadastrarProfessor(String nome, String email, String cpf, String telefone, LocalDate dataNascimento, String turno, String capacitacao) {
		
		if (listaDeProfessores == null) {
            listaDeProfessores = new ArrayList<>();
        }

        if (existeProfessorComCPF(cpf)) {
            JOptionPane.showMessageDialog(null, "Já existe um professor cadastrado com este CPF!");
            return;
        }

        Professor novoProfessor = new Professor();
        novoProfessor.setNome(nome);
        novoProfessor.setEmail(email);
        novoProfessor.setCpf(cpf);
        novoProfessor.setTelefone(telefone);
        novoProfessor.setDataNascimento(dataNascimento);
        novoProfessor.setTurno(turno);
        novoProfessor.setCapacitacao(capacitacao);

        listaDeProfessores.add(novoProfessor);

        JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
    }
	
	public void excluirProfessor(String cpf) {
	    if (listaDeProfessores != null) {
	        Professor professorParaExcluir = null;

	        // Procurar o professor com o CPF fornecido
	        for (Professor professor : listaDeProfessores) {
	            if (professor.getCpf().equals(cpf)) {
	                professorParaExcluir = professor;
	                break;
	            }
	        }

	        // Remover o professor se encontrado
	        if (professorParaExcluir != null) {
	            listaDeProfessores.remove(professorParaExcluir);
	            JOptionPane.showMessageDialog(null, "Professor removido com sucesso!");
	        } else {
	            JOptionPane.showMessageDialog(null, "Não foi encontrado um professor com o CPF fornecido.");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Não há professores cadastrados.");
	    }
	}
	
	public void alterarProfessor(String cpf) {
	    if (listaDeProfessores != null) {
	        Professor professorParaAlterar = null;

	        // Procurar o professor com o CPF fornecido
	        for (Professor professor : listaDeProfessores) {
	            if (professor.getCpf().equals(cpf)) {
	                professorParaAlterar = professor;
	                break;
	            }
	        }

	        // Alterar os dados se o professor for encontrado
	        if (professorParaAlterar != null) {
	            String novoNome = JOptionPane.showInputDialog("Informe o novo nome do professor:");
	            String novoEmail = JOptionPane.showInputDialog("Informe o novo email do professor:");
	            String novoTelefone = JOptionPane.showInputDialog("Informe o novo telefone do professor:");
	            LocalDate novaDataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Informe a nova data de nascimento do professor (AAAA-MM-DD):"));
	            String novoTurno = JOptionPane.showInputDialog("Informe o novo turno do professor:");
	            String novaCapacitacao = JOptionPane.showInputDialog("Informe a nova capacitação do professor:");

	            professorParaAlterar.setNome(novoNome);
	            professorParaAlterar.setEmail(novoEmail);
	            professorParaAlterar.setTelefone(novoTelefone);
	            professorParaAlterar.setDataNascimento(novaDataNascimento);
	            professorParaAlterar.setTurno(novoTurno);
	            professorParaAlterar.setCapacitacao(novaCapacitacao);

	            JOptionPane.showMessageDialog(null, "Dados do professor alterados com sucesso!");
	        } else {
	            JOptionPane.showMessageDialog(null, "Não foi encontrado um professor com o CPF fornecido.");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Não há professores cadastrados.");
	    }
	}
	
	public void listarProfessores() {
	    if (listaDeProfessores == null || listaDeProfessores.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Não há professores cadastrados.");
	        return;
	    }

	    StringBuilder mensagem = new StringBuilder("Lista de Professores:\n");

	    for (Professor professor : listaDeProfessores) {
	        mensagem.append("Nome: ").append(professor.getNome()).append("\n");
	        mensagem.append("CPF: ").append(professor.getCpf()).append("\n");
	        mensagem.append("Email: ").append(professor.getEmail()).append("\n");
	        mensagem.append("Telefone: ").append(professor.getTelefone()).append("\n");
	        mensagem.append("Data de Nascimento: ").append(professor.getDataNascimento()).append("\n");
	        mensagem.append("Turno: ").append(professor.getTurno()).append("\n");
	        mensagem.append("Capacitação: ").append(professor.getCapacitacao()).append("\n");
	        mensagem.append("\n");
	    }

	    JOptionPane.showMessageDialog(null, mensagem.toString());
	}
	
	//* Métodos - Exercícios -------------------------------------------------------------------------------------------------------------------
	
	public void cadastrarExercicio(String nome, String equipamento, int carga, String serie, byte tempoDescanso) {
        if (listaDeExercicios == null) {
            listaDeExercicios = new ArrayList<>();
        }

        // Verifica se já existe um exercício com o mesmo nome
        if (existeExercicioComNome(nome)) {
            JOptionPane.showMessageDialog(null, "Já existe um exercício cadastrado com este nome!");
            return;
        }

        Exercicio novoExercicio = new Exercicio();
        novoExercicio.setNome(nome);
        novoExercicio.setEquipamento(equipamento);
        novoExercicio.setCarga(carga);
        novoExercicio.setSerie(serie);
        novoExercicio.setTempoDescanso(tempoDescanso);

        listaDeExercicios.add(novoExercicio);

        JOptionPane.showMessageDialog(null, "Exercício cadastrado com sucesso!");
    }

    private boolean existeExercicioComNome(String nome) {
        if (listaDeExercicios != null) {
            for (Exercicio exercicio : listaDeExercicios) {
                if (exercicio.getNome().equals(nome)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void excluirExercicio(String nome) {
        if (listaDeExercicios != null) {
            Exercicio exercicioParaExcluir = null;

            // Procurar o exercício com o nome fornecido
            for (Exercicio exercicio : listaDeExercicios) {
                if (exercicio.getNome().equals(nome)) {
                    exercicioParaExcluir = exercicio;
                    break;
                }
            }

            // Remover o exercício se encontrado
            if (exercicioParaExcluir != null) {
                listaDeExercicios.remove(exercicioParaExcluir);
                JOptionPane.showMessageDialog(null, "Exercício removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi encontrado um exercício com o nome fornecido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há exercícios cadastrados.");
        }
    }

    public void alterarExercicio(String nome) {
        if (listaDeExercicios != null) {
            Exercicio exercicioParaAlterar = null;

            // Procurar o exercício com o nome fornecido
            for (Exercicio exercicio : listaDeExercicios) {
                if (exercicio.getNome().equals(nome)) {
                    exercicioParaAlterar = exercicio;
                    break;
                }
            }

            // Alterar os dados se o exercício for encontrado
            if (exercicioParaAlterar != null) {
                String novoNome = JOptionPane.showInputDialog("Informe o novo nome do exercício:");
                String novoEquipamento = JOptionPane.showInputDialog("Informe o novo equipamento do exercício:");
                int novaCarga = Integer.parseInt(JOptionPane.showInputDialog("Informe a nova carga do exercício (Kg):"));
                String novaSerie = JOptionPane.showInputDialog("Informe a nova série do exercício:");
                byte novoTempoDescanso = Byte.parseByte(JOptionPane.showInputDialog("Informe o novo tempo de descanso do exercício (seg):"));

                exercicioParaAlterar.setNome(novoNome);
                exercicioParaAlterar.setEquipamento(novoEquipamento);
                exercicioParaAlterar.setCarga(novaCarga);
                exercicioParaAlterar.setSerie(novaSerie);
                exercicioParaAlterar.setTempoDescanso(novoTempoDescanso);

                JOptionPane.showMessageDialog(null, "Dados do exercício alterados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi encontrado um exercício com o nome fornecido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há exercícios cadastrados.");
        }
    }

    public void listarExercicios() {
        if (listaDeExercicios == null || listaDeExercicios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há exercícios cadastrados.");
            return;
        }

        StringBuilder mensagem = new StringBuilder("Lista de Exercícios:\n");

        for (Exercicio exercicio : listaDeExercicios) {
            mensagem.append("Nome: ").append(exercicio.getNome()).append("\n");
            mensagem.append("Equipamento: ").append(exercicio.getEquipamento()).append("\n");
            mensagem.append("Carga: ").append(exercicio.getCarga()).append("Kg\n");
            mensagem.append("Série: ").append(exercicio.getSerie()).append("\n");
            mensagem.append("Tempo de Descanso: ").append(exercicio.getTempoDescanso()).append("seg\n");
            mensagem.append("\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }
    
  //* Métodos - Treinos -------------------------------------------------------------------------------------------------------------------
    
    public void cadastrarTreino(String nome, String data, byte duracao, List<Exercicio> exercicios, Professor professor, Aluno aluno) {
        if (listaDeTreinos == null) {
            listaDeTreinos = new ArrayList<>();
        }

        Treino novoTreino = new Treino();
        novoTreino.setNome(nome);
        novoTreino.setData(data);
        novoTreino.setDuracao(duracao);
        novoTreino.setListaDeExercicios(exercicios);
        novoTreino.setProfessor(professor);

        // Associar treino ao aluno
        aluno.adicionarTreino(novoTreino);

        listaDeTreinos.add(novoTreino);

        JOptionPane.showMessageDialog(null, "Treino cadastrado com sucesso!");
    }
    
    public void excluirTreino(Aluno aluno, String nomeTreino) {
        if (listaDeTreinos != null) {
            Treino treinoParaExcluir = null;

            // Procurar o treino com o nome fornecido
            for (Treino treino : listaDeTreinos) {
                if (treino.getNome().equals(nomeTreino) && aluno.getTreinos().contains(treino)) {
                    treinoParaExcluir = treino;
                    break;
                }
            }

            // Remover o treino se encontrado
            if (treinoParaExcluir != null) {
                // Desassociar treino do aluno
                aluno.removerTreino(treinoParaExcluir);

                listaDeTreinos.remove(treinoParaExcluir);
                JOptionPane.showMessageDialog(null, "Treino removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi encontrado um treino com o nome fornecido para este aluno.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há treinos cadastrados.");
        }
    }
    
    public void alterarTreino(Aluno aluno, String nomeTreino) {
        if (aluno.getTreinos() != null) {
            Treino treinoParaAlterar = null;

            // Procurar o treino com o nome fornecido
            for (Treino treino : aluno.getTreinos()) {
                if (treino.getNome().equals(nomeTreino)) {
                    treinoParaAlterar = treino;
                    break;
                }
            }

            // Alterar os dados se o treino for encontrado
            if (treinoParaAlterar != null) {
                String novoNome = JOptionPane.showInputDialog("Informe o novo nome do treino:");
                String novaData = JOptionPane.showInputDialog("Informe a nova data do treino:");
                byte novaDuracao = Byte.parseByte(JOptionPane.showInputDialog("Informe a nova duração do treino (min):"));

                treinoParaAlterar.setNome(novoNome);
                treinoParaAlterar.setData(novaData);
                treinoParaAlterar.setDuracao(novaDuracao);

                JOptionPane.showMessageDialog(null, "Dados do treino alterados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi encontrado um treino com o nome fornecido para este aluno.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há treinos cadastrados para este aluno.");
        }
    }
    
    public void listarTreinos(Aluno aluno) {
        if (aluno.getTreinos() == null || aluno.getTreinos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há treinos cadastrados para este aluno.");
            return;
        }

        StringBuilder mensagem = new StringBuilder("Lista de Treinos:\n");

        for (Treino treino : aluno.getTreinos()) {
        	mensagem.append("Aluno: ").append(aluno.getNome()).append("\n");
            mensagem.append("Nome: ").append(treino.getNome()).append("\n");
            mensagem.append("Data: ").append(treino.getData()).append("\n");
            mensagem.append("Duração: ").append(treino.getDuracao()).append("min\n");
            mensagem.append("Professor: ").append(treino.getProfessor().getNome()).append("\n");

            // Listar exercícios vinculados ao treino
            if (treino.getListaDeExercicios() != null && !treino.getListaDeExercicios().isEmpty()) {
                mensagem.append("Exercícios:\n");
                for (Exercicio exercicio : treino.getListaDeExercicios()) {
                    mensagem.append("- Nome: ").append(exercicio.getNome()).append("\n");
                    mensagem.append("- Equipamento: ").append(exercicio.getEquipamento()).append("\n");
                    mensagem.append("- Carga: ").append(exercicio.getCarga()).append(" Kg\n");
                    mensagem.append("- Serie: ").append(exercicio.getSerie()).append("\n");
                    mensagem.append("- Tempo de descanso: ").append(exercicio.getTempoDescanso()).append(" seg\n");
                    
                }
            } else {
                mensagem.append("Nenhum exercício vinculado a este treino.\n");
            }

            mensagem.append("\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }
    
    public Exercicio encontrarExercicioPorNome(String nome) {
        if (listaDeExercicios != null) {
            for (Exercicio exercicio : listaDeExercicios) {
                if (exercicio.getNome().equals(nome)) {
                    return exercicio;
                }
            }
        }
        return null;
    }
	
}



