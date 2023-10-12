package com.rijai.LocationApi.controller;
import com.rijai.LocationApi.model.*;
import com.rijai.LocationApi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.rijai.LocationApi.repository.PetRepository;
import java.util.List;
import java.util.Optional;



@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class PetController {

    @Autowired
    private IPetService petService;

    @Autowired
    private PetRepository repository;
    @RequestMapping("/api/pets")
    public List<Pet> findPets(){
        return petService.getPets();
    }

    @RequestMapping("/api/show-pet/{id}")
    public Pet showPet(@PathVariable long id) {
        return petService.getPet(id);
    }

    @RequestMapping(value="api/add-pet", method = RequestMethod.POST)
    public Pet addPetSubmit(@RequestBody Pet pet){
        return petService.addPet(pet);
    }

    @RequestMapping(value = "/api/update-pet/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pet> updatePet(@PathVariable long id, @RequestBody Pet updatedPet) {
        Optional<Pet> optionalPet = repository.findById(id);

        if (optionalPet.isPresent()) {
            Pet existingPet = optionalPet.get();

            existingPet.setName(updatedPet.getName());
            existingPet.setAge(updatedPet.getAge());
            existingPet.setImage(updatedPet.getImage());
            existingPet.setStatus(updatedPet.getStatus());
            Pet updated = repository.save(existingPet);
            return ResponseEntity.ok(updated);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/api/delete-pet/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable long id) {
        petService.deletePet(id);
    }

}
