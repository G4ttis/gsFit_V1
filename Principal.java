package gsFit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Principal {
	
	public static void main(String[] args) {
		Academia academia = new Academia();
		
		// Adcionando o professor admin
		
		Professor admin = new Professor();
        admin.setNome("Matheus Lancaster");
        admin.setEmail("matheus.Lancaster@gmail.com");
        admin.setCpf("999.999.999-99");
        admin.setTelefone("(47) 99999-9999");
        admin.setDataNascimento(LocalDate.of(2002, 9, 7));
        admin.setTurno("Matutino");
        admin.setCapacitacao("Mestrado em Educação Física e Bem-Estar");
        
        academia.cadastrarProfessor(admin.getNome(), admin.getEmail(), admin.getCpf(), admin.getTelefone(), admin.getDataNascimento(), admin.getTurno(), admin.getCapacitacao());

		
		Object[] opcoes = {"Aluno", "Professor"};
		
        while (true) { // Loop principal / escolha entre aluno/professor
  		
        		int escolha = JOptionPane.showOptionDialog(null, "Você é aluno ou professor?", "Menu",
        				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        		if (escolha == 0) { // Loop Aluno
        	
        			String cpfParaVerificar = JOptionPane.showInputDialog("Informe o seu CPF para entrar na seção do aluno: ");
        				if (academia.existeAlunoComCPF(cpfParaVerificar)) {
        					
        					while(true) { // Sub-Loop aluno
    							String[] opcoesMenu = {"1 - Exibir treino"};
    							
    							JComboBox<String> comboBox = new JComboBox<>(opcoesMenu);
    							comboBox.setEditable(false);
    							
    							int opcao = JOptionPane.showOptionDialog(
    				                    null,
    				                    comboBox,
    				                    "Menu do aluno",
    				                    JOptionPane.OK_CANCEL_OPTION,
    				                    JOptionPane.PLAIN_MESSAGE,
    				                    null,
    				                    null,
    				                    null);
    							
    							if (opcao == JOptionPane.CANCEL_OPTION || opcao == JOptionPane.CLOSED_OPTION) {
    							    break;
    							}
    							
    							switch (comboBox.getSelectedItem().toString()) {
    						    case "1 - Exibir treino":
    						    	listarTreinos(academia);
    						        break;
    						    default:
    						        JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
    							}    
        					}     				
        				} else {
        					int opcao = JOptionPane.showConfirmDialog(null, "O CPF não foi localizado, deseja tentar novamente??", "Aviso", JOptionPane.YES_NO_OPTION);
        						if (opcao != JOptionPane.YES_OPTION) {
        							return;
        							}
        				}
            
        		} else if (escolha == 1) { // Loop professor
        		
        				String cpfParaVerificar = JOptionPane.showInputDialog("Informe o seu CPF para entrar na seção do professor:");
        					if (academia.existeProfessorComCPF(cpfParaVerificar)) {
        				
        						while(true) { // Sub-loop professor
        							String[] opcoesMenu = {"1 - Cadastrar aluno", "2 - Excluir aluno", "3 - Alterar aluno", "4 - Listar alunos", 
        									"5 - Cadastrar professor", "6 - Excluir professor", "7 - Alterar professor", "8 - Listar professores", 
        									"9 - Cadastrar exercício", "10 - Excluir exercício", "11 - Alterar exercício", "12 - Listar exercícios",
        				                    "13 - Cadastrar treino", "14 - Excluir treino", "15 - Alterar treino", "16 - Listar treinos"
        				            };
        							
        							JComboBox<String> comboBox = new JComboBox<>(opcoesMenu);
        							comboBox.setEditable(false);
        							
        							int opcao = JOptionPane.showOptionDialog(
        				                    null,
        				                    comboBox,
        				                    "Menu do Professor",
        				                    JOptionPane.OK_CANCEL_OPTION,
        				                    JOptionPane.PLAIN_MESSAGE,
        				                    null,
        				                    null,
        				                    null);
        							
        							if (opcao == JOptionPane.CANCEL_OPTION || opcao == JOptionPane.CLOSED_OPTION) {
        							    break;
        							}
        							
        							switch (comboBox.getSelectedItem().toString()) {
        						    case "1 - Cadastrar aluno":
        						    	cadastrarAluno(academia);
        						        break;
        						    case "2 - Excluir aluno":
        						    	String cpfExcluirAluno = JOptionPane.showInputDialog("Informe o CPF do aluno a ser excluído: ");
        						    	academia.excluirAluno(cpfExcluirAluno);
        						        break;
        						    case "3 - Alterar aluno":
        						    	String cpfAlterarAluno = JOptionPane.showInputDialog("Informe o CPF do aluno a ser alterado:");
        						        academia.alterarAluno(cpfAlterarAluno);
        						        break;
        						    case "4 - Listar alunos":
        						    	academia.listarAlunos();
        						        break;
        						    case "5 - Cadastrar professor":
        						        cadastrarProfessor(academia);
        						        break;
        						    case "6 - Excluir professor":
        						    	String cpfExcluirProfessor = JOptionPane.showInputDialog("Informe o CPF do professor a ser excluído:");
        						        academia.excluirProfessor(cpfExcluirProfessor);
        						        break;
        						    case "7 - Alterar professor":
        						    	String cpfAlterarProfessor = JOptionPane.showInputDialog("Informe o CPF do professor a ser alterado:");
        						        academia.alterarProfessor(cpfAlterarProfessor);
        						        break;
        						    case "8 - Listar professores":
        						        academia.listarProfessores();
        						        break;
        						    case "9 - Cadastrar exercício":
        						        cadastrarExercicio(academia);
        						        break;
        						    case "10 - Excluir exercício":
        						        String exercicioParaExcluir = JOptionPane.showInputDialog("Informe o nome do exercício a ser excluído:");
        						        academia.excluirExercicio(exercicioParaExcluir);
        						        break;
        						    case "11 - Alterar exercício":
        						        String exercicioParaAlterar = JOptionPane.showInputDialog("Informe o nome do exercício a ser alterado:");
        						        academia.alterarExercicio(exercicioParaAlterar);
        						        break;
        						    case "12 - Listar exercícios":
        						    	academia.listarExercicios();
        						        break;
        						    case "13 - Cadastrar treino":
        						    	cadastrarTreino(academia);
        						        break;
        						    case "14 - Excluir treino":
        						    	excluirTreino(academia);
        						        break;
        						    case "15 - Alterar treino":
        						        alterarTreino(academia);
        						        break;
        						    case "16 - Listar treinos":
        						    	listarTreinos(academia);
        						        break;
        						    default:
        						        JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente.");
        						}

        						}
                
        					} else {
        						int opcao = JOptionPane.showConfirmDialog(null, "O CPF não foi localizado, deseja tentar novamente?", "Aviso", JOptionPane.YES_NO_OPTION);
                            		if (opcao != JOptionPane.YES_OPTION) {
                            			return;
                            			}	
        					}  	
        		}
        }
        
        
	} // Fecha a seção main

    // Métodos
    
    private static void cadastrarProfessor(Academia academia) {
        String nome = JOptionPane.showInputDialog("Informe o nome do professor: ");
        String email = JOptionPane.showInputDialog("Informe o email do professor: ");
        String cpf = JOptionPane.showInputDialog("Informe o CPF do professor: ");
        String telefone = JOptionPane.showInputDialog("Informe o telefone do professor: ");
        LocalDate dataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Informe a data de nascimento do professor (AAAA-MM-DD): "));
        String turno = JOptionPane.showInputDialog("Informe o turno do professor: ");
        String capacitacao = JOptionPane.showInputDialog("Informe a capacitação do professor: ");

        academia.cadastrarProfessor(nome, email, cpf, telefone, dataNascimento, turno, capacitacao);
    }
    
    private static void cadastrarAluno(Academia academia) {
        String nome = JOptionPane.showInputDialog("Informe o nome do aluno: ");
        String email = JOptionPane.showInputDialog("Informe o email do aluno: ");
        String cpf = JOptionPane.showInputDialog("Informe o CPF do aluno: ");
        String telefone = JOptionPane.showInputDialog("Informe o telefone do aluno: ");
        LocalDate dataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Informe a data de nascimento do aluno (AAAA-MM-DD): "));
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Informe o peso do aluno (Kg): "));
        double altura = Double.parseDouble(JOptionPane.showInputDialog("Informe a altura do aluno (m): "));
        String problemasDeSaude = JOptionPane.showInputDialog("Informe os problemas de saúde do aluno: ");

        academia.cadastrarAluno(nome, email, cpf, telefone, dataNascimento, peso, altura, problemasDeSaude);
    }
    
    private static void cadastrarExercicio(Academia academia) {
        String nomeExercicio = JOptionPane.showInputDialog("Informe o nome do exercício:");
        String equipamento = JOptionPane.showInputDialog("Informe o equipamento utilizado:");
        int carga = Integer.parseInt(JOptionPane.showInputDialog("Informe a carga do exercício:"));
        String serie = JOptionPane.showInputDialog("Informe a série do exercício:");
        byte tempoDescanso = Byte.parseByte(JOptionPane.showInputDialog("Informe o tempo de descanso (seg):"));

        academia.cadastrarExercicio(nomeExercicio, equipamento, carga, serie, tempoDescanso);
    }
    
    private static void cadastrarTreino(Academia academia) {
        String cpfAluno = JOptionPane.showInputDialog("Informe o CPF do aluno: ");
        Aluno aluno = academia.encontrarAlunoPorCPF(cpfAluno);

        if (aluno != null) {
        	String nome = JOptionPane.showInputDialog("Informe o nome do treino: ");
            String data = JOptionPane.showInputDialog("Informe a data do treino (AAAA-MM-DD): ");
            byte duracao = Byte.parseByte(JOptionPane.showInputDialog("Informe a duração do treino (min):"));

            List<Exercicio> exercicios = obterDadosTreino(academia);
            Professor professor = obterProfessor(academia);

            academia.cadastrarTreino(nome, data, duracao, exercicios, professor, aluno);
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
        }
    }
    
    private static void excluirTreino(Academia academia) {
    	String cpfAluno = JOptionPane.showInputDialog("Informe o CPF do aluno: ");
    	Aluno aluno = academia.encontrarAlunoPorCPF(cpfAluno);
    	
    	String nomeTreino = JOptionPane.showInputDialog("Informe o nome do treino que deseja excluir:");
    	
    	
    	academia.excluirTreino(aluno, nomeTreino);
    }
    
    private static void alterarTreino(Academia academia) {
    	String cpfAluno = JOptionPane.showInputDialog("Informe o CPF do aluno: ");
    	Aluno aluno = academia.encontrarAlunoPorCPF(cpfAluno);
    	
    	String nomeTreino = JOptionPane.showInputDialog("Informe o nome do treino que deseja alterar:");
    	
    	academia.alterarTreino(aluno, nomeTreino);
    }

    private static void listarTreinos(Academia academia) {
    	String cpfAluno = JOptionPane.showInputDialog("Informe o CPF do aluno: ");
    	Aluno aluno = academia.encontrarAlunoPorCPF(cpfAluno);
    	
    	academia.listarTreinos(aluno);
    }
    
    // Métodos utilizados dentro do método cadastrarTreino
    
    private static Professor obterProfessor(Academia academia) {
        String cpfProfessor = JOptionPane.showInputDialog("Informe o CPF do professor:");
        return academia.encontrarProfessorPorCPF(cpfProfessor);
    }
    
    private static List<Exercicio> obterDadosTreino(Academia academia) {
        List<Exercicio> exercicios = new ArrayList<>();

        while (true) {
            String nomeExercicio = JOptionPane.showInputDialog("Informe o nome do exercício (ou digite 'fim' para encerrar):");
            if (nomeExercicio.equalsIgnoreCase("fim")) {
                break;
            }

            Exercicio exercicio = academia.encontrarExercicioPorNome(nomeExercicio);

            if (exercicio != null) {
                exercicios.add(exercicio);
            } else {
                JOptionPane.showMessageDialog(null, "Exercício não encontrado.");
            }
        }

        return exercicios;
    }
  
} // Fecha a classe Principal
