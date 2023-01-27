package sn.kcmbaye4.dev.appisi.sec.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.kcmbaye4.dev.appisi.sec.entities.AppRole;
import sn.kcmbaye4.dev.appisi.sec.entities.AppUser;
import sn.kcmbaye4.dev.appisi.sec.repos.AppRoleRepos;
import sn.kcmbaye4.dev.appisi.sec.repos.AppUserRepos;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private AppUserRepos appUserRepos;
    private AppRoleRepos appRoleRepos;

    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser addAppUser(String username, String password) {
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        String hashedPWD = passwordEncoder.encode(password);
        appUser.setPassword(hashedPWD);
        appUser.setActive(true);
        AppUser savedAppUser = appUserRepos.save(appUser);

        return savedAppUser;
    }

    @Override
    public List<AppUser> getAllAppUsers() {
        return appUserRepos.findAll();
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return appUserRepos.findByUsername(username);
    }

    @Override
    public AppRole addAppRole(AppRole appRole) {
        return appRoleRepos.save(appRole);
    }

    @Override
    public List<AppRole> getAllAppRoles() {
        return appRoleRepos.findAll();
    }

    @Override
    public AppRole findAppRoleByRoleName(String roleName) {
        return appRoleRepos.findByRoleName(roleName);
    }

    @Override
    public void addAppRoleToAppUser(String username, String roleName) {
        AppUser appUser = appUserRepos.findByUsername(username);
        AppRole appRole = appRoleRepos.findByRoleName(roleName);
        if(appUser==null) throw new RuntimeException("User not found");
        if(appRole==null) throw new RuntimeException("Role not found");
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public List<AppUser> addAppUsers(List<AppUser> appUsers) {
        return appUserRepos.saveAll(appUsers);
    }

    @Override
    public List<AppRole> addAppRoles(List<AppRole> appRoles) {
        return appRoleRepos.saveAll(appRoles);
    }
}
