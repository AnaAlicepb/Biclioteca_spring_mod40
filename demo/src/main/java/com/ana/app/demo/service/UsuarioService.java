package com.ana.app.demo.service;

import com.ana.app.demo.model.Usuario;


import java.util.List;

public interface UsuarioService {
    List<Usuario> listarTodos();
    Usuario salvar(Usuario usuario); // Para adicionar novo usuário
    Usuario salvarUsuario(Usuario usuario);// Para registrar um novo usuário
    Usuario buscarPorEmail(String username);
    void deletar(Long id);
    String recuperarSenhaPorEmail(String email);
}
