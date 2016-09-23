package com.dsobko.rest.service;

import com.dsobko.rest.service.errors.PersonNotFoundException;
import com.dsobko.rest.service.objects.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Created by dsobko on 09/23/2016.
 */
@Service
public class MongoDBPersonService implements PersonService {

    private final PersonRepository repository;

    @Autowired
    MongoDBPersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonDTO create(@NotNull PersonDTO person) {
        Person persisted = new Person();
        persisted.setId(person.getId())   ;
        persisted.setName(person.getName());
        persisted.setDescription(person.getDescription());
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }

    @Override
    public PersonDTO delete(@NotNull String id) {
        Person deleted = findPersonById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }

    @Override
    public List<PersonDTO> findAll() {
        List<Person> PersonEntries = repository.findAll();
        return convertToDTOs(PersonEntries);
    }

    private List<PersonDTO> convertToDTOs(List<Person> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @Override
    public PersonDTO findById(String id) {
        Person found = findPersonById(id);
        return convertToDTO(found);
    }

    @Override
    public PersonDTO update(PersonDTO person) {
        Person updated = findPersonById(person.getId());
        updated.setDescription(person.getDescription());
        updated.setName(person.getName());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    private Person findPersonById(String id) {
        Optional<Person> result = repository.findOne(id);
        return result.orElseThrow(() -> new PersonNotFoundException(id));

    }

    private PersonDTO convertToDTO(Person model) {
        PersonDTO dto = new PersonDTO();

        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());

        return dto;
    }
}