package com.urlshort.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.urlshort.dto.CreateShortUrlRequest;
import com.urlshort.entity.ShortUrl;
import com.urlshort.repository.ShortUrlRepository;

@Service
public class UrlService {
	private final ShortUrlRepository repository;
	private final ShortCodeService codeService;
	public UrlService(ShortUrlRepository repository, ShortCodeService codeService) {
		super();
		this.repository = repository;
		this.codeService = codeService;
	}
	
	public ShortUrl create(CreateShortUrlRequest request) {
		String target = normalizeURL(request.getUrl());
		String code = request.getAlias()!= null  
				? codeService.validateCustomAlias(request.getAlias())  
				: codeService.generateUniqueCode();	
		
		Instant expiresAt = null;
		
		if(request.getExpiryDays() != null && request.getExpiryDays() > 0) {
			expiresAt = Instant.now().plus(request.getExpiryDays(), ChronoUnit.DAYS);
		}
		
		ShortUrl shortURL = new ShortUrl(code, target, expiresAt);
		return repository.save(shortURL);
	}
	
	public Optional<ShortUrl> lookupActive(String code){
		return repository.findByCode(code)
				.filter(url -> url.getExpiresAt() == null || url.getExpiresAt().isAfter(Instant.now()) );
	}
	
	public void registerHit(ShortUrl url) {
		url.setHits(url.getHits() + 1);
		url.setLastAccessedAt(Instant.now());
		repository.save(url);
	}
	
	private String normalizeURL(String input) {
		// TODO Auto-generated method stub
		try {
			URI uri = new URI(input.trim());
			
			if(uri.getScheme() == null) {
				uri = new URI("https://"+input.trim());
			}
			if(!uri.getScheme().equalsIgnoreCase("http") && !(uri.getScheme().equalsIgnoreCase("https"))) {
				throw new IllegalArgumentException("Only HTTP and HTTPS are supported for now. ");
			}
			return uri.normalize().toString();
		}catch(URISyntaxException ex) {
			throw new IllegalArgumentException("Invalid URL");
		}
	}
}
