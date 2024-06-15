package Classes;

import Conexão.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Receptor {

    private String nome;
    private String CPF;
    private String tiposanguíneo;
    private String celular;
    private String Motivo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTiposanguíneo() {
        return tiposanguíneo;
    }

    public void setTiposanguíneo(String tiposanguíneo) {
        this.tiposanguíneo = tiposanguíneo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public void inserir() throws SQLException {

        String sql = "INSERT INTO Receptor (nome, CPF, tiposanguineo, celular, Motivo ) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        System.out.println(sql);

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            // teste para ver se puxa System.out.println("Nome - " + Nome); 
            ps.setString(1, nome);
            ps.setString(2, CPF);
            ps.setString(4, celular);
            ps.setString(3, tiposanguíneo);
            ps.setString(5, Motivo);
            ps.execute();

            System.out.println("Cadastrado com sucesso!!");
        } catch (Exception e) {
            System.out.println("ERRO no cadastro AKI!!!");
        }
    }
 public void Atualizar() throws SQLException {
        String sql = "update Receptor SET nome=?, tiposanguineo=?, celular=?, Motivo=?  WHERE CPF=?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            // teste para ver se puxa System.out.println("Nome - " + Nome); 

            ps.setString(1, nome);
            ps.setString(2, tiposanguíneo);
            ps.setString(3, celular);
            ps.setString(4, Motivo);
            ps.setString(5, CPF);
            ps.execute();


            System.out.println("Atualização Feita!!");
        } catch (Exception e) {
            System.out.println("ERRO no cadastro AKI!!!");
        }
    }
 public void Delete() throws SQLException {
        String sql = "Delete From Receptor where CPF =?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            /* teste para ver se puxa*/
            //System.out.println("CPF" + CPF);
            ps.setString(1, CPF);
            ps.execute();
            System.out.println("Perfil Deletado!");
        } catch (Exception e) {
            System.out.println("Erro, Não foi possivel deletar!");
        }
}
}


