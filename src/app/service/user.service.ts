import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/api/v1/user';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user);
  }

getUserById(id:number):Observable<User>{
  return this.http.get<User>(`${this.usersUrl}/${id}`);
 }
updateUser (id:number, user:User):Observable<Object>{
  return this.http.put(`${this.usersUrl}/${id}`,user);
 }
deleteUser(id : number): Observable<Object>{
  return this.http.delete(`${this.usersUrl}/${id}`);
}
}


