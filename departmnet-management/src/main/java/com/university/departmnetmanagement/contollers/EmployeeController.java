package com.university.departmnetmanagement.contollers;

import com.university.departmnetmanagement.models.Employee;
import com.university.departmnetmanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.listEmployees());
        return "employees";
    }

    @PostMapping
    public String createEmployee(Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }
}