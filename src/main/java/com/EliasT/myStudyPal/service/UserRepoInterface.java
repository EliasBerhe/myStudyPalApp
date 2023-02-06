package com.EliasT.myStudyPal.service;

import com.EliasT.myStudyPal.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepoInterface {

    public User addUser(User user);
    public void deleteALluser();

    public void deleteUser(int id);

    public Optional<User> getUser(int id);

    List<User> findByName(String name);

}
