package sn.kcmbaye4.dev.appisi.sec.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.kcmbaye4.dev.appisi.sec.entities.AppRole;
import sn.kcmbaye4.dev.appisi.sec.entities.AppUser;

public interface AppRoleRepos extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
