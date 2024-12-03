import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws Exception {
        int opt = 0;
        final String url = "jdbc:mysql://localhost:3306/eventojava";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Opções: ");
            System.out.println("1 - Cadastrar Evento"); // insert \/
            System.out.println("2 - Cadastrar Local"); // insert \/
            System.out.println("3 - Cadastrar Notificacao"); // insert \/
            System.out.println("3 - Cadastrar Organizador"); // insert \/
            System.out.println("3 - Cadastrar Participante"); // insert
            System.out.println("3 - Cadastrar Pessoa"); // insert
            System.out.println("1 - Listar Evento"); // select
            System.out.println("2 - Listar Local"); // select
            System.out.println("3 - Listar Notificacao"); // select
            System.out.println("3 - Listar Organizador"); // select
            System.out.println("3 - Listar Participante"); // select
            System.out.println("3 - Listar Pessoa"); // select
            System.out.println("7 - Saindo.....");
            try {
                opt = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            switch (opt) {
                case 1: {
                    try {
                        System.out.println("Informe o id do evento: ");
                        Integer idEvento = scanner.nextInt();
                        System.out.println("Informe a data do evento: ");
                        String dataEvento = scanner.next();

                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO Evento"
                                + "(idEvento , dataEvento) VALUES "
                                + "('" + idEvento + "', '" + dataEvento + "')");
                        if (!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.println("Informe o id do local: ");
                        Integer idLocal = scanner.nextInt();
                        System.out.println("Informe a descrição do local: ");
                        String descricaoLocal = scanner.next();
                        System.out.println("Informe as vagas do local: ");
                        String vagasLocal = scanner.next();

                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO Local "
                                + "(idLocal , descricaoLocal , vagasLocal) VALUES "
                                + "('" + idLocal + "', '" + descricaoLocal + "', '" + vagasLocal + "')");
                        if (!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    try {
                        System.out.println("Informe o tipo de notificação: ");
                        String tipoNotificacao = scanner.next();
                        System.out.println("Informe a data de nascimento do aluno");
                        String conteudoNotificacao = scanner.next();

                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO Notificacao "
                                + "(tipoNotificacao , conteudoNotificacao) VALUES "
                                + "('" + tipoNotificacao + "', '" + conteudoNotificacao + "')");
                        if (!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {
                    try {
                        System.out.println("Informe o id do organizador: ");
                        Integer idOrganizador = scanner.nextInt();
                        System.out.println("Informe o email do organizador: ");
                        String emailOrganizador = scanner.next();

                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO Organizador "
                                + "(idOrganizador , emailOrganizador) VALUES "
                                + "('" + idOrganizador + "', '" + emailOrganizador + "')");
                        if (!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5: {
                    try {
                        System.out.println("Informe o id do participante: ");
                        Integer idParticipante = scanner.nextInt();
                        System.out.println("Informe o telefone do participante: ");
                        String telefoneParticipante = scanner.next();

                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO Participante "
                                + "(idParticipante , telefoneParticipante) VALUES "
                                + "('" + idParticipante + "', '" + telefoneParticipante + "')");
                        if (!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 6: {
                    try {
                        System.out.println("Informe o id da pessoa(): ");
                        Integer idPessoa = scanner.nextInt();
                        System.out.println("Informe o nome da pessoa: ");
                        String nomePessoa = scanner.next();

                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO Pessoa "
                                + "(idPessoa , nomePessoa) VALUES "
                                + "('" + idPessoa + "', '" + nomePessoa + "')");
                        if (!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                // select//select//select//select//select//select//select//select//select
                case 7: {
                    try {
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM evento;");
                        while (sql.next()) {
                            System.out.println(new Professor(
                                    sql.getInt("idEvento"),
                                    sql.getString("idOrganizador"),
                                    sql.getString("departamento")

                            ));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println("- - - - - - - - - - - -");

                    break;
                }
                case 5:
                    try {
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM evento;");
                        while (sql.next()) {
                            ResultSet sqlCurso = stm
                                    .executeQuery(
                                            "SELECT * FROM curso WHERE id = " + sql.getInt("idOrganizador") + ";");

                            if (sqlCurso.next()) {
                                ResultSet sqlProfessor = stm.executeQuery(
                                        "SELECT * FROM professor WHERE id = " + sqlCurso.getInt("idProfessor") + ";");

                                if (sqlProfessor.next()) {
                                    Professor professor = new Professor(
                                            sqlProfessor.getInt("idProfessor"),
                                            sqlProfessor.getString("nomeProfessor"),
                                            sqlProfessor.getString("departamento"));

                                    Curso curso = new Curso(
                                            sqlCurso.getInt("idCurso"),
                                            sqlCurso.getString("nomeCurso"),
                                            sqlCurso.getInt("carga_horaria"),
                                            professor);

                                    System.out.println(new Aluno(
                                            sql.getInt("idAluno"),
                                            sql.getString("nomeAluno"),
                                            sql.getString("dataNasc"),
                                            sql.getString("Cpf"),
                                            curso));
                                }
                            }
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM curso;");
                        while (sql.next()) {
                            ResultSet sqlProfessor = stm.executeQuery(
                                    "SELECT * FROM professor WHERE id = " + sql.getInt("idProfessor") + ";");

                            if (sqlProfessor.next()) {
                                Professor professor = new Professor(
                                        sqlProfessor.getInt("idProfessor"),
                                        sqlProfessor.getString("nomeProfessor"),
                                        sqlProfessor.getString("departamentoProf"));

                                System.out.println(new Curso(
                                        sql.getInt("idCurso"),
                                        sql.getString("nomeCurso"),
                                        sql.getInt("carga_horaria"),
                                        professor));
                            }
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

            }

        } while (opt != 7);
        scanner.close();
    }
}