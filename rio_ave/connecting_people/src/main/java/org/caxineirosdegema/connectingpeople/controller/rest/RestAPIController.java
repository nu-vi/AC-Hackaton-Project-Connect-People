package org.caxineirosdegema.connectingpeople.controller.rest;

import org.caxineirosdegema.connectingpeople.model.User;
import org.caxineirosdegema.connectingpeople.services.ApplicationService;
import org.caxineirosdegema.connectingpeople.services.UserService;
import org.caxineirosdegema.connectingpeople.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestAPIController {

    private ApplicationService applicationService;
    private UserService userService;
    private EventService eventService;


    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}")
    public ResponseEntity<User> userResponseEntity(@PathVariable Integer id) {

        User user = userService.getUser(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, path = "/user/{id}")
    public ResponseEntity<User> userResponseEntity(@PathVariable Integer id) {

        User user = userService.getUser(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }










































    public ApplicationService getApplicationService() {
        return applicationService;
    }

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public EventService getEventService() {
        return eventService;
    }

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
