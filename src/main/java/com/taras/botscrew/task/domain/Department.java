package com.taras.botscrew.task.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    private String departmentName;

    @OneToOne
    @JoinColumn(name = "head_of_department_id")
    private Lecturer headOfDepartment;

    @ManyToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    private Set<Lecturer> lecturers = new HashSet<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", lecturers=" + lecturers +
                '}';
    }
}
