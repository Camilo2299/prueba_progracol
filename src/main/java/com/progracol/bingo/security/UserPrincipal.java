package com.progracol.bingo.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.progracol.bingo.Models.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserPrincipal implements UserDetails {

  private static final long serialVersionUID = 1L;
  private Long id;
  private String name;
  private String username;
  @JsonIgnore
  private String password;
  private String role;
  private Collection<? extends GrantedAuthority> authorities;

  public UserPrincipal(Long id, String name, String username, String password, String role,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
    this.role = role;
    this.authorities = authorities;
  }

  public static UserPrincipal build(UserEntity user) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(user.getRol().getName()));
    return new UserPrincipal(user.getId(), user.getName(), user.getUsername(), user.getPassword(),
        user.getRol().getName(), authorities);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserPrincipal user = (UserPrincipal) o;
    return Objects.equals(id, user.id);
  }

}
