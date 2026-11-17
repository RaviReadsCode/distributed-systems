package com.urlshort.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;


@Entity
@Table(name = "short_urls", indexes = {
		@Index(name = "idx_code_unique", columnList = "code", unique = true)
})
public class ShortUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true, length = 32)
	private String code;
	
	@Column(nullable = false, name = "target_url", length = 2048)
	private String targetUrl;
	
	
	private Instant expiresAt;
	private long hits=0;
	private Instant lastAccessedAt;
	
	@Column(nullable = false, updatable = false)
	private Instant createdAt = Instant.now();
	
	public ShortUrl() {}
	
	public ShortUrl(String code, String targetUrl, Instant expiresAt) {
		super();
		this.code = code;
		this.targetUrl = targetUrl;
		this.expiresAt = expiresAt;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the targetUrl
	 */
	public String getTargetUrl() {
		return targetUrl;
	}
	/**
	 * @param targetUrl the targetUrl to set
	 */
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	/**
	 * @return the expiresAt
	 */
	public Instant getExpiresAt() {
		return expiresAt;
	}
	/**
	 * @param expiresAt the expiresAt to set
	 */
	public void setExpiresAt(Instant expiresAt) {
		this.expiresAt = expiresAt;
	}
	/**
	 * @return the hits
	 */
	public long getHits() {
		return hits;
	}
	/**
	 * @param hits the hits to set
	 */
	public void setHits(long hits) {
		this.hits = hits;
	}
	/**
	 * @return the lastAccessedAt
	 */
	public Instant getLastAccessedAt() {
		return lastAccessedAt;
	}
	/**
	 * @param lastAccessedAt the lastAccessedAt to set
	 */
	public void setLastAccessedAt(Instant lastAccessedAt) {
		this.lastAccessedAt = lastAccessedAt;
	}
	/**
	 * @return the createdAt
	 */
	public Instant getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
