package com.miko.interview.AssemblyLanguageParser.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Getter
@Setter
@Entity
public class CommandHistory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String command;

    private String commandExecutionResult;

    private Date createdDate;
}
