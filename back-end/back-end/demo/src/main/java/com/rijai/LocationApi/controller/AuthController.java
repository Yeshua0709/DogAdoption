package com.rijai.LocationApi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rijai.LocationApi.service.UserService;
import com.rijai.LocationApi.model.*;
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Authenticate the user
        if (userService.authenticate(username, password)) {
            // Generate a token or return a success message
            String token = generateJwtToken(username);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


    private String generateJwtToken(String username) {

        if(!username.equals("admin")){
            return "CLIENT LOGIN";
        }
        else{
            return "ADMIN LOGIN";
        }


    }

}
