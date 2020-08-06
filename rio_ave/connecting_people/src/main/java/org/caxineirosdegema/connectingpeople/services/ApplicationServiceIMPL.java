package org.caxineirosdegema.connectingpeople.services;

import org.caxineirosdegema.connectingpeople.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceIMPL implements ApplicationService {


    private List<User> usersList;



    @Override
    public void registUser(User user) {

        usersList.add(user);
    }

    @Override
    public boolean authenticateUser(User user) {
        return false;
    }
}
