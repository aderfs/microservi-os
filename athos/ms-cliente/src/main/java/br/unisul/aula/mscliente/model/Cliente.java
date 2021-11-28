package br.unisul.aula.mscliente.model;

import javax.persistence.*;

@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private Integer numero;
    private String complemento;
    private Long endereco_id;


    public Cliente() {
    }


    public Cliente(Long id, String nome, Integer numero, String complemento, Long endereco_id) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.complemento = complemento;
        this.endereco_id = endereco_id;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Long getEndereco_id() {
        return this.endereco_id;
    }

    public void setEndereco_id(Long endereco_id) {
        this.endereco_id = endereco_id;
    }
    
}
