package com.elano.servico_email.Core;

public interface EmailSender {
    void sendEmail(String to, String subject, String body);
}
