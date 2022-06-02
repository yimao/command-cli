package com.ctlcode.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@Component
@CommandLine.Command(name = "command-cli", version = "1.0", mixinStandardHelpOptions = true)
public class CommandCliRunner implements Callable<Integer> {
    private static final Logger logger = LoggerFactory.getLogger(CommandCliRunner.class);

    @CommandLine.Option(names = {"-action", "-a"}, required = true)
    private String action;

    @Override
    public Integer call() throws Exception {
        try {
            System.out.println("call action: " + action);
            return 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            logger.error(e.getMessage(), e);
            return 1;
        }
    }
}
