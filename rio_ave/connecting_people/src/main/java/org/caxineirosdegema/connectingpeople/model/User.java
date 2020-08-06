package org.caxineirosdegema.connectingpeople.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.*;

public class User {

    private Integer id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email
    private String email;
    private String phone;
    private String city;

    private List<User> friendsList;
    private Set<Event> eventSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<User> getFriendsList() {
        return friendsList;
    }





    public void setFriendsList(List<User> friendsList) {
        this.friendsList = friendsList;
    }

    public Set<Event> getEventSet() {
        return eventSet;
    }

    public void setEventSet(Set<Event> eventSet) {
        this.eventSet = eventSet;
    }
}
