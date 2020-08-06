package org.caxineirosdegema.connectingpeople.services;

import org.caxineirosdegema.connectingpeople.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceIMPL implements UserService{

    private ApplicationService applicationService;



    @Override
    public void addUser(User user) {


        applicationService.registUser(user);


    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public User saveOrUpdate(User user) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }


    public ApplicationService getApplicationService() {
        return applicationService;
    }

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
}
