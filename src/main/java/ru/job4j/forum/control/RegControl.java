package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.RegService;

@Controller
public class RegControl {
    private final RegService reg;

    public RegControl(RegService service) {
        this.reg = service;
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, Model model) {
        if (reg.checkUserName(user)) {
            return "redirect:/login";
        }
        String errorMessge = "This name already exists";
        model.addAttribute("errorMessge", errorMessge);
        return "reg";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}