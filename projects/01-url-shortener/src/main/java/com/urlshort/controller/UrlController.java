package com.urlshort.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urlshort.dto.CreateShortUrlRequest;
import com.urlshort.entity.ShortUrl;
import com.urlshort.service.UrlService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/urls")
public class UrlController {
	private final UrlService service;

	public UrlController(UrlService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<ShortUrl> create(@Valid @RequestBody CreateShortUrlRequest request){
		ShortUrl result = service.create(request);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<ShortUrl> get(@PathVariable String code){
		return service.lookupActive(code)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
