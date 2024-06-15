
package Conexão;

import java.sql.SQLException;


public class TesteDeConexão {
    public static void main(String[] args) throws SQLException {
       ConnectionFactory Lig=new ConnectionFactory();
     Lig.obtemConexao();
    }
    }
    

