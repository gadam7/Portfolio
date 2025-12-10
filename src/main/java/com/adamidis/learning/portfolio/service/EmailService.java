package com.adamidis.learning.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(String fromName, String fromEmail, String messageText) {
        // Implementation for sending email using mailSender
        // This is a placeholder for the actual email sending logic
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("g.adamidis1985@gmail.com"); // i want to receive the emails
        mailMessage.setSubject("Portfolio Contact Form Submission from " + fromName); // Subject includes sender's name
        mailMessage.setText("You have received a new message from " + fromEmail +
                            " at your portfolio contact form.\n" + "Message:\n" + messageText);
        mailSender.send(mailMessage);
    }


}
