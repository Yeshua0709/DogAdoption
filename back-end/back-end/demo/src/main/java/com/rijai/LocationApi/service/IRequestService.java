package com.rijai.LocationApi.service;
import com.rijai.LocationApi.model.*;

import java.util.List;
public interface IRequestService {

    List <Request> getRequests();

    Request addRequest(Request request);


    Request updateRequest(long id);

    Request getRequest(long id);

    Request deleteRequest(long id);

}
