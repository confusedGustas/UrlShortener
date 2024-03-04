import {Component, OnInit} from '@angular/core';
import {UrlService} from "../_services/url.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-redirect',
  standalone: true,
  imports: [],
  templateUrl: './redirect.component.html',
})
export class RedirectComponent implements OnInit {
  constructor(private url: UrlService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    const short = this.route.snapshot.paramMap.get('short');

    if (short) {
      this.url.originalUrl(short).subscribe( {
        next: (urlResponse) => {
          window.location.href = urlResponse.originalUrl;
      }, error: () => {
          this.router.navigate(['/']).then(r => console.log(r));
        }
      });
    }
  }
}
