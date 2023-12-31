package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    private String error = "Passwords do not match!";

    @GetMapping("/add")
    public String displayAddUserForm(){
        return "user/add";
    }
    @PostMapping("user")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        if (!user.getPassword().equals(verify)) {
            model.addAttribute("error", error);
            model.addAttribute("savedUsername", user.getUsername());
            model.addAttribute("savedEmail", user.getEmail());
            return "user/add";
        }
        model.addAttribute("user", user);
        return "user/index";

    }

}
