package bancoDados;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class TestDB {

    @Test
    public void testBancoDados() throws SQLException {
        OracleDb oracleDb = new OracleDb();
        oracleDb.createConnection();
        String valor = oracleDb.executeSelect("SELECT *FROM DADOS_USERS WHERE ID_USER =2");
        Assert.assertEquals("SILAS LEAO", valor);
    }

    @Test
    public void testInserindoValor() throws SQLException {
        OracleDb oracleDb = new OracleDb();
        oracleDb.createConnection();
        oracleDb.insertQuery("INSERT INTO DADOS_USERS (ID_USER, NOME,CPF,ENDERECO)\n" +
                "VALUES (3, 'JOSE LEAO', '34567890820', 'RUA DE TAL')");
        String valor = oracleDb.executeSelect("SELECT *FROM DADOS_USERS WHERE ID_USER =3");
        Assert.assertEquals("JOSE LEAO", valor);
    }
}
