package org.example.app.repository;

import org.example.app.model.Rule;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RuleRepository extends CrudRepository<Rule,Integer> {
    @Override
    List<Rule> findAll();
}
