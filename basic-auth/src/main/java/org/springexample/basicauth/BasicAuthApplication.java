package org.springexample.basicauth;

import org.springexample.basicauth.dto.CreateUserRequest;
import org.springexample.basicauth.model.Role;
import org.springexample.basicauth.repository.UserRepository;
import org.springexample.basicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

    private final UserService userService;

    public BasicAuthApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicAuthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createDummyData();
    }

    private void createDummyData(){
        CreateUserRequest request = CreateUserRequest.builder()
                .name("Efe")
                .username("EAyyildiz")
                .password("root")
                .authorities(Set.of(Role.ROLE_USER))
                .build();

        userService.createUser(request);

        CreateUserRequest request2 = CreateUserRequest.builder()
                .name("admin")
                .username("username17")
                .password("root")
                .authorities(Set.of(Role.ROLE_ADMIN))
                .build();

        userService.createUser(request2);

        CreateUserRequest request3 = CreateUserRequest.builder()
                .name("mod")
                .username("mod17")
                .password("root")
                .authorities(Set.of(Role.ROLE_MOD))
                .build();

        userService.createUser(request3);
    }
}
