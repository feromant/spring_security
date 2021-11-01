package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
//@SessionAttributes("roles")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC-SECURITY application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "hello";
	}

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }

	@GetMapping("/admin")
	public String getAllUsers(Model model) {
//		model.addAttribute("roles", roleService.getAllRoles());
		model.addAttribute("users", userService.getAllUsers());
		return "index";
	}

	@GetMapping("user/{id}")
	public String getUserById(@PathVariable("id") Long id, Model model) {
//		model.addAttribute("roles", roleService.getAllRoles());
		model.addAttribute("user", userService.getUserById(id));
		return "user";
	}

	@ModelAttribute("roleList")
	public List<Role> initializeRoles() {
		return roleService.getAllRoles();
	}

	@GetMapping("new")
	public String addUser(Model model) {
//		model.addAllAttributes(roleService.getAllRoles());
		model.addAttribute("user", new User());
		return "new";
	}

	@PostMapping("/admin")
	public String addUser(@ModelAttribute("user") User user,
						  @RequestParam(value = "roles") Set<Role> roles,
						  Model model) {

//		user.setRoles(user.getRoles().stream()
//				.map(role -> roleService.getRoleByType(role.getRole()))
//				.collect(Collectors.toSet()));
//		user.setRoles(new HashSet<>());
//		model.addAttribute("roles", roleService.getAllRoles());
		if (roles != null) {
			for (Role role : roles) {
//				roles.add(roleService.getRoleByType(role.getRole()));
				user.addRole(role);
			}
		}
//		user.setRoles(roles);
		userService.addUser(user);
		return "redirect:/admin";
	}

	@GetMapping("/{id}/edit")
	public String updateUserById(@PathVariable("id") Long id,  Model model) {
		model.addAttribute("user", userService.getUserById(id));
//		model.addAttribute("roles", roleService.getAllRoles());
		return "edit";
	}

	@PutMapping("/{id}")
	public String updateUser(@ModelAttribute("user") User user,
							 @RequestParam(value = "roles") Set<Role> roles,
							 Model model) {
//		roles = user.getRoles();
//		model.addAttribute("roles", user.getRoles());
		if (roles != null) {
			for (Role role : roles) {
				user.addRole(role);
			}
		}
		userService.updateUser(user);
		return "redirect:/admin";
	}
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
		return "redirect:/admin";
	}
}