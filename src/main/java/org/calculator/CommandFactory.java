package org.calculator;

import org.commands.Command;

import java.io.InputStream;
import java.util.Properties;


public class CommandFactory {
    Properties config = new Properties(); //public class Properties extends Hashtable<Object,Object>

    public CommandFactory() throws Exception {
        try (InputStream is = CommandFactory.class.getResourceAsStream("/commands.properties"))
        {
            if (is == null) throw new Exception("Config file not found!");
            config.load(is);
        }
    }

    public Command createCommand(String commandName) throws Exception {

        String className = config.getProperty(commandName);
        if (className == null) throw new Exception("Unknown command: " + commandName);

        Class<?> command = Class.forName(className);

        return (Command) command.getDeclaredConstructor().newInstance();
    }
}
