package com.rijai.LocationApi.controller;
import com.rijai.LocationApi.model.*;
import com.rijai.LocationApi.repository.RequestRepository;
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
public class RequestController {


    @Autowired
    private IRequestService requestService;

    @Autowired
    private RequestRepository repository;

    @RequestMapping("/api/requests")
    public List<Request> findRequests(){return requestService.getRequests();}

    @RequestMapping("/api/show-request/{id}")
    public Request showRequest(@PathVariable long id) {
        return requestService.getRequest(id);
    }

    @RequestMapping(value="api/add-request", method = RequestMethod.POST)
    public Request addRequestSubmit(@RequestBody Request request){
        return requestService.addRequest(request);
    }

    @RequestMapping(value = "/api/update-request/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Request> updateRequest(@PathVariable long id, @RequestBody Request updatedRequest) {
        Optional<Request> optionalRequest = repository.findById(id);

        if (optionalRequest.isPresent()) {
            Request existingRequest = optionalRequest.get();

            existingRequest.setUserID(updatedRequest.getUserID());
            existingRequest.setPetID(updatedRequest.getPetID());
            existingRequest.setStatus(updatedRequest.getStatus());
            Request updated = repository.save(existingRequest);
            return ResponseEntity.ok(updated);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/api/delete-request/{id}", method = RequestMethod.DELETE)
    public void deleteRequest(@PathVariable long id) {
        requestService.deleteRequest(id);
    }

}
