package ir.example.businessside.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "Login";
    }

    @GetMapping(value = "/profile", params = {"name", "family", "email", "dob", "sex"})
    public String getProfile(Model model,
                             @RequestParam("name") String name,
                             @RequestParam("family") String family,
                             @RequestParam("email") String email,
                             @RequestParam("dob") String dob,
                             @RequestParam("sex") Boolean sex) {
        model.addAttribute("name", name);
        model.addAttribute("family", family);
        model.addAttribute("email", email);
        model.addAttribute("dob", dob);
        model.addAttribute("sex", sex ? "زن" : "مرد");
        return "Profile";
    }
}
