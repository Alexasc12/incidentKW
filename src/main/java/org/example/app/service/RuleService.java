package org.example.app.service;

import lombok.AllArgsConstructor;
import org.example.app.model.Rule;
import org.example.app.repository.RuleRepository;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class RuleService {

 private final RuleRepository repository;

 public List<Rule> getAll() {
  return repository.findAll();
 }

 public Set<Rule> getRuleByID(List<Integer> id) {
  Set<Rule> rules = new HashSet<>();
  for (Integer type : id) {
   Optional<Rule> rule = repository.findById(type);
   rule.ifPresent(rules::add);

  }return rules;
 }
}




