package net.codejava;

import java.util.NoSuchElementException;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController

public class EmployeeController {
	
	
	
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/getAll")
	public List<Employee> list(){
		return service.listAll();
		
	}
	
	@GetMapping("/getEmployeeByID/{id}")
	public ResponseEntity<Employee> get(@PathVariable Integer id) {
	    try {
	        Employee employee = service.get(id);
	        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	    }      
	}

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
    	
        return service.addEmployee(employee);
    }
	
	@PutMapping("/updateEmployee")
	public Employee update(@RequestBody Employee employee2) {
		return service.updateEmployee(employee2);
	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public boolean delete(@PathVariable Integer id) {
	    return service.delete(id);
	}
	
	 @PostMapping("/register")
	    public Employee Register(@RequestBody Employee user) {

	        return  service.register(user);


	    }

	    @PostMapping("/login")
	    public Employee login(@RequestBody Employee user) {

	        return service.login(user);
	    }
}
