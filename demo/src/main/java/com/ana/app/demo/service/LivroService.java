package com.ana.app.demo.service;

import com.ana.app.demo.model.Livro;
import java.util.List;

public interface LivroService {
    List<Livro> listarTodos();
    Livro salvar(Livro livro);
    void deletar(Long id);
}
