package com.repositories.gamescatalog.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
public class PasswordDelegator {

	@Getter
	@Value("${ext.mail.username}")
	private String username;

	@Getter
	@Value("${ext.mail.password}")
	private String password;
}
