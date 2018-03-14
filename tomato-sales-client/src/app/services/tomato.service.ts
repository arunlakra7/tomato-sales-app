import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { TomatoSale } from 'app/models/tomato.model';

@Injectable()
export class TomatoService {

  constructor(private http:Http) {
  }

  getTomatoSales(size?:string):Observable<TomatoSale[]> {

    let defaultUrl = "http://localhost:8080/tomatosale";
    let url = size ? defaultUrl + "?size=" + size : defaultUrl;
    return this.http.get(url)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
}
