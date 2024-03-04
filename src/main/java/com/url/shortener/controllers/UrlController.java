package com.url.shortener.controllers;

import com.url.shortener.dto.OriginalUrl;
import com.url.shortener.dto.UrlRequest;
import com.url.shortener.dto.UrlResponse;
import com.url.shortener.services.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/url")
@AllArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/shorten")
    public UrlResponse shortenUrl(@RequestBody UrlRequest urlRequest) {
        return urlService.shortenUrl(urlRequest);
    }

    @GetMapping("/{shortUrl}")
    public OriginalUrl getOriginalUrl(@PathVariable String shortUrl) {
        return urlService.originalUrl(shortUrl);
    }
}
