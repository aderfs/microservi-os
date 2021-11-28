package br.unisul.aula.mscliente.dto;

public class EnderecoDTO {

  private Long id;
  private Integer cep;
  private String logradouro;
  private String bairro;
  private String cidade;
  private String uf;


  public EnderecoDTO() {
  }


  public EnderecoDTO(Long id, Integer cep, String logradouro, String bairro, String cidade, String uf) {
    this.id = id;
    this.cep = cep;
    this.logradouro = logradouro;
    this.bairro = bairro;
    this.cidade = cidade;
    this.uf = uf;
  }


  public EnderecoDTO(Long id) {
    this.id = id;
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

  public String getUf() {
    return this.uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

}
