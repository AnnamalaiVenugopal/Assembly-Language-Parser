package com.miko.interview.AssemblyLanguageParser.Repository;

import com.miko.interview.AssemblyLanguageParser.Models.CommandHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandHistoryRepository extends CrudRepository<CommandHistory, Integer> {
}
