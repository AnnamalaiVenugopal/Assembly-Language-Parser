package com.miko.interview.AssemblyLanguageParser.Commands;

import com.miko.interview.AssemblyLanguageParser.Models.CommandHistory;
import com.miko.interview.AssemblyLanguageParser.Registry.Registry;
import com.miko.interview.AssemblyLanguageParser.Repository.CommandHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public abstract class Commands {

    protected Registry registry;

    @Autowired
    public Commands(Registry registry){
        this.registry = registry;
    }


    @Autowired
    protected CommandHistoryRepository commandHistoryRepository;
    public abstract void displayCommandName();
    public abstract boolean executeCommand(String... parameters);

    public void saveCommandToHistory(String command, boolean commandExecutionStatus){
        String[] commandSplitUp = command.split(" ");
        CommandHistory commandHistory = new CommandHistory();
        commandHistory.setCommand(command);
        String commandType;
        if(commandSplitUp[0] == "MV"){
            commandType = "MOVE";
        }else {
            commandType = commandSplitUp[0];
        }
        commandHistory.setCommandType(commandType);

        commandHistory.setCommandExecutionResult(Boolean.toString(commandExecutionStatus));
        commandHistory.setCreatedDate(new Date());
        commandHistoryRepository.save(commandHistory);
    }
}
