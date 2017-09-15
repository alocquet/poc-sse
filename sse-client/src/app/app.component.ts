import { Component } from '@angular/core';
import { MessageService, Message } from "app/message.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  messages = [];
  user = '';
  data = '';

  constructor(private service: MessageService) {
    service.lister().subscribe(data => this.messages.push(data));
  }

  sendMessage(){
    let message = new Message();
    message.data = this.data;
    message.from = this.user;
    message.date = new Date().toISOString();
    this.service.sendMessage(message);
  }


}
