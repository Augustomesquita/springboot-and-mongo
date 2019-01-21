package mesquita.springframework.repositories;

import mesquita.springframework.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Augusto Mesquita
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
