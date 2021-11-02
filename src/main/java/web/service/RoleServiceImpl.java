package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao dao;

    @Override
    public void saveRole(Role role) {
        dao.addRole(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return dao.getRoleById(id);
    }

    @Override
    public Role getRoleByType(String type) {
        return dao.getRoleByType(type);
    }

    @Override
    public List<Role> getAllRoles() {
        return dao.getAllRoles();
    }
}
