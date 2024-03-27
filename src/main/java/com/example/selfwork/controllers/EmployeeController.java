package com.example.selfwork.controllers;

import com.example.selfwork.entity.Employee;
import com.example.selfwork.service.EmployeeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
  private final EmployeeService employeeService;
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }
  @GetMapping("/all")
  public ResponseEntity<List<Employee>> getAllEmployees(){
    return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
    return new ResponseEntity<>(employeeService.findEmployeeById(id), HttpStatus.OK);
  }
  @PostMapping("/add")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
    return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
  }
  @PutMapping("/update")
  public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
    return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
  }
  @Transactional
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
    employeeService.deleteEmployee(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
