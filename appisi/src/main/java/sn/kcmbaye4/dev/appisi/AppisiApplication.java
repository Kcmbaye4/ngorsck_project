package sn.kcmbaye4.dev.appisi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sn.kcmbaye4.dev.appisi.entities.Product;
import sn.kcmbaye4.dev.appisi.sec.entities.AppRole;
import sn.kcmbaye4.dev.appisi.sec.entities.AppUser;
import sn.kcmbaye4.dev.appisi.sec.service.SecurityService;
import sn.kcmbaye4.dev.appisi.service.AppIsiService;

import java.util.List;

@SpringBootApplication
public class AppisiApplication {


	public static void main(String[] args) {
		SpringApplication.run(AppisiApplication.class, args);
	}

	//@Bean
	CommandLineRunner start(AppIsiService appIsiService, SecurityService securityService){
		return args -> {
			securityService.addAppUsers(
					List.of(
							AppUser.builder().username("mkc").password("123").build(),
							AppUser.builder().username("mhs").password("123").build()
					)
			);

			securityService.addAppRoles(
					List.of(
							AppRole.builder().roleName("USER").build(),
							AppRole.builder().roleName("ADMIN").build()
					)
			);

		};
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
