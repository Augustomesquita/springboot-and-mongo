package mesquita.springframework.services;


import mesquita.springframework.model.User;
import java.util.Optional;

/**
 *
 * @author Augusto Mesquita
 */
public interface UserService {

    /**
     * Busca e retorna um usuário dado um email.
     *
     * @param email
     * @return Optional<JUser>
     */
    Optional<User> findByEmail(String email);

    /**
     * Busca e retorna um usuário dado um email.
     *
     * @param email
     * @return Optional<JUser>
     */
    Optional<User> findByEmailAndPassword(String email, String password);

    /**
     * Criado um novo usuário baseado nos dados de nome, email e senha que foram
     * passados.
     *
     * @param name
     * @param email
     * @param password
     */
    public User save(String name, String email, String password, String photoUrl);

    /**
     * Criado um novo usuário baseado no objeto usuário passado.
     *
     * @param name
     * @param email
     * @param password
     */
    public User save(User user);
}
