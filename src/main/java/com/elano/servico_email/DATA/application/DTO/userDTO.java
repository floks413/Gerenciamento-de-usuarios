package com.elano.servico_email.DATA.application.DTO;


public class userDTO {

    public static userDTO usuarioLogado;

    private int ID, idade;
    private String name, email, password;

    public userDTO() {
    }

    public userDTO(int ID, String name, String email, int idade, String password) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.idade = idade;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
