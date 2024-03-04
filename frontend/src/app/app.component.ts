import { Component } from '@angular/core';
import {Router, RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  template: '<router-outlet></router-outlet>',
  imports: [
    RouterOutlet
  ],
  styles: []
})
export class AppComponent {
  title = 'Url Shortener';
  constructor(private router: Router) {}
}
