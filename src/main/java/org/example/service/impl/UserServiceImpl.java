package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.User;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
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
}
