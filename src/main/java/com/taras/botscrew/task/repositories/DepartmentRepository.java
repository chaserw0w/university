package com.taras.botscrew.task.repositories;

import com.taras.botscrew.task.domain.Department;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

    Department findByDepartmentName(String departmentName);
    List<Department> findByDepartmentNameContainingIgnoreCase(String searchTemplate);
}
