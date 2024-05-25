

//controller
package org.codingwallah.emproject;

import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    //List<Employee> employees=new ArrayList<>(); 
   // dependency injection 
    // @Autowired

  // EmployeeService employeeService; // here i dont need to use 'new' key word to create an object ,IOC(dependency injection)
                  //   is there to create an object
    EmployeeService employeeService=new EmployeeServiceImp();
    @GetMapping("employees") // read all
    public List<Employee> getAllEmployees(){
        return employeeService.readEmployees();

    }
    @GetMapping("employees/{id}") // read by id
    public Employee getAllEmployeeById(@PathVariable Long id){
        return employeeService.readEmployee(id);

    }
    @PostMapping("employees")
public String createEmployee(@RequestBody Employee employee){
    //employees.add(employee);
   return employeeService.createEmployee(employee);
   
}
 @DeleteMapping("employees/{id}")
public String deleteEmployee(@PathVariable Long id){
 if( employeeService.deleteEmployee(id))
  return "delete Sucessfully";
   return "Not found";

}

@PutMapping("path/{id}")
public String putMethodName(@PathVariable Long id , @RequestBody Employee employee){
    return employeeService.updateEmployee(id, employee);
}

}











