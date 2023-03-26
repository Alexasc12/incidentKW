package org.example.app.repository;

import org.example.app.model.AccidentType;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccidentTypeRepository extends CrudRepository<AccidentType,Integer> {
    @Override
    List<AccidentType> findAll();
}
