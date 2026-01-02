package com.chapter2.chapter2.controllers;

import com.chapter2.chapter2.dto.EmployeeDTO;
import com.chapter2.chapter2.entities.EmployeeEntity;
import com.chapter2.chapter2.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/{employeeID}")
    public EmployeeDTO getEmployeeById(
            @PathVariable(name = "employeeID") Long employeeID
    ) {
        return new EmployeeDTO(
                employeeID,
                "rishabh",
                "rishu@gmail.com",
                21,
                LocalDate.of(2025, 10, 10),
                true
//        return employeeRepository.findById(id).orElse(null);
        );
    }

    @GetMapping
    public String getAllEmployees(
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate
    ) {
        return "Hi age " + age;
    }

    @PostMapping
    public String createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return "hello from post";
    }

    @PutMapping
    public String updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return "hello from put";
    }
}
