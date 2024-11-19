package com.projetofinal.gruposeis.model.produto;

import com.projetofinal.gruposeis.model.ficha.Ficha;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String classificacao;

    @OneToMany(mappedBy = "produto")
    private List<Ficha> fichaList = new ArrayList<Ficha>();


    public String getNome() {
        return nome;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Produto(){}

    public Produto(DadosCadastraProduto dados){
        this.nome = dados.nome();
        this.classificacao = dados.classificacao();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                "classificação='" + classificacao + '\'' +
                '}';
    }

    public void atualizaDados(DadosAlteracaoProduto dados){
        this.nome = dados.nome();
        this.classificacao = dados.classificacao();
    }
}

