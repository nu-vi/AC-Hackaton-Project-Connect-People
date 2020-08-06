package org.caxineirosdegema.connectingpeople.services;

import org.caxineirosdegema.connectingpeople.model.Event;
import org.caxineirosdegema.connectingpeople.model.User;

public interface EventService {

    void addEvent(Event event);

    Event get(Integer id);

    Event saveOrUpdate(Event event);

    void delete(Integer id);

}
