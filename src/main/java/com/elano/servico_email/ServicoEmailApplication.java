package com.elano.servico_email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.elano.servico_email.application.EmailSenderService;

@SpringBootApplication
public class ServicoEmailApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(ServicoEmailApplication.class, args);
		EmailSenderService ess = context.getBean(EmailSenderService.class);

		ess.sendEmail("danielelano2018@gmail.com", "Teste", "Email de teste");
	}
}
