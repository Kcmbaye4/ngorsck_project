package sn.kcmbaye4.dev.appisi.sec.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.kcmbaye4.dev.appisi.sec.entities.AppUser;

public interface AppUserRepos extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
