package com.taras.botscrew.task.cli;

import com.taras.botscrew.task.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ShowAverageSalaryCommand implements Command{

    @Autowired
    private DepartmentService departmentService;

    @Override
    public String getTemplate() {
        return "Show the average salary for the department (.*)";
    }

    @Override
    public String execute(String query) {
        Pattern pattern = Pattern.compile(getTemplate());
        Matcher matcher = pattern.matcher(query);
        if (matcher.find()) {
            String departmentName = matcher.group(1);
            double averageSalary = departmentService.getAverageSalary(departmentName);
            return "The average salary of %s is $%s".formatted(departmentName, averageSalary);
        } else {
            throw new RuntimeException("Match failed");
        }
    }
}
