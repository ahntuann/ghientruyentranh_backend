package com.alloymobile.restapi.resource;

import com.alloymobile.restapi.persistence.Department;
import com.alloymobile.restapi.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentResource {
    DepartmentService service;

    public DepartmentResource(DepartmentService service) {
        this.service = service;
    }

    @GetMapping(value = "/departments")
    public List<Department> getAll() {
        return this.service.getAll();
    }

    @GetMapping(value = "/departments/{id}")
    public Department getById(@PathVariable Long id) {
        return this.service.getById(id);
    }

    @PostMapping(value = "/departments")
    public Department add(Department department) {
        return this.service.add(department);
    }

    @PutMapping(value = "/departments/{id}", consumes = "application/json")
    public Department update(Long id, Department department) {
        return this.service.update(id, department);
    }

    @DeleteMapping(value = "/departments/{id}")
    public void delete(Long id) {
        this.service.delete(id);
    }
}
