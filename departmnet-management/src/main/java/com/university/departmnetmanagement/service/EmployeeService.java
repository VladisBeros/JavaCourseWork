package com.university.departmnetmanagement.service;

import com.university.departmnetmanagement.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public void addEmployee(Employee employee) {
        employee.setId(counter.incrementAndGet());
        employees.add(employee);
    }

    public void deleteEmployee(Long id) {
        employees.removeIf(employee -> employee.getId().equals(id));
    }

    public List<Employee> listEmployees() {
        return employees;
    }
}