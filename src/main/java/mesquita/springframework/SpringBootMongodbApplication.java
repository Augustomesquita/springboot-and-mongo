package mesquita.springframework;

import mesquita.springframework.enums.EProfile;
import mesquita.springframework.model.User;
import mesquita.springframework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMongodbApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            User adminUser = new User();
            adminUser.setProfile(EProfile.ROLE_ADMIN);
            adminUser.setName("admin");
            adminUser.setPassword("master");
            adminUser.setEmail("admin@leucotron.com.br");
            
            User userCreated = userService.save(adminUser);
            if (userCreated.getId() != null) {
                System.out.println("Usuário admin criado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Já existem usuário admin no sistema. " + e.getMessage());
        }
    }

}
