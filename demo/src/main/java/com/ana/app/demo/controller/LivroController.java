package com.ana.app.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ana.app.demo.model.Livro;
import com.ana.app.demo.service.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public String listarTodos(Model model) {
        List<Livro> livros = Arrays.asList(
            new Livro(1L, "Cuidando do Mundo – Turma da Mônica", "https://http2.mlstatic.com/D_NQ_NP_823349-MLB41143889864_032020-O.webp/150", "Educação Ambiental também é coisa de criança, especialmente porque os pequenos estão aprendendo formas de se relacionar com o mundo. Mas por onde começar? Como falar sobre um tema que parece tão distante do universo infantil? Veja as respostas neste gibi.", "https://www.baixelivros.com.br/quadrinhos/cuidando-do-mundo"),
            new Livro(2L, "A Arte da Guerra – Sun Tzu", "https://image.slidesharecdn.com/aartedaguerra-ok-220206120853/85/A-arte-da-guerra-LIVRO-1-638.jpg/150", "Descrição: Filósofo que se tornou general cujo nome individual era Wu, nasceu no Estado de Ch’i na China, próximo de 500 a.C., em um auge das ciências militares e legislativas daquele país. Sun Tzu escreveu a “Arte da Guerra”.", "https://www.baixelivros.com.br/literatura-estrangeira/a-arte-da-guerra"),
            new Livro(3L, "Nossos Cordéis – Teones Suzano", "https://static.wixstatic.com/media/ab9de1_f0043f027f74493eaa6cb67b8d732945~mv2.jpg/v1/fill/w_290,h_351,al_c,lg_1,q_80,enc_auto/CAPA%20292_JPG.jpg/150", "Esta publicação é parte de uma série de ações que visam oportunizar aos jovens, homens e mulheres, a continuidade da permanência na sua região, em diversas atividades, não só agrícolas. O jovem Teones Almeida, é filho de agricultor e agricultora da região atendida pelo projeto e, por meio dos seus cordéis, resgata e valoriza a região semiárida.", "https://www.baixelivros.com.br/literatura-de-cordel/nossos-cordeis")
        );
        model.addAttribute("livros", livros);
        return "livros";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Livro livro) {
        livroService.salvar(livro);
        return "redirect:/livros";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return "redirect:/livros";
    }
}
