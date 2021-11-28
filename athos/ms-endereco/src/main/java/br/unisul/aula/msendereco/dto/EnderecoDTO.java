package br.unisul.aula.msendereco.dto;

import br.unisul.aula.msendereco.model.UnidadeFederativa;

public class EnderecoDTO {

  private Long id;
  private Integer cep;
  private String logradouro;
  private String bairro;
  private String cidade;
  private UnidadeFederativa uf;


  public EnderecoDTO() {
  }


  public EnderecoDTO(Long id, Integer cep, String logradouro, String bairro, String cidade, UnidadeFederativa uf) {
    this.id = id;
    this.cep = cep;
    this.logradouro = logradouro;
    this.bairro = bairro;
    this.cidade = cidade;
    this.uf = uf;
  }


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getCep() {
    return this.cep;
  }

  public void setCep(Integer cep) {
    this.cep = cep;
  }

  public String getLogradouro() {
    return this.logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getBairro() {
    return this.bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public UnidadeFederativa getUf() {
    return this.uf;
  }

  public void setUf(UnidadeFederativa uf) {
    this.uf = uf;
  }

}
