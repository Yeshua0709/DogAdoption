package com.rijai.LocationApi.model;
import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name="requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userID;

    private long petID;

    private String status;

    public Request(){

    }

    public Request(long id, long userID, long petID, String status) {
        this.id = id;
        this.userID = userID;
        this.petID = petID;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getPetID() {
        return petID;
    }

    public void setPetID(long petID) {
        this.petID = petID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return id == request.id && userID == request.userID && petID == request.petID && Objects.equals(status, request.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userID, petID, status);
    }
}
