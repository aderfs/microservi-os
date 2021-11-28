package br.unisul.aula.mscliente.dto;

import java.util.List;

public class ClientesEnderecoDTO {

  private String cidade;
  private String uf;
  private List<ClienteDTO> clientes;


  public ClientesEnderecoDTO() {
  }


  public ClientesEnderecoDTO(String cidade, String uf, List<ClienteDTO> clientes) {
    this.cidade = cidade;
    this.uf = uf;
    this.clientes = clientes;
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

  public List<ClienteDTO> getClientes() {
    return this.clientes;
  }

  public void setClientes(List<ClienteDTO> clientes) {
    this.clientes = clientes;
  }

}
