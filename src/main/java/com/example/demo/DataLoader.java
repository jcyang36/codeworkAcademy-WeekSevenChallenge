package com.example.demo;
import com.example.demo.Role;
import com.example.demo.User;
import com.example.demo.Job;
import com.example.demo.RoleRepository;
import com.example.demo.UserRepository;
import com.example.demo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
@Component
public class DataLoader implements CommandLineRunner{
    @Autowired
    JobRepository jobRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading data . . .");
        Job job = new Job("Software Developer", "TechA", "40000-45000", "Coding, meeting with program manager", "Java, Debugging");
        jobRepository.save(job);
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");
        User user = new User("bob@bob.com","bob","Bob","Bobberson", true, "bob");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
        user = new User("jim@jim.com","jim","Jim","Jimmerson", true, "jim");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
        user = new User("admin@secure.com","password","Admin","User", true, "admin");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);
        user = new User("sam@every.com","password","Sam","Everyman", true, "everyman");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList(userRole, adminRole));
        userRepository.save(user);
    }
}
