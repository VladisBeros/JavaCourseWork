package com.university.departmnetmanagement.contollers;

import com.university.departmnetmanagement.models.Department;
import com.university.departmnetmanagement.service.DepartmentService;
import com.university.departmnetmanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final String redirect = "redirect:/departments";

    private final DepartmentService departmentService;

    private final EmployeeService employeeService;

    @GetMapping
    public String departments(Model model) {
        model.addAttribute("departments", departmentService.listDepartments());
        return "departments";
    }

    @GetMapping("/{id}")
    public String departmentInfo(@PathVariable Long id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        if (department != null) {
            model.addAttribute("department", department);
            model.addAttribute("allEmployees", employeeService.listEmployees());
            return "department-info";
        }
        return redirect;
    }

    @PostMapping("/create")
    public String createDepartment(Department department) {
        departmentService.addDepartment(department);
        return redirect;
    }

    @PostMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return redirect;
    }

    @PostMapping("/{id}")
    public String addEmployeesToDepartment(@PathVariable Long id, @RequestParam List<Long> employeeIds) {
        departmentService.addEmployeesToDepartment(id, employeeIds);
        return "redirect:/departments/" + id;
    }
}