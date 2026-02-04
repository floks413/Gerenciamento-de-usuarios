package com.elano.servico_email.DATA.application.DAO;

import com.elano.servico_email.DATA.application.DTO.userDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.elano.servico_email.DATA.application.DAO.conexaoDB;

public class userDAO {

    private final conexaoDB cn = new conexaoDB();


    public boolean ConsultarE(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";

        try (
                Connection conn = cn.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return false;
        }
    }

    public boolean ConsultarC(String email, String senha) {
        String sql = "SELECT * FROM users WHERE email = ? AND senha = ?";

        try (
                Connection conn = cn.Conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return false;

        }
    }

    public void Adicionar(userDTO u) {

        String sql = "INSERT INTO users (email, senha, idade, nome, tipo) values (?,?,?,?,'Usuario')";

        Connection conn = null;

        try {
            conn = cn.Conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getPassword());
            stmt.setInt(3, u.getIdade());
            stmt.setString(4, u.getName());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cn.Desconectar(conn);
        }
    }
}