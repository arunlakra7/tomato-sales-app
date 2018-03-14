import { Component } from '@angular/core';
import { TomatoService } from 'app/services/tomato.service';
import {TranslateService} from 'ng2-translate';

@Component({
  selector:'app-root',
  templateUrl:'./app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  users;
  size: string;

  constructor(private tomatoService: TomatoService) {
    this.users = this.tomatoService.getTomatoSales();
  }

  onClickRefreshButton(event) {
    this.users = this.tomatoService.getTomatoSales(this.size);
  }
}
