package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
public class DBInitializer {

    boolean alreadySetup = false;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @PostConstruct
    public void initDB() {

        if (alreadySetup)
            return;

//        Role adminRole = createRoleIfNotFound("ROLE_ADMIN");
//        createRoleIfNotFound("ROLE_USER");
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
//        roleService.saveRole(adminRole);
        Role userRole = new Role();
        userRole.setRole("USER");
//        roleService.saveRole(userRole);

        User admin = new User();
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setAge((byte) 45);
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setEmail("admin@test.com");
        Set<Role> rolesAdmin = new HashSet<>();
        rolesAdmin.add(adminRole);
        admin.setRoles(rolesAdmin);
        userService.addUser(admin);
        roleService.saveRole(adminRole);

        User user = new User();
        user.setFirstName("user");
        user.setLastName("user");
        user.setAge((byte) 34);
        user.setPassword(passwordEncoder.encode("user"));
        user.setEmail("user@test.com");
        Set<Role> rolesUser = new HashSet<>();
        rolesUser.add(adminRole);
        user.setRoles(rolesUser);
        userService.addUser(user);
        roleService.saveRole(userRole);

        alreadySetup = true;
    }

//    @Transactional
//    Role createRoleIfNotFound(String name) {
//
//        Role role = roleService.getRoleByType(name);
//        if (role == null) {
//            role = new Role(name);
//            roleService.saveRole(role);
//        }
//        return role;
//    }
}
