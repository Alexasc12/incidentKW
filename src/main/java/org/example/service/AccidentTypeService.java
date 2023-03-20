package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.AccidentType;
import org.example.repository.AccidentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccidentTypeService {

    private final AccidentTypeRepository accidentTypeRepository;

    public List<AccidentType> getAllAccidentType() {
        return accidentTypeRepository.findAll();
    }

    public Optional<AccidentType> getAccidentTypeByID(int id) {
        return Optional.ofNullable(accidentTypeRepository.
                findById(id).orElseThrow(()-> new NoSuchElementException("Не найден элемент")));
    }

}
