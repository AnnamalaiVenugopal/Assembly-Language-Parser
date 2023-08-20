package com.miko.interview.AssemblyLanguageParser.Commands.factory;

import com.miko.interview.AssemblyLanguageParser.Commands.CommandNames;
import com.miko.interview.AssemblyLanguageParser.Commands.Commands;
import com.miko.interview.AssemblyLanguageParser.Commands.Implemetations.Add;
import com.miko.interview.AssemblyLanguageParser.Commands.Implemetations.Move;
import com.miko.interview.AssemblyLanguageParser.Commands.Implemetations.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandsFactory {

    private Add add;
    private Move move;
    private Show show;

    @Autowired
    public CommandsFactory(Add add, Move move, Show show){
        this.add = add;
        this.move = move;
        this.show = show;
    }

    public Commands getCommand(CommandNames commandName){
        switch (commandName){
            case ADD: return add;
            case MOVE: return move;
            case SHOW_REG: return show;
            default: return null;
        }
    }
}
