package com.usermicroservice.controller;


import com.usermicroservice.model.Order;
import com.usermicroservice.model.User;
import com.usermicroservice.tool.RestClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("api/user")
@RestController
public class UserController {

    @GetMapping("")
    public ResponseEntity<List<User>> get() {
        //Get users
        List<User> userList = Arrays.asList(new User(1, "toto", "toto.test@gmail.com"), new User(2, "tata", "tata.test@gmail.com"));

        //Get Orders from order
        RestClient<Order[], Integer> restClient = new RestClient<>();

        userList.forEach(u -> {
            Order[] orders = restClient.get("order/"+u.getUserId(), Order[].class);
            u.setOrders(Arrays.stream(orders).toList());
        });

        return ResponseEntity.ok(userList);
    }
}
