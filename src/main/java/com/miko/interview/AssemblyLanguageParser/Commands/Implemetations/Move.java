package com.miko.interview.AssemblyLanguageParser.Commands.Implemetations;

import com.miko.interview.AssemblyLanguageParser.Commands.Commands;
import com.miko.interview.AssemblyLanguageParser.Registry.Registry;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Move extends Commands {

    @Autowired
    public Move(Registry registry) {
        super(registry);
    }

    @Override
    public void displayCommandName() {
        System.out.println("The command name is MOVE");
    }

    @Override
    public boolean executeCommand(String... parameters) {
        Map<String, Integer> registerMap = registry.getRegisterMap();

        String registerName = parameters[0];
        String registerValue = parameters[1];

        if(registerName.isEmpty()){
            System.out.println("Empty Register Name. Please enter a valid register name");
            return false;
        }
        if(registerValue.isEmpty()){
            System.out.println("Empty Register Value. PLease enter a valid register value");
            return false;
        }

        if(!registerValue.startsWith("#")){
            System.out.println("Invalid register value. Please enter a register constant that starts with # "+ registerValue);
            return false;
        }
        if(!StringUtils.isNumeric(registerValue.substring(1))){
            System.out.println("Invalid register value. Please enter a constant that starts with # and followed by digits " + registerValue);
            return false;
        }

        registry.addRegisterAndValue(registerName, Integer.parseInt(registerValue.substring(1)));
        System.out.println("Added the register and constant to the registry successfully !!!!");
        return true;
    }
}
