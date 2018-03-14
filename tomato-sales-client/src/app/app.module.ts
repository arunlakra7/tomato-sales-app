import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {Http} from '@angular/http';
import {TranslateStaticLoader, TranslateModule, TranslateLoader} from 'ng2-translate';

import { AppComponent } from './app.component';
import { TomatoService } from 'app/services/tomato.service';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    TranslateModule.forRoot({
      provide: TranslateLoader,
      useFactory: (http: Http) => new TranslateStaticLoader(http, '/assets/i18n', '.json'),
      deps: [Http]
    })
  ],
  providers: [TomatoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
