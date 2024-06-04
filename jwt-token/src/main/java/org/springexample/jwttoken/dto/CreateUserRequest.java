package org.springexample.jwttoken.dto;

import lombok.Builder;
import org.springexample.jwttoken.model.Role;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
) {


}
