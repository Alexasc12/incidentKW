package org.example.repository;

import org.example.model.Accident;
import org.example.model.AccidentType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccidentTypeRepository extends CrudRepository<AccidentType,Integer> {
    @Override
    List<AccidentType> findAll();



}
