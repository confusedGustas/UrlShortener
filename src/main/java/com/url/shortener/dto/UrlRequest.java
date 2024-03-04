package com.url.shortener.dto;

import jakarta.validation.constraints.NotNull;

public record UrlRequest(@NotNull String originalUrl, @NotNull String expirationDate) { }