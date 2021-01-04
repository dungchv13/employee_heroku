package com.example.demo.model.service;


import com.example.demo.model.entities.Employee;
import com.example.demo.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }

    public List<Employee> saveEmployees(List<Employee> employees){
        return repository.saveAll(employees);
    }

    public List<Employee> getAll(){
        return repository.findAll();
    }

    public Employee getEmployeeById(int id){
        return repository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name){
        return repository.findByName(name);
    }

    public String deleteEmployee(int id){
        repository.deleteById(id);
        return "Employee removed !! "+id;
    }

    public Employee updateEmployee(Employee employee){
        Employee ex = repository.findById(employee.getId()).orElse(null);
        ex.setName(employee.getName());
        ex.setRole(employee.getRole());
        ex.setSalary(employee.getSalary());

        return repository.save(ex);
    }
}
