package org.example.app.repository;

import org.example.app.model.Rule;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RuleRepository extends CrudRepository<Rule,Integer> {
    @Override
    List<Rule> findAll();
}
