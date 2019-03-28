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
        model.addAttribute("car", new Car());
        return "carform";
    }

    @PostMapping("/carform")
    public String processCarForm (@Valid Car car, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "carform";
        }
        return "carconfirm";
    }
}
