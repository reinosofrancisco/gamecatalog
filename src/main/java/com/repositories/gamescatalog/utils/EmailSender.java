package com.repositories.gamescatalog.utils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public class EmailSender {

	// Use PasswordDelegator class to load environment variables
	ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class, PasswordDelegator.class);
	public PasswordDelegator passwordDelegator = context.getBean(PasswordDelegator.class);

	public EmailSender() {}

	@Bean
	public JavaMailSender getGameMailSender() {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername(passwordDelegator.getUsername());
		mailSender.setPassword(passwordDelegator.getPassword());

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

	public void sendEmail(String toEmail, String subject, String body) throws MessagingException, UnsupportedEncodingException {

		JavaMailSender mailSender = this.getGameMailSender();
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom(passwordDelegator.getUsername(), "Games Catalog");
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(body, false);

		mailSender.send(message);
	}

	public String getCurrentUsername() {
		return passwordDelegator.getUsername();
	}

}
