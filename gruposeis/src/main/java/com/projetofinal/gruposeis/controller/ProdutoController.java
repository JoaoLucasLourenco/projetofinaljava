package com.projetofinal.gruposeis.controller;
import com.projetofinal.gruposeis.model.produto.DadosAlteracaoProduto;
import com.projetofinal.gruposeis.model.produto.DadosCadastraProduto;
import com.projetofinal.gruposeis.model.produto.Produto;
import com.projetofinal.gruposeis.model.produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;


    @GetMapping("/create")
    public String carregaFormulario(Long id, Model model)
    {
        if(id!=null){
            Produto p1 = repository.getReferenceById(id);
            model.addAttribute("produto",p1);
        }
        return "/produto/create";
    }

    @GetMapping("/list")
    public String carregaListagem(Model model, String nomeClassificacao)
    {
        if(nomeClassificacao!=null && !(nomeClassificacao.isEmpty())){
            List<Produto> p = repository.findByClassificacao(nomeClassificacao);
            model.addAttribute("lista", p);
            model.addAttribute("nc", nomeClassificacao);
        }
        else{
            model.addAttribute("lista",repository.findAll());
        }

        return "/produto/list";
    }
    @PostMapping("/create")
    public String cadastraProduto(DadosCadastraProduto dados)
    {
        Produto g1 = new Produto(dados);
        repository.save(g1);
        return "redirect:/produto/list";
    }

    @DeleteMapping
    @Transactional
    public String removeProduto(long id){
        repository.deleteById(id);
        return "redirect:/produto/list";
    }

    @PutMapping("/create")
    @Transactional
    public String alteraProduto(DadosAlteracaoProduto dados){
        Produto f1 = repository.getReferenceById(dados.id());
        f1.atualizaDados(dados);
        repository.save(f1);
        return "redirect:/produto/list";
    }
}
