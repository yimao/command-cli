package com.ctlcode.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

@SpringBootApplication
public class CommandCliApplication implements CommandLineRunner, ExitCodeGenerator {
    private final CommandLine.IFactory factory;
    private final CommandCliRunner commandCliRunner;
    private int exitCode;

    public CommandCliApplication(CommandLine.IFactory factory, CommandCliRunner commandCliRunner) {
        this.factory = factory;
        this.commandCliRunner = commandCliRunner;
    }

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(CommandCliApplication.class, args)));
    }

    @Override
    public void run(String... args) throws Exception {
        exitCode = new CommandLine(commandCliRunner, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}