package com.ana.app.demo.service;

import com.ana.app.demo.model.Usuario;


import com.ana.app.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    @Override
    public Usuario salvarUsuario(Usuario usuario) {      
          return usuarioRepository.save(usuario);
    }
    
    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
    @Override
    public String recuperarSenhaPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null) {
            return usuario.getSenha();
        }
        return null;
    }
}

