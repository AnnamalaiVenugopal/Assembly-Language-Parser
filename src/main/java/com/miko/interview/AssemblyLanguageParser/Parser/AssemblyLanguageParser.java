package com.miko.interview.AssemblyLanguageParser.Parser;

import com.miko.interview.AssemblyLanguageParser.Commands.CommandNames;
import com.miko.interview.AssemblyLanguageParser.Commands.Commands;
import com.miko.interview.AssemblyLanguageParser.Commands.factory.CommandsFactory;
import com.miko.interview.AssemblyLanguageParser.Registry.Registry;
import com.miko.interview.AssemblyLanguageParser.Registry.RegistryReadAndWrite;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class AssemblyLanguageParser {

    private Registry registry;
    private CommandsFactory commandsFactory;

    @Autowired
    public AssemblyLanguageParser(Registry registry, CommandsFactory commandsFactory){
        this.registry = registry;
        this.commandsFactory = commandsFactory;
    }

    public AssemblyLanguageParser(){}

    public void greetings(){
        System.out.println("--------------------------------");
        System.out.println("WELCOME TO THE ASSEMBLY LANGUAGE");
        System.out.println("--------------------------------");
        System.out.println("We have the following commands.");
        System.out.println("1.Move Command");
        System.out.println("MV <register_name> <register_value>");
        System.out.println("2.Add Command");
        System.out.println("ADD <register_name> <register_value>/<register_name>");
        System.out.println("3.Show Command");
        System.out.println("SHOW REG");
        System.out.println("End a program with SHOW REG command");
    }

    public void preProcessor(){
        registry.loadRegistry(RegistryReadAndWrite.readRegisterMap());
    }

    public void parseCommand(List<String> programCommands){
        if(!programCommands.isEmpty()) {
            Commands commands = null;
            boolean commandExecutionStatus = false;
            for(String command: programCommands) {
                System.out.println(command);
                if (command == null || command.isEmpty() || command.trim().isEmpty()) {
                    System.out.println("Empty command passed. Please enter a valid command");
                    return;
                }
                String[] commandSplitUp = command.split(" ");

                switch (commandSplitUp[0]) {
                    case "ADD":
                        commands = commandsFactory.getCommand(CommandNames.ADD);
                        break;
                    case "MV":
                        commands = commandsFactory.getCommand(CommandNames.MOVE);
                        break;
                    case "SHOW":
                        commands = commandsFactory.getCommand(CommandNames.SHOW_REG);
                        break;
                    default:
                        System.out.println("Enter a valid command.\n 1.ADD\n2.MV\n3.SHOW REG\n");
                }

                if (commands != null) {
                    commands.displayCommandName();
                    if(command.equalsIgnoreCase("SHOW REG")){
                        commandExecutionStatus = commands.executeCommand();
                    } else {
                        commandExecutionStatus = commands.executeCommand(commandSplitUp[1].split(","));
                    }
                }
                if(!commandExecutionStatus){
                    break;
                }
            }
            commands.saveCommandToHistory(StringUtils.join(programCommands, "\n"), commandExecutionStatus);
        }
    }

    public void postProcessor(){
        RegistryReadAndWrite.writeRegisterMap(registry.getRegisterMap());
    }
}
