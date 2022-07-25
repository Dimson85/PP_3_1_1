package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    @Transactional
    public boolean saveUser(User user) {
        if (userRepository.findUserByEmail(user.getEmail()) != null) return false;
        userRepository.save(user);
        return true;
    }

    @Transactional
    public boolean saveUser(User user, Long[] roleId) {
        if (userRepository.findUserByEmail(user.getEmail()) != null) return false;
        for (Long id : roleId) {
            user.addRole(roleRepository.getReferenceById(id));
        }
        userRepository.save(user);
        return true;
    }
    @Transactional
    public boolean updateUser(User user, Long[] roleId) {
        for (Long id : roleId) {
            user.addRole(roleRepository.getReferenceById(id));
        }
        userRepository.save(user);
        return true;
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email);
    }
}
