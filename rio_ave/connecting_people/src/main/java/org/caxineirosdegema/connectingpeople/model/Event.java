package org.caxineirosdegema.connectingpeople.model;


import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Event {

    private Integer id;

    @NotNull(message = "Event title is mandatory")
    @NotBlank(message = "Event title is mandatory")
    private String title;

    @NotNull(message = "Event description is mandatory")
    @NotBlank(message = "Event description is mandatory")
    private String description;

    @NotNull(message = "Event location is mandatory")
    @NotBlank(message = "Event location is mandatory")
    private String location;

    @NotNull(message = "Event access is mandatory")
    @NotBlank(message = "Event access is mandatory")
    private boolean publicAccess;

    @NotNull(message = "Event owner is mandatory")
    @NotBlank(message = "Event owner is mandatory")
    private User owner;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isPublicAccess() {
        return publicAccess;
    }

    public void setPublicAccess(boolean publicAccess) {
        this.publicAccess = publicAccess;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
