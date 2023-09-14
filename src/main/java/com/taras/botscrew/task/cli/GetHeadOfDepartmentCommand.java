package com.taras.botscrew.task.cli;

import com.taras.botscrew.task.domain.Lecturer;
import com.taras.botscrew.task.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class GetHeadOfDepartmentCommand implements Command {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public String getTemplate() {
        return "Who is head of department (.*)";
    }

    @Override
    public String execute(String query) {
        Pattern pattern = Pattern.compile(getTemplate());
        Matcher matcher = pattern.matcher(query);
        if (matcher.find()) {
            String departmentName = matcher.group(1);
            Lecturer headOfDepartment = departmentService.getHeadOfDepartmentByName(departmentName);
            return "Head of %s department is %s".formatted(departmentName, headOfDepartment.getFullName());
        } else {
            throw new RuntimeException("Match failed");
        }
    }
}
