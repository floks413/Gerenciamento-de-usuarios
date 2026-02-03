package com.elano.servico_email;

import com.elano.servico_email.DATA.application.DTO.userDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.elano.servico_email.DATA.application.EmailSenderService;
import com.elano.servico_email.DATA.application.DAO.userDAO;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class ServicoEmailApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(ServicoEmailApplication.class, args);
        EmailSenderService ess = context.getBean(EmailSenderService.class);

        Scanner sc = new Scanner(System.in);

        boolean loop = true;

        while (loop) {

            System.out.println("Comandos: \n1- 'login' \n2- 'registrar'");
            String e1 = sc.nextLine();

            if (e1.equals("login")) {

            } else if (e1.equals("registrar")) {
                userDAO us = new userDAO();
                Random gerador = new Random();
                userDTO u = new userDTO();
                int resultado = gerador.nextInt(999999);

                System.out.println("Digite seu nome: ");
                String nome = sc.nextLine();
                u.setName(nome);

                System.out.println("Digite sua idade: ");
                int idade = sc.nextInt();
                u.setIdade(idade);
                sc.nextLine();

                System.out.println("Digite o seu email: ");
                String email = sc.nextLine();
                u.setEmail(email);

                if (us.ConsultarE(email)) {
                    System.out.println("Esse email já está cadastrado no banco de dados.");
                } else {

                    System.out.println("Digite sua senha: ");
                    String senha = sc.nextLine();
                    u.setPassword(senha);

                    ess.sendEmail(email, "Verificação de email", "Olá " + nome + " o seu token é: " + resultado);

                    System.out.println("Enviamos um token para seu email! Por favor digite ele abaixo: ");
                    int token = sc.nextInt();

                    if (token == resultado) {
                        System.out.println("Email verificado!\n");
                        us.Adicionar(u);
                        sc.nextLine();
                        String answer = sc.nextLine();
                        if (answer.equals("0")) {
                            loop = false;
                        }

                    } else {
                        System.out.println("O token digitado está incorreto...");
                        sc.nextLine();
                        String answer = sc.nextLine();
                        if (answer.equals("0")) {
                            loop = false;
                        }
                    }
                }
            }
        }
    }
}
