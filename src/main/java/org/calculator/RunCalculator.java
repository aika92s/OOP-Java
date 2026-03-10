package org.calculator;
import org.commands.Command;
import org.commands.Context;
import java.util.Arrays;

public class RunCalculator {
    private final Context context = new Context();
    private final CommandFactory factory;

    public RunCalculator() throws Exception {
        factory = new CommandFactory();
    }

    public void parseAndExecute(String string) throws Exception {

        string = string.trim();

        if (string.isEmpty() || string.startsWith("#")) {
            return;
        }
        String[] strings = string.split("\\s+");

        String commandName = strings[0];
        String[] args = Arrays.copyOfRange(strings, 1, strings.length);

            Command command = factory.createCommand(commandName);
            command.execute(context, args);

    }
}
