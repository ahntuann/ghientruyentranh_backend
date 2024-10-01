package com.alloymobile.restapi.service;

import com.alloymobile.restapi.persistence.Department;
import com.alloymobile.restapi.persistence.DepartmentRepository;
import org.aspectj.lang.annotation.DeclareWarning;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> getAll() {
        return this.repository.findAll();
    }

    public Department getById(Long Id) {
        return this.repository.findById(Id).get();
    }

    public Department add(Department department) {
        return this.repository.save(department);
    }

    public Department update(Long Id, Department department) {
        Optional<Department> dept = this.repository.findById(Id);
        if (dept.isPresent()) {
            dept.get().setName(department.getName());
            return this.repository.save(dept.get());
        }

        throw new RuntimeException();
    }

    public void delete(Long Id) {
        Optional<Department> dept = this.repository.findById(Id);
        if (dept.isPresent()) {
            this.repository.deleteById(Id);
        }
    }
}
