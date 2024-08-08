package com.ana.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ana.app.demo.model.Usuario;
import com.ana.app.demo.service.UsuarioService;

@Controller
public class HomeController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    /*
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    */

    @GetMapping("/registro")
    public ModelAndView registro() {
        ModelAndView mv = new ModelAndView("registro");
        mv.addObject("usuario", new Usuario());
        return mv;
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/login";
    }
}
