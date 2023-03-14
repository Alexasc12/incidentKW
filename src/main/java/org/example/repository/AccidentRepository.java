package org.example.repository;

import org.example.model.Accident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentRepository extends CrudRepository <Accident,Integer> {

     List<Accident> findAll();


}
