package com.urlshort.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.urlshort.service.UrlService;

@RestController
public class RedirectController {
	private final UrlService urlService;

	public RedirectController(UrlService urlService) {
		super();
		this.urlService = urlService;
	}

	@GetMapping("/{code}")
	public ResponseEntity<Object> redirect(@PathVariable String code) {
		return urlService.lookupActive(code).map(url -> {
			urlService.registerHit(url);
			return ResponseEntity.status(302).header(HttpHeaders.LOCATION, url.getTargetUrl()).build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
