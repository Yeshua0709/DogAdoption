package com.rijai.LocationApi.repository;

import com.rijai.LocationApi.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PetRepository extends CrudRepository <Pet, Long> {
}