package org.example.repository;

import org.example.model.Accident;
import org.example.model.Rule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RuleRepository extends CrudRepository<Rule,Integer> {
    @Override
    List<Rule> findAll();
}
