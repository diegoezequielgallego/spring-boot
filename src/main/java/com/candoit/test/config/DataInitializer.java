package com.candoit.test.config;

import com.candoit.test.entities.User;
import com.candoit.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        createAndSaveUser("user", "123123", "USER");
        createAndSaveUser("user_admin", "333444", "ADMIN");
        System.out.println("Se crearon correctamente los usuarios");
    }

    private void createAndSaveUser(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(role);
        userRepository.save(user);
    }
}
