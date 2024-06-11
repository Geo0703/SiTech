
package Classes;

import Conexão.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Doador {
    private String nome;
    private int CPF;
    private String sexo;
    private String tiposanguineo;
    private int celular;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTiposanguineo() {
        return tiposanguineo;
    }

    public void setTiposanguineo(String tiposanguineo) {
        this.tiposanguineo = tiposanguineo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void inserir() throws SQLException {

        String sql = "INSERT INTO Doador (nome, email, CPF, sexo, celular, tiposanguineo ) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        System.out.println(sql);

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            // teste para ver se puxa System.out.println("Nome - " + Nome); 
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setInt(3, CPF);
            ps.setString(4, sexo);
            ps.setInt(5,celular);
            ps.setString(6,tiposanguineo);
            ps.execute();

            System.out.println("Cadastrado com sucesso!!");
        } catch (Exception e) {
            System.out.println("ERRO no cadastro AKI!!!");
        }
    }


}

