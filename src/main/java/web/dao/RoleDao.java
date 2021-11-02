package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {

    void addRole(Role role);

    List<Role> getAllRoles();

    Role getRoleByType(String type);

    Role getRoleById(Long id);
}
