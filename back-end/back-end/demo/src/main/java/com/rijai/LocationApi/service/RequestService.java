package com.rijai.LocationApi.service;

import com.rijai.LocationApi.model.*;
import com.rijai.LocationApi.model.Pet;
import com.rijai.LocationApi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service
public class RequestService implements IRequestService {

    @Autowired
    private RequestRepository repository;

    public List <Request> getRequests() {return (List<Request>) repository.findAll();}

    public Request getRequest(long id){
        Optional optional = repository.findById(id);
        if(optional.isEmpty())
            return null;
        else
            return (Request)optional.get();

    }

    public Request addRequest(Request request){return repository.save(request);}


    public Request updateRequest(long id) {
        Optional<Request> request = repository.findById(id);
        if(request.isPresent()) {
            return repository.save(request.get());
        }
        else
            return null;
    }

    public Request deleteRequest(long id)
    {
        Optional<Request> request = repository.findById(id);
        if(request.isPresent()) {
            repository.delete(request.get());
        }
        return null;

    }
}

