package org.example.app.service;

import org.example.app.model.Accident;
import org.example.app.model.AccidentType;
import org.example.app.model.Rule;
import org.example.app.repository.AccidentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class AccidentService {
    private final AccidentRepository accidentRepository;

    @Autowired
    public AccidentService(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public boolean saveAccident(Accident accident, Optional<AccidentType> accidentTypeOptional, Set<Rule> ruleSet) {
       AccidentType accidentType =  accidentTypeOptional.get();
       accident.setType(accidentType);
       accident.setRules(ruleSet);
       return accidentRepository.save(accident) != null;


    }


    public void removeAccidentById(int id) {
        //нашли ассидент
        Accident accident = accidentRepository.findById(id)
                // функциональный интерфейс используем, для выброса исключения
                .orElseThrow(() -> new EntityNotFoundException("Случай с указанным id не найден"));
        // удалили его
        accidentRepository.delete(accident);
    }


    public boolean update(Accident accident) {
        final Map<Integer, Accident> accidentMap = new HashMap<>();
        final List<Accident> accidentList = accidentRepository.findAll();
        for (Accident a : accidentList) {
            accidentMap.put(accident.getId(), a);
        }
        return accidentMap.computeIfPresent(accident.getId(), (accidentId, oldAccident) -> new Accident(
                accidentId, accident.getName(), accident.getDescription(), accident.getAddress(), accident.getType(), accident.getRules())) != null;
    }

    public List<Accident> findAllAccident() {
        return accidentRepository.findAll();
    }

    public Optional<Accident> findAccidentById(int id) {
        final Accident accident = accidentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Не найден id"));

        return Optional.ofNullable(accident);


    }


}




