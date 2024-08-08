package com.ana.app.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ana.app.demo.model.Usuario;
import com.ana.app.demo.repository.UsuarioRepository;

class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Teste Nome");
        usuario.setEmail("teste@teste.com");
    }

    @Test
    void listarTodos() {
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario));

        List<Usuario> usuarios = usuarioService.listarTodos();

        assertNotNull(usuarios);
        assertEquals(1, usuarios.size());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void salvar() {
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario usuarioSalvo = usuarioService.salvar(new Usuario());

        assertNotNull(usuarioSalvo);
        assertEquals("Teste Nome", usuarioSalvo.getNome());
        assertEquals("teste@teste.com", usuarioSalvo.getEmail());
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

    @Test
    void deletar() {
        doNothing().when(usuarioRepository).deleteById(usuario.getId());

        usuarioService.deletar(usuario.getId());

        verify(usuarioRepository, times(1)).deleteById(usuario.getId());
    }
}
