package com.taras.botscrew.task.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Slf4j
public class CLI implements CommandLineRunner {
    @Autowired
    private List<Command> commands;

    private Optional<Command> findCommand(String query) {
        return commands.stream().filter(command -> {
            Pattern pattern = Pattern.compile(command.getTemplate());
            Matcher matcher = pattern.matcher(query);
            return matcher.find();
        }).findFirst();
    }

    @Override
    public void run(String... args) throws Exception {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader reader = new BufferedReader(isr)) {

            boolean isRunning = true;
            while (isRunning) {
                try {
                    System.out.println("User input: ");
                    String query = reader.readLine();

                    Optional<Command> command = findCommand(query);
                    command.ifPresentOrElse(
                            c -> System.out.println("Answer: " + c.execute(query)),
                            () -> System.out.println("Command not found")
                    );
                } catch (Exception e) {
                    log.error("Exception occurred: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
