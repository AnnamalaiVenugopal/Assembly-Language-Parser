package com.miko.interview.AssemblyLanguageParser.Registry;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RegistryReadAndWrite {

    private static String filename = "../registerMap.ser";

    public static void writeRegisterMap(Map<String, Integer> registerMap){
        try(FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file)){
            out.writeObject(registerMap);
            System.out.println("Object has been serialized");
        } catch(IOException ex) {
            System.out.println("Exception occurred while saving the state of the register map");
        }
    }

    public static Map<String, Integer> readRegisterMap(){
        Map<String, Integer> registerMap;
        try(FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file)){
            registerMap = (Map<String, Integer>)in.readObject();
        } catch(IOException ex) {
            System.out.println("IOException is caught");
            registerMap = new HashMap<>();
        } catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
            registerMap = new HashMap<>();
        }

        return registerMap;
    }
}
