package com.urlshort.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateShortUrlRequest {
	
	@NotBlank(message="URL is required.")
	@Size(max = 2048, message = "URL is too long")
	private String url;
	
	@Size(min = 3, max = 32, message = "Alias must be in between 3 and 32 charcters and contains alphabets, digits and underscore")
	private String alias;
	
	private Integer expiryDays;

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the expiryDays
	 */
	public Integer getExpiryDays() {
		return expiryDays;
	}

	/**
	 * @param expiryDays the expiryDays to set
	 */
	public void setExpiryDays(Integer expiryDays) {
		this.expiryDays = expiryDays;
	}

	@Override
	public String toString() {
		return "CreateShortUrlRequest [url=" + url + ", alias=" + alias + ", expiryDays=" + expiryDays + "]";
	}
	
}
