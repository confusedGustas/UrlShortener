package com.url.shortener.repository;

import com.url.shortener.models.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {
    Url findByShortUrl(String shortUrl);
}
