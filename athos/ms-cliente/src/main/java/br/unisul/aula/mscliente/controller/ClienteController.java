package br.unisul.aula.mscliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.unisul.aula.mscliente.dto.ClienteDTO;
import br.unisul.aula.mscliente.dto.ClientesEnderecoDTO;
import br.unisul.aula.mscliente.service.ClienteService;

@RestController
@RequestMapping("/cli")
public class ClienteController {

  @Autowired
  ClienteService clienteService;

  @GetMapping
  @RequestMapping()
  public ResponseEntity<List<ClienteDTO>> getClientes() {
    List<ClienteDTO> clientesDTO = clienteService.listClientes();
    return ResponseEntity.status(HttpStatus.OK).body(clientesDTO);
  }

  @GetMapping
  @RequestMapping("/{cidade}")
  public ResponseEntity<ClientesEnderecoDTO> getClientesCidade(@PathVariable String cidade) {
    ClientesEnderecoDTO clientesEnderecoDTO = clienteService.getClientesByCidade(cidade);
    return ResponseEntity.status(HttpStatus.OK).body(clientesEnderecoDTO);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clientesDTO) {
    ClienteDTO newClienteDTO = clienteService.createCliente(clientesDTO);
    return ResponseEntity.status(HttpStatus.OK).body(newClienteDTO);
  }
}
