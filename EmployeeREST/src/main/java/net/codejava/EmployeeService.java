package net.codejava;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class EmployeeService {
	

	private BCryptPasswordEncoder encoder;

    private EmployeeRepository repo;
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64enocder = Base64.getUrlEncoder();
    
    public EmployeeService(EmployeeRepository repo) {
	
		this.encoder = new BCryptPasswordEncoder();
		this.repo = repo;
	}
	
	public List<Employee> listAll() {
        return repo.findAll();
    }
     
    public Employee save(Employee employee) {
    String encodedPassword = this.encoder.encode(employee.getPassword());
    employee.setPassword(encodedPassword);
        return repo.save(employee);
    }
    
    public List<Employee> addAllEmployees(List<Employee> employees) {
        return  repo.saveAll(employees);
    }
    
    
    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

	public Employee get(Integer id) {
        return repo.findById(id).get();
    }
     
    @SuppressWarnings("deprecation")
	public boolean delete(Integer id) {
    	Employee existingEMP = repo.getById(id);
        if(existingEMP != null) {
        	repo.deleteById(id);
            return true;
        }
        return false;
    }
    
    public Employee updateEmployee(Employee employee) {
        Employee existingEMP = repo.findById(employee.getId()).orElse(null);
        System.out.println(employee);
        if(existingEMP == null) {
            System.out.println("Emp not found");
            return repo.save(employee);
        }else  {
        	 
        	 existingEMP.setNom(employee.getNom());
            existingEMP.setPrenom(employee.getPrenom());
            existingEMP.setUsername(employee.getUsername());
            existingEMP.setPassword(employee.getPassword());
            existingEMP.setAddress(employee.getAddress());
            
            existingEMP.setContact(employee.getContact());
           
            repo.save(existingEMP);
        }
        return employee;
    }
    
    
    
    
    
    public Employee register(Employee user) {
        // Check if user with username exist or not
        if(checkUserExist(user)== true)
            return null;

        user.setToken(generateToken());

        return repo.save(user);

    }

    private String generateToken() {

        byte[] token = new byte[24];
        secureRandom.nextBytes(token);
        return base64enocder.encodeToString(token);

    }

    private boolean checkUserExist(Employee user) {
    	Employee existingUser = repo.findById(user.getId()).orElse(null);

        if(existingUser == null)
            return false;
        return true;
    }

    public Employee login(Employee user) {
    	Employee existingUser = repo.findById(user.getId()).orElse(null);

        if(existingUser.getUsername().equals(user.getUsername()) &&
                existingUser.getPassword().equals(user.getPassword())) {
            existingUser.setPassword("");
            return existingUser;
        }

        return null;

    }
}
