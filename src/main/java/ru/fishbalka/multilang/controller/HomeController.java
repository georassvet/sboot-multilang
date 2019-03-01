package ru.fishbalka.multilang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
@RequestMapping(value={"/{locale:en|ru}/login"})
    public String staticResource(Model model){
        return "login";
    }
}
