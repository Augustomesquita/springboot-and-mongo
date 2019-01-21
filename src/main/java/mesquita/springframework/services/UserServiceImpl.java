package mesquita.springframework.services;

import mesquita.springframework.enums.EProfile;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mesquita.springframework.model.User;
import mesquita.springframework.repositories.UserRepository;

/**
 *
 * @author Augusto Mesquita
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return Optional.ofNullable(this.userRepository.findByEmailAndPassword(email, password));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(this.userRepository.findByEmail(email));
    }

    @Override
    public User save(String name, String email, String password, String photoUrl) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhotoUrl(photoUrl);
        user.setProfile(EProfile.ROLE_USER);
        return this.userRepository.save(user);
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

}
