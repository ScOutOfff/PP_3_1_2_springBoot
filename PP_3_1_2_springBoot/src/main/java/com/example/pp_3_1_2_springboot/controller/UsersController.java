package com.example.pp_3_1_2_springboot.controller;

import com.example.pp_3_1_2_springboot.model.User;
import com.example.pp_3_1_2_springboot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    //List of All users________________________________________________________
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "users";
    }

    //Adding a new User_________________________________________________________
    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping(value = "/users")
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.add(user);
        return "redirect:users";
    }

    //Deleting a User_________________________________________________________________
    @DeleteMapping(value = "users/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    //Editing a User_____________________________________________________________________
    @GetMapping(value = "users/{id}/update")
    public String updateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping(value = "users/{id}")
    public String update(@ModelAttribute("user") @Valid User user,BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        userService.add(user);
//        userService.editUser(id, user);
        return "redirect:/users";
    }
}
