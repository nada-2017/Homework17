package com.example.homework17.Service;

import com.example.homework17.Model.MyUser;
import com.example.homework17.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<MyUser> getAllUsers(){
        return userRepository.findAll();
    }

    public void addAllUser(MyUser user){
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id, MyUser user){
        MyUser oldUser = userRepository.getById(id);

        if (oldUser == null)
            return false;
        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setAge(user.getAge());

        userRepository.save(oldUser);
        return true;

    }

    public Boolean deleteUser(Integer id){
        MyUser user = userRepository.getById(id);
        if (user == null)
            return false;
        userRepository.delete(user);
        return true;
    }
}
