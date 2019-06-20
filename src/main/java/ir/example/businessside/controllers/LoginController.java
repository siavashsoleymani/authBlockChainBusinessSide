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

    @GetMapping(value = "/profile", params = {"name", "dob", "sex"})
    public String getProfile(Model model,
                             @RequestParam("name") String name,
                             @RequestParam("dob") String dob,
                             @RequestParam("sex") Boolean sex) {
        model.addAttribute("name", name);
        model.addAttribute("dob", dob);
        model.addAttribute("sex", !sex ? "زن" : "مرد");
        return "Profile";
    }
}
