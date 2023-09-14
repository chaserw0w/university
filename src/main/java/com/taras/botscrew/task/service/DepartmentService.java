package com.taras.botscrew.task.service;

import com.taras.botscrew.task.domain.Degree;
import com.taras.botscrew.task.domain.Department;
import com.taras.botscrew.task.domain.Lecturer;
import com.taras.botscrew.task.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.taras.botscrew.task.domain.Degree.*;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Lecturer getHeadOfDepartmentByName(String departmentName) {
        Department department = departmentRepository.findByDepartmentName(departmentName);
        if (department != null) {
            return department.getHeadOfDepartment();
        }
        throw new RuntimeException("Department not found");
    }

    public Map<String, Long> getDepartmentStatistics(String departmentName) {
        Department department = departmentRepository.findByDepartmentName(departmentName);
        if (department != null) {
            Set<Lecturer> lecturers = department.getLecturers();

            long assistantsCount = countLecturersByDegree(lecturers, ASSISTANT);
            long associateProfessorsCount = countLecturersByDegree(lecturers, ASSOCIATE_PROFESSOR);
            long professorsCount = countLecturersByDegree(lecturers, PROFESSOR);

            Map<String, Long> statistics = new HashMap<>();
            statistics.put("Assistants", assistantsCount);
            statistics.put("Associate Professors", associateProfessorsCount);
            statistics.put("Professors", professorsCount);

            return statistics;
        }
        throw new RuntimeException("Department not found!");
    }

    private long countLecturersByDegree(Set<Lecturer> lecturers, Degree degree) {
        return lecturers.stream()
                .filter(lecturer -> lecturer.getDegree() == degree)
                .count();
    }

    public double getAverageSalary(String departmentName) {
        Department department = departmentRepository.findByDepartmentName(departmentName);
        if (department != null) {
            Set<Lecturer> lecturers = department.getLecturers();
            if (!lecturers.isEmpty()) {
                double totalSalary = lecturers.stream()
                        .mapToDouble(Lecturer::getSalary)
                        .sum();
                return totalSalary / lecturers.size();
            }
        }
        throw new RuntimeException("Department not found!");
    }

    public int getLecturersCount(String departmentName) {
        Department department = departmentRepository.findByDepartmentName(departmentName);
        if (department != null) {
            return department.getLecturers().size();
        }
        throw new RuntimeException("Department not found!");
    }

    public List<Department> globalSearchByTemplate(String searchTemplate) {
        return departmentRepository.findByDepartmentNameContainingIgnoreCase(searchTemplate);
    }
}
