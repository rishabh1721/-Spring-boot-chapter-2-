package com.chapter2.chapter2.controllers;

import com.chapter2.chapter2.dto.EmployeeDTO;
import com.chapter2.chapter2.entities.EmployeeEntity;
import com.chapter2.chapter2.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Test endpoint
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    // GET all employees
    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // GET employee by ID
    @GetMapping("/{employeeID}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeID) {
        return employeeRepository.findById(employeeID)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // CREATE employee
    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    // UPDATE employee
    @PutMapping("/{employeeID}")
    public EmployeeEntity updateEmployee(
            @PathVariable Long employeeID,
            @RequestBody EmployeeEntity employee
    ) {
        EmployeeEntity existing = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setAge(employee.getAge());
        existing.setBirthday(employee.getBirthday());
        existing.setIsActive(employee.getIsActive());

        return employeeRepository.save(existing);
    }
}

