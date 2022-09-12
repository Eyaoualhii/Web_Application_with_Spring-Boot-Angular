import { Component, Input, OnInit } from '@angular/core';
import  {FormGroup, FormBuilder, FormControl, Validators} from  '@angular/forms';
import { Employee } from 'src/app/model/employee';
import { EmployeeService } from 'src/app/service/employee.service';
import { MatSidenav } from '@angular/material/sidenav';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  @Input()
  inputSideNav!: MatSidenav;
  empDetail !: FormGroup;
  empObj : Employee = new Employee();
  empList : Employee[] = [];
  constructor(private formBuilder : FormBuilder, private empService : EmployeeService ) { }

  ngOnInit(): void {
    this.getAllEmployees();

    this.empDetail = this.formBuilder.group({
    id : ['',Validators.required],
    Prenom : ['',Validators.required],
    nom : ['',Validators.required], 
    Username : ['',Validators.required], 
    Password : ['',Validators.required], 
    Address : ['',Validators.required],
    Contact : ['',Validators.required]
    });
  }
 
getAllEmployees(){
this.empService.getAllEmployee().subscribe(res=>{

  this.empList = res;
  console.log(this.empList)
  
      },err=>{
        console.log("error while fetching data");
      });
}

addEmployee() {
  console.log(this.empDetail);
  this.empObj.id = this.empDetail.value.id;
  this.empObj.prenom = this.empDetail.value.Prenom;
  this.empObj.nom = this.empDetail.value.Nom;
  this.empObj.username= this.empDetail.value.Username;
  this.empObj.password = this.empDetail.value.Password ;
  this.empObj.address = this.empDetail.value.Address;
  this.empObj.contact = this.empDetail.value.Contact;

  this.empService.addEmployee(this.empObj).subscribe(res=>{

    console.log(res);
    this.getAllEmployees();
    alert("Product Added Successfully");
  },err=>{
    console.log(err);
  });
}


editEmployee(emp : Employee) {
  this.empDetail.controls['id'].setValue(this.empObj.id);
  this.empDetail.controls['prenom'].setValue(this.empObj.prenom);
  this.empDetail.controls['nom'].setValue(this.empObj.nom);
  this.empDetail.controls['username'].setValue(this.empObj.username);
  this.empDetail.controls['password'].setValue(this.empObj.password);
  this.empDetail.controls['address'].setValue(this.empObj.address);
  this.empDetail.controls['contact'].setValue(this.empObj.contact);

}

updateEmployee(){
  
  this.empObj.id = this.empDetail.value.id;
  this.empObj.prenom = this.empDetail.value.prenom;
  this.empObj.nom = this.empDetail.value.nom;
  this.empObj.username= this.empDetail.value.username;
  this.empObj.password = this.empDetail.value.password ;
  this.empObj.address = this.empDetail.value.address;
  this.empObj.contact = this.empDetail.value.contact;

  this.empService.updateEmployee(this.empObj).subscribe(res=>{
    console.log(res);
    this.getAllEmployees();
  },err=>{
    console.log(err);
  })

}

//delete works
deleteEmployee(emp : Employee) {

  this.empService.deleteEmployee(emp.id).subscribe(res=>{
    console.log(res);
    alert('Employee deleted successfully');
    this.getAllEmployees();
  },err => {
    console.log(err);
  });

}
}
