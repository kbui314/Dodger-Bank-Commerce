import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import {LoginService} from './login.service';
import { Observable } from 'rxjs';
import { User } from '../model/User';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User;
  constructor(private loginService : LoginService) { }

  ngOnInit() {
  }
  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });

  // onClickSubmit(username,password){
  //   this.loginService.loginUser(username,password).subscribe()
  // }
}
