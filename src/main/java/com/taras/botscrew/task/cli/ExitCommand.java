package com.taras.botscrew.task.cli;

import org.springframework.stereotype.Component;

@Component
public class ExitCommand implements Command {

    @Override
    public String getTemplate() {
        return "Exit";
    }

    @Override
    public String execute(String query) {
        System.exit(0);
        return null;
    }
}
