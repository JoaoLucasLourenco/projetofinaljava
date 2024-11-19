package com.projetofinal.gruposeis.model.individuo;

import com.projetofinal.gruposeis.model.ficha.Ficha;
import com.projetofinal.gruposeis.model.produto.DadosAlteracaoProduto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="individuo")
public class Individuo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String CPF;
    private char sexo;

    @OneToMany(mappedBy = "individuo")
    private List<Ficha> fichaList = new ArrayList<Ficha>();

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public char getSexo() {
        return sexo;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Individuo(){};

    public Individuo(DadosCadastroIndividuo dados){
        this.CPF = dados.CPF();
        this.nome = dados.nome();
        this.sexo = dados.sexo();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                "CPF='" + CPF + '\'' +
                "Sexo='" + sexo + '\'' +
                '}';
    }

    public void atualizaDados(DadosAlteracaoIndividuo dados){
        this.nome = dados.nome();
        this.CPF = dados.CPF();
        this.sexo = dados.sexo();
    }


}
