package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface RoleService {

    void saveRole(Role role);

    Role getRoleById(Long id);

    Role getRoleByType(String type);

    List<Role> getAllRoles();
}
