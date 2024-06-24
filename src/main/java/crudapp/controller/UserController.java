package crudapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import crudapp.model.User;
import crudapp.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping("/users/new")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/user/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        Optional<User> userOptional = userService.getUserById(id);
        User user = userOptional.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "editUser";
    }

    @PutMapping("/user/edit")
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        userService.createOrUpdateUser(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/test")
    public String testPage() {
        return "test";
    }
}
