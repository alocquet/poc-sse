import { Injectable, NgZone } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from "rxjs/Observable";
import 'rxjs/Rx';
const EventSource: any = window['EventSource'];

@Injectable()
export class MessageService {

  constructor(private http: Http, private zone: NgZone) { }

  lister(): Observable<Message> {
    return new Observable<Message>(obs => {
      const es = new EventSource('http://localhost:8080/api/message/stream');
      es.addEventListener('message', evt => {
        const data = JSON.parse(evt.data);
        this.zone.run(() => obs.next(data));
      });
      return () => es.close();
    });
  }

  sendMessage(message: Message) {
    this.http.post('http://localhost:8080/api/message', message).subscribe();
  }

}

export class Message {
  uid: string;
  from: string;
  date: string;
  data: string;
}