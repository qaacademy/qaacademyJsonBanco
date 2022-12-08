package bancoDados;

import java.sql.*;


public class OracleDb {
    Connection connection;
    public void createConnection() throws SQLException {
        try {
            System.out.println("Iniciando conexão com o banco");
            String serverName = "localhost";
            String portNumber = "1521";
            String sid = "XE";
            String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
            String username = "system";
            String password = "admin";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new SQLException("Erro conexao " + e);
        }
    }

    public String executeSelect(String query) throws SQLException {
        String dado = "";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            dado = rs.getString("NOME");
            System.out.println(dado);
        }

        stmt.close();
        connection.close();
        System.out.println("Conexões com Banco Fechadas");
        return dado;
    }

    public void insertQuery( String sqlInsert) throws SQLException {
        try {
            Statement stmt = connection.createStatement();
            connection.setAutoCommit(false);
            System.out.println("Inserindo Dados de Teste em execução ...");
            int statusInsert = stmt.executeUpdate(sqlInsert);
            if (statusInsert == 1) {
                System.out.println("Dados de Teste inseridos com sucesso!");
                connection.commit();
            }else {
                System.out.println("Erro ao inserir Dados de Teste");
                connection.rollback();
            }
            stmt.close();
            //connection.close();
            System.out.println("Conexões com Banco Fechadas");

        } catch (Exception e) {
            throw new SQLException(e);
        }

    }

}
