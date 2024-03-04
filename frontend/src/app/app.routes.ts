import {Routes} from '@angular/router';
import {RedirectComponent} from "./redirect/redirect.component";
import {MainComponent} from "./main/main.component";

export const routes: Routes = [
  { path: '', component: MainComponent, title: 'Url Shortener'},
  { path: ':short', component: RedirectComponent, title: 'redirecting...' },
];
