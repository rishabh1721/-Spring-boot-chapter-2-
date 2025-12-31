package com.chapter2.chapter2.controllers;


import com.chapter2.chapter2.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Hello World!";
//    }
//

    @GetMapping("/employees/{employeeID}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeID") Long employeeID) {
        return new EmployeeDTO(employeeID, "rishabh", "rishu@gmail.com", 21, LocalDate.of(2025,10,10), true);
    }

    @GetMapping(path = "/employees")
    public String getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String name, @RequestParam(required = false) LocalDate startDate, @RequestParam(required = false) LocalDate endDate) {
        return "Hi age"+age;
    }

    @PostMapping
    public String createEmployee(@RequestBody EmployeeDTO inputEmployee) {
        inputEmployee.setId(100L);
        return inputEmployee.toString();
    }

    @PutMapping
    public String updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return "hello from put";
    }

}
