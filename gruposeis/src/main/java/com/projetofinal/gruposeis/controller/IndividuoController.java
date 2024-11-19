package com.projetofinal.gruposeis.controller;

import com.projetofinal.gruposeis.ValidatorCpf;
import com.projetofinal.gruposeis.model.individuo.DadosAlteracaoIndividuo;
import com.projetofinal.gruposeis.model.individuo.DadosCadastroIndividuo;
import com.projetofinal.gruposeis.model.individuo.Individuo;
import com.projetofinal.gruposeis.model.individuo.IndividuoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/individuo")
public class IndividuoController {
    @Autowired
    private IndividuoRepository repository;


    @GetMapping("/create")
    public String carregaFormulario(Long id, Model model)
    {
        if(id!=null){
            Individuo p1 = repository.getReferenceById(id);
            model.addAttribute("individuo",p1);
        }
        return "/individuo/create";
    }

    @GetMapping("/list")
    public String carregaListagem(Model model, String CPF)
    {
        if(CPF!=null && !(CPF.isEmpty())){
            List<Individuo> i = repository.findByCPF(CPF);
            model.addAttribute("lista", i);
            model.addAttribute("cpf", CPF);
        }
        else{
            model.addAttribute("lista",repository.findAll());
        }

        return "/individuo/list";
    }
    @PostMapping("/create")
    public String cadastraIndividuo(DadosCadastroIndividuo dados, Model model)
    {
        Individuo g1 = new Individuo(dados);
        repository.save(g1);
        return "redirect:/individuo/list";

    }

    @DeleteMapping
    @Transactional
    public String removeIndividuo(long id){
        repository.deleteById(id);
        return "redirect:/individuo/list";
    }

    @PutMapping("/create")
    @Transactional
    public String alteraIndividuo(DadosAlteracaoIndividuo dados){
        Individuo f1 = repository.getReferenceById(dados.id());
        f1.atualizaDados(dados);
        repository.save(f1);
        return "redirect:/individuo/list";
    }
}
