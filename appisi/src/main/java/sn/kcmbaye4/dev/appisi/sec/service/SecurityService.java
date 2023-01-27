package sn.kcmbaye4.dev.appisi.sec.service;

import sn.kcmbaye4.dev.appisi.sec.entities.AppRole;
import sn.kcmbaye4.dev.appisi.sec.entities.AppUser;

import java.util.List;

public interface SecurityService {
    AppUser addAppUser(String username, String password);
    List<AppUser> getAllAppUsers();
    AppUser findUserByUsername(String username);
    AppRole addAppRole(AppRole appRole);
    List<AppRole> getAllAppRoles();
    AppRole findAppRoleByRoleName(String roleName);
    void addAppRoleToAppUser(String username, String roleName);
    List<AppUser> addAppUsers(List<AppUser> appUsers);
    List<AppRole> addAppRoles(List<AppRole> appRoles);
}
