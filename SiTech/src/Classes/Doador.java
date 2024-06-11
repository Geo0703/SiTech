package Classes;

import Conexão.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            ps.setInt(5, celular);
            ps.setString(6, tiposanguineo);
            ps.execute();

            System.out.println("Cadastrado com sucesso!!");
        } catch (Exception e) {
            System.out.println("ERRO no cadastro AKI!!!");
        }
    }

    public void Delete() throws SQLException {
        String sql = "Delete From Doador where CPF =?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            /* teste para ver se puxa*/
            //System.out.println("CPF" + CPF);
            ps.setInt(1, CPF);
            ps.execute();
            System.out.println("Perfil Deletado!");
        } catch (Exception e) {
            System.out.println("Erro, Não foi possivel deletar!");
        }

    }

    public void Atualizar() throws SQLException {
        String sql = "update Doador SET nome=?, email=?, sexo=?, celular=?, tiposanguineo=? WHERE CPF=?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);
            // teste para ver se puxa System.out.println("Nome - " + Nome); 

            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setInt(3, CPF);
            ps.setString(4, sexo);
            ps.setInt(5, celular);
            ps.setString(6, tiposanguineo);
            ps.execute();

            System.out.println("Atualização Feita!!");
        } catch (Exception e) {
            System.out.println("ERRO no cadastro AKI!!!");
        }
    }

    public List<Doador> read() {

        ConnectionFactory con = new ConnectionFactory();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Doador> doadores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Doador");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Doador doador = new Doador();

                doador.setNome(rs.getString("nome"));
                doador.setCPF(rs.getInt("CPF"));
                doador.setSexo(rs.getString("sexo"));
                doador.setTiposanguineo(rs.getString("tiposanguíneo"));
                doador.setCelular(rs.getInt("celular"));
                doador.setEmail(rs.getString("email"));
                doadores.add(doador);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Doador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConexão(con, stmt, rs);
        }
        return null;
    }

    public List<Doador> readForNome(String nome) {

        ConnectionFactory con = new ConnectionFactory();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Doador> doadores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM doador WHERE nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Doador doador = new Doador();

                doador.setNome(rs.getString("nome"));
                doador.setCPF(rs.getInt("CPF"));
                doador.setSexo(rs.getString("sexo"));
                doador.setTiposanguineo(rs.getString("tiposanguíneo"));
                doador.setCelular(rs.getInt("celular"));
                doador.setEmail(rs.getString("email"));
                doadores.add(doador);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Doador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConexão(con, stmt, rs);
        }

        return doadores;
    }
}
