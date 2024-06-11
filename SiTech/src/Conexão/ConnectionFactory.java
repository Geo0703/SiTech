
package Conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
        
public class ConnectionFactory {
    private String usuario = "root";
    private String senha = "root";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "Sitech";

    public ConnectionFactory() {
        this.bd = "Sitech";
    }

    public Connection obtemConexao() throws SQLException {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + porta + "/" + bd
                    + "?useTimezone=true&serverTimezone=UTC",
                    usuario, senha);
            System.out.println("Conexão efetuada com sucesso!!");
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro na conexão com o banco de dados!");
            return null;
        }

    }

}

