import { Injectable } from '@angular/core';
import { HttpClient , HttpClientModule} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

   private url = 'http://localhost:8107';
  
  constructor(private http : HttpClient ) {


   }



   public getAllEmployee():Observable<Employee[]>{
      return this.http.get<Employee[]>(`${this.url}/getAll`);
   }


   public deleteEmployee(id : number) : Observable<Employee> {
      return this.http.delete<Employee>(`${this.url}/deleteEmployeeById/${id}`);
    }
   // no password + read me file + prod , dev and test + config containing every modification happened + server port fel .env file + git
   // ay haja testhak tetbadel frequement example port bech yetbadel



//add works only in postman
   public addEmployee(emp : Employee): Observable<Employee> {
     return this.http.post<Employee>(`${this.url}/addEmployee`,emp);
   }
   public updateEmployee(emp : Employee) : Observable<Employee> {
      return this.http.put<Employee>(`${this.url}/updateEmployee`, emp);
   }



   
  login(emp : Employee) : Observable<any> {
   return this.http.post<any>(`${this.url}/login`,emp);
 }

 signUp(emp : Employee) : Observable<any> {
   return this.http.post<any>(`${this.url}/register`,emp);
 }
  
}
