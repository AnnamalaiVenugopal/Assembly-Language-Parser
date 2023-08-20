package com.miko.interview.AssemblyLanguageParser.Commands.Implemetations;

import com.miko.interview.AssemblyLanguageParser.Commands.Commands;
import com.miko.interview.AssemblyLanguageParser.Registry.Registry;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Add extends Commands {

    @Autowired
    public Add(Registry registry) {
        super(registry);
    }

    @Override
    public void displayCommandName() {
        System.out.println("The command name is ADD");
    }

    @Override
    public boolean executeCommand(String... parameters) {
        String value1 = parameters[0];
        String value2 = parameters[1];
        Map<String, Integer> registerMap = registry.getRegisterMap();
        if(value1 == null || value2 == null || value1.isEmpty() || value2.isEmpty()){
            System.out.println("Invalid Parameters");
            return false;
        }

        if(!registerMap.containsKey(value1)){
            System.out.println("Invalid First Register Name. Please enter a valid register name.");
            return false;
        }

        int sum = registerMap.get(value1);

        if(StringUtils.isNumeric(value2)){
            sum += Integer.parseInt(value2);
        } else {
            if(!registerMap.containsKey(value2)){
                System.out.println("Invalid Second Register Name. Please enter a valid register name.");
                return false;
            }
            sum += registerMap.get(value2);
        }
        registry.addRegisterAndValue(value1, sum);
        System.out.println("Added the sum of the values in the registry.");
        return true;
    }
}
