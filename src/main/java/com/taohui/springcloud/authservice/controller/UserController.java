package com.taohui.springcloud.authservice.controller;

import com.taohui.springcloud.authservice.entity.User;
import com.taohui.springcloud.authservice.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/current")
  public Principal getUser(Principal principal) {
    return principal;
  }

  @PostMapping
  public void createUser(@RequestBody User user) {
    userService.create(user);
  }
}
