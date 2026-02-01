package com.elano.servico_email.DATA.application.DTO;


public class userDTO {

    public static userDTO usuarioLogado;

    private int ID;
    private String name, email, user_type, password;

    public userDTO() {
    }

    public userDTO(int ID, String name, String email, String user_type, String password) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.user_type = user_type;
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

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
