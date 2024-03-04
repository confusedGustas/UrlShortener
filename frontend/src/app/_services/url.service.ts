import {inject, Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {UrlShorten} from "../_modules/request";

const BASE_URL = 'http://localhost:8080/api/v1/url/'

@Injectable({
  providedIn: 'root'
})
export class UrlService {
  private http = inject(HttpClient);
  constructor() { }

  shortenUrl(data: UrlShorten) : Observable<any> {
    return this.http.post<any>(BASE_URL + 'shorten', data);
  }

  originalUrl(shortUrl: String) : Observable<any> {
    return this.http.get<any>(BASE_URL + shortUrl);
  }
}
