package com.urlshort.service;

import org.springframework.stereotype.Service;

import com.urlshort.repository.ShortUrlRepository;
import com.urlshort.utility.Base62;

@Service
public class ShortCodeService {
	
	private static final int DEFAULT_LENGTH = 7;
	private final ShortUrlRepository repository;
	
	public ShortCodeService(ShortUrlRepository repository) {
		this.repository = repository;
	}
	
	public String generateUniqueCode() {
		for(int i = 0; i< 10; i++) {
			String candidate = Base62.randomCode(DEFAULT_LENGTH);
			if(!repository.existsByCode(candidate)) {
				return candidate;
			}
		}
		throw new IllegalStateException("Failed to generate the unique short code. ");
	}
	
	public String validateCustomAlias(String alias) {
		if(alias == null || alias.isBlank()) return null;
		if(!alias.matches("^[a-zA-Z0-9_]{3,32}$")){
			throw new IllegalArgumentException("The Alias name should be atleast of 3 charcter length and atmost 32 charcter and contains only digits, alphabets and underscore");
		}
		if(repository.existsByCode(alias)) {
			throw new IllegalArgumentException("Alias already exists.");
		}
		return alias;
	}
}
