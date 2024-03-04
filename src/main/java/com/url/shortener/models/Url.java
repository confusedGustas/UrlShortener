package com.url.shortener.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "urls")
@NoArgsConstructor
@Getter
@Setter
public class Url {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String originalUrl;
    private String shortUrl;
    private String createdDate;
    private String expirationDate;
}
