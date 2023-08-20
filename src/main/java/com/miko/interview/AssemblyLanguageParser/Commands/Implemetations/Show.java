package com.miko.interview.AssemblyLanguageParser.Commands.Implemetations;

import com.miko.interview.AssemblyLanguageParser.Commands.Commands;
import com.miko.interview.AssemblyLanguageParser.Registry.Registry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Show extends Commands {

    @Autowired
    public Show(Registry registry) {
        super(registry);
    }

    @Override
    public void displayCommandName() {
        System.out.println("The command name is SHOW");
    }

    @Override
    public boolean executeCommand(String... registerName) {
        Map<String, Integer> registerMap = registry.getRegisterMap();
        if(registerMap.isEmpty()){
            System.out.println("Registry is empty");
            return false;
        }

        System.out.println("Register Name | Register Value");
        for(Map.Entry<String, Integer> entry: registerMap.entrySet()){
            System.out.println(entry.getKey()+" | "+ entry.getValue());
        }
        return true;
    }
}
