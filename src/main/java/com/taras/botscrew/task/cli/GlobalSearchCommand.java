package com.taras.botscrew.task.cli;

import com.taras.botscrew.task.domain.Department;
import com.taras.botscrew.task.domain.Lecturer;
import com.taras.botscrew.task.service.DepartmentService;
import com.taras.botscrew.task.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class GlobalSearchCommand implements Command {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private LecturerService lecturerService;

    @Override
    public String getTemplate() {
        return "Global search by (.*)";
    }

    @Override
    public String execute(String query) {
        Pattern pattern = Pattern.compile(getTemplate());
        Matcher matcher = pattern.matcher(query);
        if (matcher.find()) {
            String template = matcher.group(1);

            List<Department> departmentResults = departmentService.globalSearchByTemplate(template);
            List<Lecturer> lecturersResults = lecturerService.globalSearchByTemplate(template);

            StringBuilder resultBuilder = new StringBuilder();

            if (!departmentResults.isEmpty()) {
                resultBuilder.append("\nDepartments:");
                for (Department department: departmentResults) {
                    resultBuilder.append(department.getDepartmentName()).append("\n");
                }
            }

            if (!lecturersResults.isEmpty()) {
                resultBuilder.append("\nLecturers:");
                for (Lecturer lecturer: lecturersResults) {
                    resultBuilder.append("\n").append(lecturer.getFullName());
                }
                resultBuilder.append("\n");
            }

            return resultBuilder.toString();
        } else {
            throw new RuntimeException("Match failed");
        }
    }
}
