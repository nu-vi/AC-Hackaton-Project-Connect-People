package org.caxineirosdegema.connectingpeople.services;

import org.caxineirosdegema.connectingpeople.model.User;

public interface ApplicationService {

    void registUser(User user);

    boolean authenticateUser(User user);

}
