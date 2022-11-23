package com.ms.email.services;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired  // dependencia para enviar mensagem
    private JavaMailSender emailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        // Data de envio
        emailModel.setSendDateEmail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            // Caso o email seja enviado, salvar o status como enviado
            emailModel.setStatusEmail(StatusEmail.SENT);

            // caso não seja enviado, status de erro
        } catch (MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);

        } finally {
            return emailRepository.save(emailModel);
        }
    }
}
