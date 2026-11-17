package com.urlshort.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urlshort.entity.ShortUrl;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long>{
	Optional<ShortUrl> findByCode(String code);
	boolean existsByCode(String code);

}
