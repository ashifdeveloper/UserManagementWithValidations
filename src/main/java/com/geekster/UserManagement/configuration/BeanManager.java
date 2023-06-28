package com.geekster.UserManagement.configuration;

import com.geekster.UserManagement.model.Type;
import com.geekster.UserManagement.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanManager {
    @Bean
    public List<User> getIntializedList(){
        User initUser = new User(0,"Ashif007","1995-07-05","as@gmail.com","8896088434",LocalDate.of(2023,07,05));
        List<User> initList = new ArrayList<>();
        initList.add(initUser);
        return initList;

    }
}
