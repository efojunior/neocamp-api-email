package com.xunim.praticas.service;

import com.xunim.praticas.enums.StatusEmail;
import com.xunim.praticas.model.EmailModel;
import com.xunim.praticas.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    IEmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setTo(emailModel.getSubject());
            message.setTo(emailModel.getText());
            emailSender.send(message);
            emailModel.setStatusEmail(StatusEmail.SENT);

        } catch(MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }
        finally{
            return emailRepository.save(emailModel);
        }
    }
}
