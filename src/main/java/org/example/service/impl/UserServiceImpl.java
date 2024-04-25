package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.User;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    final UserRepository repository;
    ModelMapper mapper;

    @Bean
    public void setup(){
        this.mapper = new ModelMapper();
    }

    @Override
    public void addUser(User user) {
        UserEntity entity = mapper.map(user,UserEntity.class);
        repository.save(entity);
    }

    @Override
    public boolean updateUser(User user) {
        UserEntity existingUser = repository.findById(user.getId()).orElse(null);
        if(existingUser !=null){
            repository.save(mapper.map(user,UserEntity.class));
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<User> getAllUser() {
        List<UserEntity> entityList = (List<UserEntity>) repository.findAll();
        List<User> userList = new ArrayList<>();

        for(UserEntity entity : entityList){
            userList.add(mapper.map(entity,User.class));
        }
        return userList;
    }

    @Override
    public User searchUserById(Long id) {
        return mapper.map(repository.findById(id),User.class);
    }
}
