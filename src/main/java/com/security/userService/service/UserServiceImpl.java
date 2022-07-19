package com.security.userService.service;

import com.security.userService.model.AppUser;
import com.security.userService.model.UserRole;
import com.security.userService.repository.RoleRepository;
import com.security.userService.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new user {} to the database", user.getName());
        return userRepository.save(user);
    }

    @Override
    public UserRole saveRole(UserRole role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        log.info("Adding role {} to the user {}", rolename, username);
        AppUser user = userRepository.findByUsername(username);
        UserRole role = roleRepository.findByName(rolename);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
