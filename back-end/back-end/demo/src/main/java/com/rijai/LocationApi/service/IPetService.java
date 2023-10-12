package com.rijai.LocationApi.service;

import com.rijai.LocationApi.model.*;

import java.util.List;
public interface IPetService {

    List<Pet> getPets();

    Pet addPet(Pet pet);

    Pet updatePet(long id);

    Pet getPet(long id);

    Pet deletePet(long id);
}
