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
        Connection con = null;

        do {
            System.out.println("Opções: ");
            System.out.println("1 - Cadastrar Evento");
            System.out.println("2 - Cadastrar Local");
            System.out.println("3 - Cadastrar Notificacao");
            System.out.println("4 - Cadastrar Organizador");
            System.out.println("5 - Cadastrar Participante");
            System.out.println("6 - Cadastrar Pessoa");
            System.out.println("7 - Listar Evento");
            System.out.println("8 - Listar Local");
            System.out.println("9 - Listar Notificacao");
            System.out.println("10 - Listar Organizador");
            System.out.println("11 - Listar Participante");
            System.out.println("12 - Listar Pessoa");
            System.out.println("13 - Atualizar Evento"); // ola prof, colocamos só um delete e update por que foi o que
                                                         // deu tempo :D
            System.out.println("14 - Deletar Evento");
            System.out.println("15 - Saindo.....");
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
                        System.out.println("Informe id do organizador: ");
                        Integer idOrganizador = scanner.nextInt();
                        System.out.println("Informe o id do local: ");
                        Integer idLocal = scanner.nextInt();
                        System.out.println("Informe a data do evento: ");
                        String dataEvento = scanner.next();

                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        stm.executeUpdate("INSERT INTO Evento"
                                + "(idEvento , idOrganizador, idLocal , dataEvento) VALUES "
                                + "('" + idEvento + "', '" + idOrganizador + "', '" + idLocal + "', '" + dataEvento
                                + "')");

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        con.close();
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.println("Informe o id do local: ");
                        Integer idLocal = scanner.nextInt();
                        scanner.nextLine(); /* sempre que for pra pular linha tem q colocar netxLine */
                        System.out.println("Informe a descrição do local: ");
                        String descricaoLocal = scanner.nextLine();
                        System.out.println("Informe as vagas do local: ");
                        String vagasLocal = scanner.next();

                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        stm.executeUpdate("INSERT INTO Local "
                                + "(idLocal , descricaoLocal , vagasLocal) VALUES "
                                + "('" + idLocal + "', '" + descricaoLocal + "', '" + vagasLocal + "')");

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        con.close();
                    }
                    break;
                }
                case 3: {
                    try {
                        System.out.println("Informe o id da notificação: ");
                        Integer idNotificacao = scanner.nextInt();
                        System.out.println("Informe o tipo de notificação: ");
                        String tipoNotificacao = scanner.next();
                        scanner.nextLine();
                        System.out.println("Informe o conteudo da notificação: ");
                        String conteudoNotificacao = scanner.nextLine();

                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        stm.executeUpdate("INSERT INTO Notificacao "
                                + "(idNotificacao, tipoNotificacao , conteudoNotificacao) VALUES "
                                + "('" + idNotificacao + "', '" + tipoNotificacao + "', '" + conteudoNotificacao
                                + "')");

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        con.close();
                    }
                    break;
                }
                case 4: {
                    try {
                        System.out.println("Informe o id do organizador: ");
                        Integer idOrganizador = scanner.nextInt();
                        System.out.println("Informe o email do organizador: ");
                        String emailOrganizador = scanner.next();
                        System.out.println("Informe o id da notificacao: ");
                        Integer idNotificacao = scanner.nextInt();

                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        stm.executeUpdate("INSERT INTO Organizador "
                                + "(idOrganizador , emailOrganizador, idNotificacao) VALUES "
                                + "('" + idOrganizador + "', '" + emailOrganizador + "' , '" + idNotificacao + "')");

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        con.close();
                    }
                    break;
                }
                case 5: {
                    try {
                        System.out.println("Informe o id do participante: ");
                        Integer idParticipante = scanner.nextInt();
                        System.out.println("Informe o telefone do participante: ");
                        String telefoneParticipante = scanner.next();
                        System.out.println("Informe o id da notificação: ");
                        Integer idNotificacao = scanner.nextInt();

                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        stm.executeUpdate("INSERT INTO Participante "
                                + "(idParticipante , telefoneParticipante, idNotificacao) VALUES "
                                + "('" + idParticipante + "', '" + telefoneParticipante + "', '" + idNotificacao
                                + "')");

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {

                        con.close();
                    }
                    break;
                }

                case 6: {
                    try {
                        System.out.println("Informe o id da pessoa(): ");
                        Integer idPessoa = scanner.nextInt();
                        System.out.println("Informe o nome da pessoa: ");
                        String nomePessoa = scanner.next();

                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        stm.executeUpdate("INSERT INTO Pessoa "
                                + "(idPessoa , nomePessoa) VALUES "
                                + "('" + idPessoa + "', '" + nomePessoa + "')");

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        con.close();
                    }
                    break;
                }
                // select//select//select//select//select//select//select//select//select
                // select//select//select//select//select//select//select//select//select
                case 7:
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM evento;");
                        while (sql.next()) {
                            System.out.println(
                                    "Id: " + sql.getInt("idEvento")
                                            + " Id do Organizador: " + sql.getInt("idOrganizador")
                                            + " Id do Local: " + sql.getInt("idLocal")
                                            + " Data do Evento: " + sql.getString("dataEvento"));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM local;");
                        while (sql.next()) {
                            System.out.println(
                                    "Id: " + sql.getInt("idLocal")
                                            + " Descrição do local: " + sql.getString("descricaoLocal")
                                            + " Vagas Local: " + sql.getInt("vagasLocal"));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 9:
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM notificacao;");
                        while (sql.next()) {
                            System.out.println(
                                    "Id: " + sql.getInt("idNotificacao")
                                            + "Tipo da notificação: " + sql.getString("tipoNotificacao")
                                            + " Conteúdo da notificação: " + sql.getString("conteudoNotificacao"));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 10:
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM organizador;");
                        while (sql.next()) {
                            System.out.println(
                                    "Id: " + sql.getInt("idOrganizador")
                                            + "Email do Organizador: " + sql.getString("emailOrganizador")
                                            + "Id da notificação: " + sql.getInt("idNotificacao"));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 11:
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM participante;");
                        while (sql.next()) {
                            System.out.println(
                                    "Id: " + sql.getInt("idParticipante")
                                            + "Telefone do participante: " + sql.getString("telefoneParticipante")
                                            + "Id da notificação: " + sql.getInt("idNotificacao"));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 12:
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM pessoa;");
                        while (sql.next()) {
                            System.out.println(
                                    "Id: " + sql.getInt("idPessoa")
                                            + "Nome da pessoa: " + sql.getString("nomePessoa"));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 13:
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        System.out.println("Informe o id do evento a ser atualizado: ");
                        int idEvento = scanner.nextInt();
                        System.out.println("Informe o novo id do organizador: ");
                        int idOrganizador = scanner.nextInt();
                        System.out.println("Informe o novo id do local: ");
                        int idLocal = scanner.nextInt();
                        System.out.println("Informe a nova data do evento (yyyy-mm-dd): ");
                        String dataEvento = scanner.next();

                        String query = "UPDATE Evento SET idOrganizador = ?, idLocal = ?, dataEvento = ? WHERE idEvento = ?";
                        PreparedStatement pstmt = con.prepareStatement(query);
                        pstmt.setInt(1, idOrganizador);
                        pstmt.setInt(2, idLocal);
                        pstmt.setString(3, dataEvento);
                        pstmt.setInt(4, idEvento);
                        pstmt.executeUpdate();
                        System.out.println("Evento atualizado com sucesso!");

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        if (con != null) {
                            try {
                                con.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                case 14: { // Deletar Evento (DELETE)
                    try {
                        con = DriverManager.getConnection(url, user, password);
                        System.out.println("Informe o id do evento a ser deletado: ");
                        int idEvento = scanner.nextInt();

                        String query = "DELETE FROM Evento WHERE idEvento = ?";
                        PreparedStatement pstmt = con.prepareStatement(query);
                        pstmt.setInt(1, idEvento);

                        System.out.println(
                                pstmt.executeUpdate() > 0 ? "Evento deletado com sucesso!" : "Evento não encontrado.");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        try {
                            if (con != null)
                                con.close();
                        } catch (SQLException e) {
                            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                        }
                    }
                    break;
                }
                case 15:
                    System.out.println("Saindo...");
                    break;
            }
        } while (opt != 15);
        scanner.close();
    }
}