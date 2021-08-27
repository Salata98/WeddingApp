package pl.weseleam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {

        return "home.html";
    }

    @GetMapping("/setdetails")
    public String  setdetails() {

        return "setdetails.html";
    }

    @GetMapping("/login")
    private String login() {

        return "login.html";
    }

    @GetMapping("/guestlist")
    private String guestlist() {

        return "admin.html";
    }



    @RequestMapping("/login-error")
    private String loginError(){
        return "errorlog.html";
    }

}
