package com.rijai.LocationApi.service;

import com.rijai.LocationApi.model.Country;
import com.rijai.LocationApi.model.Pet;
import com.rijai.LocationApi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService implements IPetService {

    @Autowired
    private PetRepository repository;

    public List<Pet> getPets() {
        return (List<Pet>) repository.findAll();
    }

    public Pet getPet(long id) {
        Optional optional=repository.findById(id);
        if(optional.isEmpty())
            return null;
        else
            return (Pet)optional.get();
    }

    public Pet addPet(Pet pet) {
        return repository.save(pet);
    }

    public Pet updatePet(long id) {
        Optional<Pet> pet = repository.findById(id);
        if(pet.isPresent()) {
            return repository.save(pet.get());
        }
        else
            return null;
    }

    public Pet deletePet(long id)
    {
        Optional<Pet> pet = repository.findById(id);
        if(pet.isPresent()) {
            repository.delete(pet.get());
        }
        return null;

}

    }
