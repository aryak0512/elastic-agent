package com.aryak.elastic.controller;


import com.aryak.elastic.entity.Employee;
import com.aryak.elastic.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    private final EmployeeRepository repository;

    public DemoController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<Employee> employees() throws Exception {

        repository.save(new Employee(
                System.currentTimeMillis(),
                "Aryak",
                "Engineering"
        ));

        Thread.sleep(500);

        return repository.findAll();
    }

    @GetMapping("/error")
    public String error() {
        throw new RuntimeException("Dummy exception for APM");
    }
}