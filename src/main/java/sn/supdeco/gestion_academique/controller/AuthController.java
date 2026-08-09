package sn.supdeco.gestion_academique.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/connexion")
    public String login() {
        return "auth/login";
    }
}
