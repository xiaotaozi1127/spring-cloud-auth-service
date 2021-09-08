package com.taohui.springcloud.authservice.service;

import com.taohui.springcloud.authservice.entity.User;
import com.taohui.springcloud.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  @Override
  public void create(User user) {
    String hash = encoder.encode(user.getPassword());
    user.setPassword(hash);
    userRepository.save(user);
  }
}
