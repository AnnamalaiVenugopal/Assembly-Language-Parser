package com.miko.interview.AssemblyLanguageParser;

import com.miko.interview.AssemblyLanguageParser.Parser.AssemblyLanguageParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AssemblyLanguageParserApplication implements CommandLineRunner {

	AssemblyLanguageParser assemblyLanguageParser;

	@Autowired
	public AssemblyLanguageParserApplication(AssemblyLanguageParser assemblyLanguageParser){
		this.assemblyLanguageParser = assemblyLanguageParser;
	}

	public AssemblyLanguageParserApplication(){}

	public static void main(String[] args) {
		SpringApplication.run(AssemblyLanguageParserApplication.class, args);
	}

	@Override
	public void run(String... args) {
		assemblyLanguageParser.greetings();
		try(Scanner inputScanner = new Scanner(System.in)) {
			assemblyLanguageParser.preProcessor();
			boolean continueStatus;
			List<String> programCommands = new ArrayList<>();
			System.out.println("Enter the program");

			do {
				String command = inputScanner.nextLine();
				if(StringUtils.isNotBlank(command)){
					programCommands.add(command);
				}
				continueStatus = command.equals("SHOW REG");
			} while (!continueStatus);
			assemblyLanguageParser.parseCommand(programCommands);
		}catch(Exception e){
			System.out.println("Exception occurred in the application.");
			e.printStackTrace();
		} finally {
			assemblyLanguageParser.postProcessor();
		}
	}
}
