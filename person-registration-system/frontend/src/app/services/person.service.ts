import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Person } from '../models/person.model';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private apiUrl = 'http://localhost:8080/api/v1/persons';
  private apiUrlV2 = 'http://localhost:8080/api/v2/persons';

  constructor(private http: HttpClient) { }

  private getAuthHeaders(): HttpHeaders {
    const username = 'admin';
    const password = 'admin123';
    const basicAuth = 'Basic ' + btoa(username + ':' + password);
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': basicAuth
    });
  }

  getAllPersons(): Observable<Person[]> {
    return this.http.get<Person[]>(this.apiUrl, { headers: this.getAuthHeaders() });
  }

  getPersonById(id: number): Observable<Person> {
    return this.http.get<Person>(`${this.apiUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  createPerson(person: Person): Observable<Person> {
    return this.http.post<Person>(this.apiUrl, person, { headers: this.getAuthHeaders() });
  }

  updatePerson(id: number, person: Person): Observable<Person> {
    return this.http.put<Person>(`${this.apiUrl}/${id}`, person, { headers: this.getAuthHeaders() });
  }

  deletePerson(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`, { headers: this.getAuthHeaders() });
  }
}
