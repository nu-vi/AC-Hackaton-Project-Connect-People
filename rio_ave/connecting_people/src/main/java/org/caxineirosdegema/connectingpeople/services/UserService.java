package org.caxineirosdegema.connectingpeople.services;

import org.caxineirosdegema.connectingpeople.model.User;

public interface UserService {

    void addUser(User user);

    User get(Integer id);

    User saveOrUpdate(User user);

    void delete(Integer id);
}
