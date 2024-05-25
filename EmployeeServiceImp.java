package org.codingwallah.emproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImp implements EmployeeService { // here we implement the employee service layer 

    @Autowired
    private EmplyeeRespository emplyeeRespository ;


    List<Employee> employees=new ArrayList<>(); 
    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity =new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity); //  here we transfer the model of data to entity
        emplyeeRespository.save(employeeEntity); // here entity is directly map with database through repository
     //  employees.add(employee);
       return "Saved Sucessfully";
    }
    @Override
    public Employee readEmployee(Long id) {
        EmployeeEntity employeeEntity=emplyeeRespository.findById(id).get();
        Employee employee =new Employee();
        BeanUtils.copyProperties( employeeEntity,employee); 
        return employee;
    }

    @Override
    public List<Employee> readEmployees() {
   List<EmployeeEntity> employeesList=  emplyeeRespository.findAll(); // isse poore ka data nikal ke aajayega database se , kyun ki hum service 
                               // layer se hi hum database se baad kar sakthe hai ;
   List<Employee> employees =new ArrayList<>();
   for(EmployeeEntity employeeEntity:employeesList){ // idhar hum for each loop laga kar sab data repository se fetch kar the hain
    Employee emp=new Employee();
       emp.setId(employeeEntity.getId());
      emp.setName(employeeEntity.getName()); // idhar hum enitiy se nikalke model me fix kiya 
      emp.setEmail(employeeEntity.getEmail());
      emp.setPhone(employeeEntity.getPhone());
    employees.add(emp);
   }
       return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) { // before delete id , first i have to recognized (these id i have to deletek), i recognized through id 
         EmployeeEntity emp=emplyeeRespository.findById(id).get(); // employee delete kar ne k liye pora object ku bahar nikalunga  
              // , aur us id ko find kar k get karlunga phir  us ku delete karthunga , 
              // if u want to delete or update first u have to find , ex:findById(id).get();  
        emplyeeRespository.delete(emp);
        return true ;
    }


    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee=emplyeeRespository.findById(id).get(); // pehle existing ku find karege , phir update karege
        existingEmployee.setEmail(employee.getEmail()); // in reademployee udhar hum enitiy se nikalke model me fix kiya 
        existingEmployee.setName(employee.getName()); // idhar hum model se nikal k entity me fix karege
        existingEmployee.setPhone(employee.getPhone()); // idhar hum get kar k ,aur entity me set kardenge 
        
        emplyeeRespository.save(existingEmployee); // phir us entity ko save kardenge dubara , is  ka nayi value save kardiya
        return "Update succesfully";
    }


   
}
