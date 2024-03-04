package com.url.shortener.dto;

public record UrlResponse(String originalUrl, String shortUrl, String createdDate, String expirationDate) { }