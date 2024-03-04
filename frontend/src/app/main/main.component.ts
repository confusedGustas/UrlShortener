import { Component } from '@angular/core';
import {UrlService} from "../_services/url.service";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {UrlResponse} from "../_modules/response";
import {UrlShorten} from "../_modules/request";

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './main.component.html',
})
export class MainComponent {
  shortenedUrl: string = '';

  constructor(private url: UrlService) {}

  urlForm = new FormGroup({
    originalUrl: new FormControl('', [Validators.required]),
    expirationDate: new FormControl('', [Validators.required]),
  });

  shorten() {
    const { originalUrl, expirationDate } = this.urlForm.value;

    if (originalUrl && expirationDate) {
      const convertedDate: Date = new Date(expirationDate);

      if (!isNaN(convertedDate.getTime())) {
        const urlShortenRequest: UrlShorten = { originalUrl, expirationDate };
        this.url.shortenUrl(urlShortenRequest).subscribe({
          next: (urlResponse: UrlResponse) => {
            this.shortenedUrl = "http://localhost:4200/" + urlResponse.shortUrl;
          }, error: () => {
            this.shortenedUrl = 'Invalid URL or expiration date. Please try again.'
          }
        });
        }
    }
  }
}
