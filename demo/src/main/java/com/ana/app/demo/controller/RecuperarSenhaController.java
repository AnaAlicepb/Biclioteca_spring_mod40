package com.ana.app.demo.controller;

import com.ana.app.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecuperarSenhaController {

    @Autowired
    private UsuarioService usuarioService; // Serviço para acessar dados do usuário

    @GetMapping("/esqueceu-senha")
    public String mostrarFormularioRecuperacao() {
        return "recuperar_senha";
    }

    @PostMapping("/enviar-senha")
    public String recoverPassword(@RequestParam String email, Model model) {
        // Recupera a senha do usuário do banco de dados usando o e-mail
        String senha = usuarioService.recuperarSenhaPorEmail(email);
        if (senha != null) {
            model.addAttribute("senha", "Sua senha é: " + senha);
            return "recuperar_senha";
        } else {
            // Tratar caso em que o e-mail não foi encontrado
            model.addAttribute("error", "E-mail não encontrado.");
            return "recuperar_senha";
        }
    }
}
