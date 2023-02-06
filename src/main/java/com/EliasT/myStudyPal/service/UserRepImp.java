package com.EliasT.myStudyPal.service;

import com.EliasT.myStudyPal.model.User;
import com.EliasT.myStudyPal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRepImp implements UserRepoInterface{
    @Autowired
    private UserRepository userRepo;


    @Override
    public User addUser(User user) {


            return userRepo.save(user);


    }

    @Override
    public void deleteALluser() {
        userRepo.deleteAll();
    }

    @Override
    public void deleteUser(int id) {

        userRepo.deleteById(id);
    }

    @Override
    public Optional<User> getUser(int id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepo.findAll().stream().
                filter(user-> user.getName().equals(name)).toList();
    }

    public List<User> getAllUser(){
        return  userRepo.findAll();
    }
}
