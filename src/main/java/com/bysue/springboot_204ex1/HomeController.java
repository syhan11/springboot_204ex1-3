package com.bysue.springboot_204ex1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class HomeController {
    @GetMapping("/carform")
    public String loadCarForm (Model model) {
        model.addAttribute("carvar", new Car());
        return "carform";
    }

    @PostMapping("/carform")
    public String processCarForm (@Valid Car tempcarvar, BindingResult result, Model model) {
        model.addAttribute("carvar", tempcarvar);
        if (result.hasErrors())
            return "carform";
        return "carconfirm";
    }
}
