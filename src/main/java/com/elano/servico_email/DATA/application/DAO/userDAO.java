package com.elano.servico_email.DATA.application.DAO;

import com.elano.servico_email.DATA.application.DTO.userDTO;

import java.util.ArrayList;
import java.util.List;

public class userDAO {

    public static final List<userDTO> lista = new ArrayList<>();


    public static List<userDTO> Listar() {
        return lista;
    }

    public static void Adicionar(userDTO u) {
        lista.add(u);
    }
}