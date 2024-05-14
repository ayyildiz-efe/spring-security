package org.springexample.basicauth.dto;

import lombok.Builder;
import org.springexample.basicauth.model.Role;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
) {


}
