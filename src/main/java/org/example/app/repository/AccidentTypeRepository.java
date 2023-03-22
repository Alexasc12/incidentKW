package org.example.app.repository;

import org.example.app.model.AccidentType;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccidentTypeRepository extends CrudRepository<AccidentType,Integer> {
    @Override
    List<AccidentType> findAll();



}
