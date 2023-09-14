package com.taras.botscrew.task.cli;

import com.taras.botscrew.task.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ShowDepartmentStatisticsCommand implements Command {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public String getTemplate() {
        return "Show (.*) statistics";
    }

    @Override
    public String execute(String query) {
        Pattern pattern = Pattern.compile(getTemplate());
        Matcher matcher = pattern.matcher(query);
        if (matcher.find()) {
            String departmentName = matcher.group(1);
            Map<String, Long> departmentStatistics = departmentService.getDepartmentStatistics(departmentName);

            return formatDepartmentStatistics(departmentStatistics);
        } else {
            throw new RuntimeException("Match failed");
        }
    }

    private String formatDepartmentStatistics(Map<String, Long> statistics) {
        StringBuilder resultBuilder = new StringBuilder();

        for (Map.Entry<String, Long> entry : statistics.entrySet()) {
            String degree = entry.getKey();
            Long count = entry.getValue();
            resultBuilder.append(degree).append(" - ").append(count).append(".\n");
        }
        return resultBuilder.toString();
    }
}
