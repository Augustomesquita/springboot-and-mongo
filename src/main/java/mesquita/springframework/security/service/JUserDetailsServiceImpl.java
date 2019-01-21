package mesquita.springframework.security.service;

import mesquita.springframework.model.User;
import mesquita.springframework.services.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import mesquita.springframework.security.JJwtUserFactory;

/**
 *
 * @author Augusto Mesquita
 */
@Service
public class JUserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.findByEmail(username);
        
        if (user.isPresent()) {
            return JJwtUserFactory.create(user.get());
        }
        
        throw new UsernameNotFoundException("Email de usuário não encontrado.");
    }
    
}
