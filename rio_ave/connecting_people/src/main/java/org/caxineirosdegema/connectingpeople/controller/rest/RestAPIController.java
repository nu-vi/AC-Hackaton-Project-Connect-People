package org.caxineirosdegema.connectingpeople.controller.rest;

import org.caxineirosdegema.connectingpeople.MockingStuff;
import org.caxineirosdegema.connectingpeople.model.Event;
import org.caxineirosdegema.connectingpeople.model.User;
import org.caxineirosdegema.connectingpeople.services.ApplicationService;
import org.caxineirosdegema.connectingpeople.services.ApplicationServiceIMPL;
import org.caxineirosdegema.connectingpeople.services.EventService;
import org.caxineirosdegema.connectingpeople.services.UserService;
import org.caxineirosdegema.connectingpeople.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class RestAPIController {

    private ApplicationService applicationService;
    private UserService userService;
    private EventService eventService;


    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable Integer id) {

        MockingStuff mockingStuff = new MockingStuff();

        mockingStuff.setUserService(userService);
        mockingStuff.setEventService(eventService);


        if(mockingStuff.populate()) {
            User user = userService.get(id);

            User userDTO = user;
            userDTO.removeComplexObjects();

            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }

    @RequestMapping(method = RequestMethod.POST, path = "/create-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@Valid @RequestBody User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        user.setId(userService.getNextId());
        user.setFriendsList(new LinkedList<User>());
        user.setEventSet(new HashSet<Event>());

        if(userService.addUser(user)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    @RequestMapping(method = RequestMethod.PUT, path = "/edit-user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editUser(@PathVariable Integer id, @Valid @RequestBody User newUser, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User oldUser = userService.get(id);

        newUser.setId(id);
        newUser.setFriendsList(oldUser.getFriendsList());


        if(userService.saveOrUpdate(oldUser, newUser)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path="/delete-user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        if(userService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}/event-set", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Event>> getUserEvents(@PathVariable Integer id) {

        MockingStuff mockingStuff = new MockingStuff();

        mockingStuff.setEventService(eventService);
        mockingStuff.setUserService(userService);

        if(mockingStuff.populate()) {

            User user = userService.get(id);

            Set<Event> eventSet = user.getEventSet();

            Set<Event> eventSetDTO = new HashSet<>();

            for (Event event: eventSet) {
                event.setOwnerName(event.getOwner().getName());
                event.setOwner(null);

                eventSetDTO.add(event);
            }

            return new ResponseEntity<>(eventSetDTO, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}/friends", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUserFriends(@PathVariable Integer id) {

        MockingStuff mockingStuff = new MockingStuff();

        mockingStuff.setEventService(eventService);
        mockingStuff.setUserService(userService);

        if(mockingStuff.populate()) {

            User user = userService.get(id);

            List<User> userList = user.getFriendsList();

            List<User> userListDTO = new LinkedList<>();

            for (User newUser: userList) {
                newUser.removeComplexObjects();

                userListDTO.add(newUser);

            }

            return new ResponseEntity<>(userListDTO, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



    @RequestMapping(method = RequestMethod.GET, path = "/user/{uid}/event/{eid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> getEvent(@PathVariable Integer uid, @PathVariable Integer eid) {

        MockingStuff mockingStuff = new MockingStuff();

        mockingStuff.setUserService(userService);
        mockingStuff.setEventService(eventService);


        if(mockingStuff.populate()) {
            Event event = eventService.get(uid, eid);


            Event eventDTO = event;
            eventDTO.removeComplexObjects();
            eventDTO.setOwnerName(userService.get(uid).getName());



            return new ResponseEntity<>(eventDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }

    @RequestMapping(method = RequestMethod.POST, path = "/user/{uid}/create-event", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createEvent(@PathVariable Integer uid, @Valid @RequestBody Event event, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(eventService.addEvent(event, uid)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    @RequestMapping(method = RequestMethod.POST, path = "/user/{uid}/edit-event/{eid}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity editEvent(@PathVariable Integer uid, @PathVariable Integer eid, @Valid @RequestBody Event event, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        event.setOwner(userService.get(uid));
        event.setId(eid);

        if(eventService.saveOrUpdate(event, uid)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, path="/user/{uid}/delete-event/{eid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteEvent(@PathVariable Integer uid, @PathVariable Integer eid) {

        if(eventService.delete(uid, eid)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
