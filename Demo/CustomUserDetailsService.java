package com.sumit.Spring.Security.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
// Implementing userDetails in customUserDetails
@Service
public class CustomUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new  UsernameNotFoundException("User not foundd");
        return new CustomUserDetails(user);  // it  will set all details to userdetails and we will get userdetails object itself.
        // Now we have to pass data back as userDetails. So create a file "CustomUserDetails"
    }
}
