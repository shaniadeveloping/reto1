package reto1.controller;

import reto1.model.User;
import reto1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author shania vargas
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }

    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }

    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }
}