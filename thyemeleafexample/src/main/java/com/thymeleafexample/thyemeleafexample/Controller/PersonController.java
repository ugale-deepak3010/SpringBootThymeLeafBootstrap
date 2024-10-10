package com.thymeleafexample.thyemeleafexample.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thymeleafexample.thyemeleafexample.Model.Person;



@Controller
public class PersonController {

    @GetMapping("/")
    @ResponseBody
    public String getHome() {
        return "/person";
    }
    

    @GetMapping("/person")
    public String getMethodName(Model model) {

        model.addAttribute("message1", "Welcome at the People page!");

        model.addAttribute("peoples", List.of(
            new Person(Long.valueOf(1), "Deepak Ugale", Long.valueOf(26)),
            new Person(Long.valueOf(2), "Manali Rahangdhale", Long.valueOf(26))
        ));

        return "people";
    }
    

}
