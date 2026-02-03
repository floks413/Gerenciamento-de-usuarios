package com.elano.servico_email.DATA.application.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoDB {

    String url = "jdbc:mysql://localhost:3306/UsersDB";
    String usuario = "root";
    String senha = "root";

    public Connection Conectar() throws SQLException{
            return DriverManager.getConnection(url, usuario, senha);
    }

    public void Desconectar(Connection conn){
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar: " + ex.getMessage());
        }
    }
}
