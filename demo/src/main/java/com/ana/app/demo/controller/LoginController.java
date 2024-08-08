package com.ana.app.demo.controller;

import com.ana.app.demo.model.Usuario;

import com.ana.app.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Usuario usuario, Model model) {
        Usuario usuarioExistente = usuarioService.buscarPorEmail(usuario.getEmail());
        if (usuarioExistente != null && usuarioExistente.getPassword() != null &&
            usuarioExistente.getPassword().equals(usuario.getPassword())) {
            return "redirect:/livros"; // Redirecionar para a página de livros após o login
        } else {
            model.addAttribute("error", "Email ou senha inválidos");
            return "login";
        }
    }
}
