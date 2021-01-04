package com.example.demo.controller;


import com.example.demo.model.entities.Employee;
import com.example.demo.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;


    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @GetMapping("/findById/{id}")
    public Employee findById(@PathVariable("id") int id){
        return service.getEmployeeById(id);
    }
    @GetMapping("/findByName/{name}")
    public Employee findEmployeeByName(@PathVariable("name") String name){
        return service.getEmployeeByName(name);
    }
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        return service.deleteEmployee(id);
    }
}
