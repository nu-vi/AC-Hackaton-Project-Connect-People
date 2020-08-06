package org.caxineirosdegema.connectingpeople;

import org.caxineirosdegema.connectingpeople.model.Event;
import org.caxineirosdegema.connectingpeople.model.User;
import org.caxineirosdegema.connectingpeople.services.EventService;
import org.caxineirosdegema.connectingpeople.services.EventService;
import org.caxineirosdegema.connectingpeople.services.UserService;

public class MockingStuff {

    private UserService userService;
    private EventService eventService;

    public boolean populate() {

        User joao = new User();
        User vinagreiro = new User();

        Event futebol = new Event();
        Event tenis = new Event();

        futebol.setId(1);
        futebol.setLocation("porto");
        futebol.setDescription("futebol");
        futebol.setOwner(joao);
        futebol.setPublicAccess(true);
        futebol.setTitle("futebol no porto");

        tenis.setId(2);
        tenis.setLocation("porto");
        tenis.setDescription("tenis");
        tenis.setOwner(joao);
        tenis.setPublicAccess(true);
        tenis.setTitle("tenis no porto");



        joao.setId(1);
        joao.setName("joao");
        joao.setCity("coimbra");
        joao.setEmail("ola@gmail.com");
        joao.setPassword("simsim");

        vinagreiro.setId(2);
        vinagreiro.setName("vinagreiro");
        vinagreiro.setCity("porto");
        vinagreiro.setEmail("vinagreiro@gmail.com");
        vinagreiro.setPassword("simsim");

        joao.getFriendsList().add(vinagreiro);
        joao.getEventSet().add(futebol);
        joao.getEventSet().add(tenis);
        vinagreiro.getFriendsList().add(joao);
        vinagreiro.getEventSet().add(futebol);
        vinagreiro.getEventSet().add(tenis);




        userService.addUser(joao);
        userService.addUser(vinagreiro);

        return true;


    }

    public UserService getUserService() {
        return userService;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public EventService getEventService() {
        return eventService;
    }


    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
