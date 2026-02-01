package com.elano.servico_email.DATA.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Value("${spring.mail.username}")
    private String remetente;

    @Autowired
    private JavaMailSender javaMailSender;
    public String sendEmail(String to, String subject, String body){
        try{
            SimpleMailMessage smm = new SimpleMailMessage();

            smm.setFrom(remetente);
            smm.setTo(to);
            smm.setSubject(subject);
            smm.setText(body);
            javaMailSender.send(smm);
            return "Enviado";
        } catch (Exception ex){
            return "Erro ao enviar o email." + ex.getLocalizedMessage();
        }
    }

}
