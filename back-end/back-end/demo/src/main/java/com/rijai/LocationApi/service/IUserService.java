package com.rijai.LocationApi.service;
import com.rijai.LocationApi.model.*;
import java.util.List;
public interface IUserService {

    User findByUsername(String username);
    boolean authenticate(String username, String password);
}
