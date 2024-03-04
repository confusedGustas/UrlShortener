package com.url.shortener.services;

import com.url.shortener.dto.OriginalUrl;
import com.url.shortener.dto.UrlRequest;
import com.url.shortener.dto.UrlResponse;
import com.url.shortener.models.Url;
import com.url.shortener.repository.UrlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlResponse shortenUrl(UrlRequest urlRequest) {
        String urlRegex = "^(http|https)://[a-zA-Z0-9-.]+\\.[a-zA-Z]{2,}(?:/\\S*)?$";
        Pattern pattern = Pattern.compile(urlRegex);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(urlRequest.expirationDate(), formatter);

        if ((urlRequest.originalUrl() == null || urlRequest.originalUrl().isEmpty())
                || !pattern.matcher(urlRequest.originalUrl()).matches()
                || date.isBefore(LocalDate.now())) {
            throw new RuntimeException("Invalid URL or expiration date. Please provide a valid URL and a future expiration date.");
        }

        String uniqueId = UUID.randomUUID().toString().replace("-", "").substring(0, 6);
        LocalDate currentDate = LocalDate.now();
        Url url = new Url();

        url.setOriginalUrl(urlRequest.originalUrl());
        url.setShortUrl(uniqueId);
        url.setCreatedDate(currentDate.toString());
        url.setExpirationDate(date.toString());

        urlRepository.save(url);
        return new UrlResponse(url.getOriginalUrl(), url.getShortUrl(), url.getCreatedDate(), url.getExpirationDate());
    }

    public OriginalUrl originalUrl(String shortUrl) {
        Url url = urlRepository.findByShortUrl(shortUrl);
        if (url == null) throw new RuntimeException("Invalid URL. Please provide a valid URL.");
        urlRepository.save(url);
        return new OriginalUrl(url.getOriginalUrl());
    }
}
