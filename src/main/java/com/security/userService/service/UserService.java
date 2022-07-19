package com.security.userService.service;

import com.security.userService.model.AppUser;
import com.security.userService.model.UserRole;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    UserRole saveRole(UserRole role);
    void addRoleToUser(String username, String rolename);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
