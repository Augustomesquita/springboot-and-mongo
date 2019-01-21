package mesquita.springframework.security;

import mesquita.springframework.enums.EProfile;
import mesquita.springframework.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author Augusto Mesquita
 */
public class JJwtUserFactory {

    public JJwtUserFactory() {
    }

    /**
     * Converte e gera um JJwtUser com base nos dados de um usuário do sistema.
     *
     * @param user
     * @param funcionario
     * @return JwtUser
     */
    public static JJwtUser create(User user) {
        return new JJwtUser(user.getId(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getProfile()));
    }

    /**
     * Converte EProfile para o formato utilizado pelo Spring Security
     *
     * @param perfilEnum
     * @return List<GrantedAuthority>
     */
    private static List<GrantedAuthority> mapToGrantedAuthorities(
            EProfile profileEnum) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
        return authorities;
    }

}
