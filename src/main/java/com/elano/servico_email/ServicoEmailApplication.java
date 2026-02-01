package com.elano.servico_email;

import com.elano.servico_email.DATA.application.DAO.conexaoDB;
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
		System.out.println("Comandos: \n1- 'login' \n2- 'registrar'");
		String e1 = sc.nextLine();

		if(e1.equals("login")) {

		}else if(e1.equals("registrar")){
			conexaoDB cn = new conexaoDB();
			Random gerador = new Random();
			int resultado = gerador.nextInt(999999);

			System.out.println("Digite seu nome: ");
			String nome = sc.nextLine();

			cn.Conectar();

			System.out.println("Digite o seu email: ");
			String email = sc.nextLine();

			System.out.println("Digite sua senha: ");
			String senha = sc.nextLine();

			ess.sendEmail(email, "Verificação de email", "Olá "+ nome +" o seu token é: " + resultado);

			System.out.println("Enviamos um token para seu email! Por favor digite ele abaixo: ");
			int token = sc.nextInt();

			if(token == resultado){
				System.out.println("Email verificado!");
			} else{
				System.out.println("Token errado.");
			}
		}
	}
}
