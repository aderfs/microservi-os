package br.unisul.aula.mscliente.dto;

public class ClienteDTO {
  private Long id;
  private String nome;
  private EnderecoDTO endereco;
  private String complemento;
  private Integer numero;
  

  public ClienteDTO(Long id, String nome, Long endereco_id, String complemento, Integer numero) {
    this.id = id;
    this.nome = nome;
    this.endereco = new EnderecoDTO(endereco_id);
    this.complemento = complemento;
    this.numero = numero;
  }


  public ClienteDTO() {
  }


  public ClienteDTO(Long id, String nome, EnderecoDTO endereco, String complemento, Integer numero) {
    this.id = id;
    this.nome = nome;
    this.endereco = endereco;
    this.complemento = complemento;
    this.numero = numero;
  }


  public ClienteDTO(Long id, String nome) {
    this.id = id;
    this.nome = nome;
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

  public EnderecoDTO getEndereco() {
    return this.endereco;
  }

  public void setEndereco(EnderecoDTO endereco) {
    this.endereco = endereco;
  }

  public String getComplemento() {
    return this.complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public Integer getNumero() {
    return this.numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }


}
