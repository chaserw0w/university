package com.taras.botscrew.task.cli;

public interface Command {

    String getTemplate();
    String execute(String query);
}
