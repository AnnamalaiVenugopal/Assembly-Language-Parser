package com.miko.interview.AssemblyLanguageParser.Registry;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component
public class Registry implements Serializable {
    private final Map<String, Integer> registerMap = new HashMap<>();

    public void loadRegistry(Map<String, Integer> registerMapFromFile){
        registerMap.putAll(registerMapFromFile);
    }

    public Map<String, Integer> getRegisterMap(){
        return registerMap;
    }

    public void addRegisterAndValue(String registerName, int registerValue){
        if(registerMap.containsKey(registerName)){
            registerMap.replace(registerName,registerValue);
        } else {
            registerMap.put(registerName,registerValue);
        }
    }

}
