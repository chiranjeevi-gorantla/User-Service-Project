package com.security.userService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
  @Id
  @GeneratedValue(strategy = AUTO)
  private Long id;
  private String name;
  private String username;
  private String password;

  @ManyToMany(fetch = EAGER)
  private Collection<UserRole> roles = new ArrayList<>();
}
