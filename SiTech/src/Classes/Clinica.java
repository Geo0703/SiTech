
package Classes;

import Conexão.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Clinica {
   private String Nome_do_Medico;
   private String CRM;
   private String Senha;


    public String getNome_do_Medico() {
        return Nome_do_Medico;
    }

    public void setNome_do_Medico(String Nome_do_Medico) {
        this.Nome_do_Medico = Nome_do_Medico;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
       public void inserir() throws SQLException {

        String sql = "INSERT INTO clinica (Nome_do_Medico, CRM, Senha ) "
                + "VALUES (?, ?, ?)";
        System.out.println(sql);

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
             ps.setString(1, Nome_do_Medico);
            ps.setString(2, CRM);
            ps.setString(3, Senha);
            ps.execute();
     System.out.println("Cadastrado com sucesso!!");
        } catch (Exception e) {
            System.out.println("ERRO no cadastro AKI!!!");
        }
}
   
 public void Atualizar() throws SQLException {
        String sql = "update clinica SET ome_do_Medico= ?, Senha= ?   WHERE CRM= ?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            // teste para ver se puxa System.out.println("Nome - " + Nome); 

            ps.setString(1, Nome_do_Medico);
            ps.setString(2, CRM);
            ps.setString(3, Senha);
            ps.execute();
                ps.execute();

            System.out.println("Atualização Feita!!");
        } catch (Exception e) {
            System.out.println("ERRO no cadastro AKI!!!");
        }
}
public void Delete() throws SQLException {
        String sql = "Delete From clinica where CRM =?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            /* teste para ver se puxa*/
            //System.out.println("CPF" + CPF);
            ps.setString(1, CRM);
            ps.execute();
            System.out.println("Perfil Deletado!");
        } catch (Exception e) {
            System.out.println("Erro, Não foi possivel deletar!");
        }
}
}