import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        int opt = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Professor> professores = new ArrayList<Professor>();
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        do {
            System.out.println("Opções: ");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Listar Professor");
            System.out.println("5 - Listar Curso");
            System.out.println("6 - Listar Aluno");
            System.out.println("7 - Saindo.....");
            try {
                opt = scanner.nextInt();

                switch (opt) {
                    case 1: {
                        System.out.println("Digite o id do professor: ");
                        int idProfessor = scanner.nextInt();
                        System.out.println("Digite o nome do professor: ");
                        String nomeProfessor = scanner.next();
                        System.out.println("Digite o departamento do professor: ");
                        String departamento = scanner.next();

                        Professor professor = new Professor(idProfessor, nomeProfessor, departamento);
                        professores.add(professor);

                        break;
                    }

                    case 2: {
                        System.out.println("Digite o id do curso: ");
                        int idCurso = scanner.nextInt();
                        System.out.println("Digite o nome do curso: ");
                        String nomeCurso = scanner.next();
                        System.out.println("Digite a carga horária do curso: ");
                        int carga_horaria = scanner.nextInt();
                        System.out.println("Digite o Id do professor responsável pelo curso: ");
                        int professorCurso = scanner.nextInt();
                        Professor prof = null;
                        for (Professor professor : professores) {
                            if (professor.idProfessor == professorCurso) {
                                prof = professor;
                            }
                            ;
                        }
                        ;

                        if (prof != null) {
                            Curso curso = new Curso(idCurso, nomeCurso, carga_horaria, prof);
                            cursos.add(curso);
                        } else {
                            System.out.println("Id do professor inválido, tente novamente");
                        }

                        break;
                    }
                    case 3: {
                        System.out.println("Digite o id do aluno: ");
                        int idAluno = scanner.nextInt();
                        System.out.println("Digite o nome do aluno: ");
                        String nomeAluno = scanner.next();
                        System.out.println("Digite a data de nascimento do aluno: ");
                        String dataNasc = scanner.next();
                        System.out.println("Digite o cpf do aluno: ");
                        String Cpf = scanner.next();
                        System.out.println("Digite o Id do curso que o aluno frequenta: ");
                        int cursoAluno = scanner.nextInt();
                        Curso cursoAtual = null;
                        for (Curso curso : cursos) {
                            if (curso.idCurso == cursoAluno) {
                                cursoAtual = curso;
                            }
                        }

                        if (cursoAtual != null) {
                            Aluno aluno1 = new Aluno(idAluno, nomeAluno, dataNasc, Cpf, cursoAtual);
                            alunos.add(aluno1);
                        } else {
                            System.out.println("Id do curso inválido, tente novamente");
                        }

                        break;
                    }
                    case 4:
                        for (Professor professorPrint : professores) {
                            System.out.println("Nome do professor: " + professorPrint.nomeProfessor);
                            System.out.println("Departamento: " + professorPrint.departamento);
                            for (Curso curso : cursos) {
                                if (curso.professorCurso.idProfessor == professorPrint.idProfessor) {
                                    System.out.println("Cursos lecionados pelo professor:" + curso.nomeCurso);
                                    int contadorAlunos = 0;
                                    for (Aluno aluno : alunos) {
                                        if (aluno.cursoAluno.idCurso == curso.idCurso) {
                                            contadorAlunos++;
                                        }
                                    }
                                    System.out.println("Total de alunos no curso: " + contadorAlunos);
                                }
                            }
                            System.out.println("- - - - - - - - - - - -");

                        }
                        // deverá ser impresso o nome do Professor e o Departamento e todos os cursos no
                        // qual ele está associado, com a respectiva quantidade de alunos.
                        break;
                    case 5:
                        for (Curso cursoPrint : cursos) {
                            System.out.println("Nome do curso: " + cursoPrint.nomeCurso);
                            System.out.println("Carga horária do curso: " + cursoPrint.carga_horaria);
                            System.out.println(
                                    "Nome do professor responsavel: " + cursoPrint.professorCurso.nomeProfessor);
                            // Na listagem de Cursos, deverá ser impresso o nome do Curso, a Carga Horária e
                            // o nome do Professor.
                        }
                        break;
                    case 6:
                        for (Aluno alunoPrint : alunos) {
                            System.out.println("Nome do aluno: " + alunoPrint.nomeAluno);
                            System.out.println("Data de nascimento: " + alunoPrint.dataNasc);
                            System.out.println("Cpf do aluno: " + alunoPrint.Cpf);
                            System.out.println("Nome do curso: " + alunoPrint.cursoAluno.nomeCurso);
                            // Na listagem de Alunos, deverá ser impresso o nome do Aluno, a Data de
                            // Nascimento, o C.P.F. e o nome do Curso.
                        }
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Opção inválida");
                scanner.nextLine();
                continue;
            }
        } while (opt != 7);

        scanner.close();
    }

}