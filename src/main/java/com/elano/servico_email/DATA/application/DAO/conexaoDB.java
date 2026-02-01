package com.elano.servico_email.DATA.application.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoDB {

    String url = "jdbc:mysql://localhost:3306/UsersDB";
    String usuario = "root";
    String senha = "root";

    public void Conectar(){

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com o banco.");
        } catch(SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public void Desconectar(){

    }
}
