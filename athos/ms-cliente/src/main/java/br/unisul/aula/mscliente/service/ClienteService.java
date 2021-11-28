package br.unisul.aula.mscliente.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.aula.mscliente.client.EnderecoClient;
import br.unisul.aula.mscliente.dto.ClienteDTO;
import br.unisul.aula.mscliente.dto.ClientesEnderecoDTO;
import br.unisul.aula.mscliente.dto.EnderecoDTO;
import br.unisul.aula.mscliente.model.Cliente;
import br.unisul.aula.mscliente.repository.ClienteRepository;

@Service
public class ClienteService {

  @Autowired
  ClienteRepository clienteRepository;
  @Autowired
  EnderecoClient enderecoClient;

  public List<ClienteDTO> listClientes() {
    List<ClienteDTO> clientesDTO = new ArrayList<>();
    Iterable<Cliente> clientes = clienteRepository.findAll();

    for (Cliente cliente : clientes) {
      EnderecoDTO enderecoDTO = enderecoClient.buscar(cliente.getEndereco_id());

      ClienteDTO clienteDTO = new ClienteDTO(cliente.getId(), cliente.getNome(), enderecoDTO, cliente.getComplemento(),
          cliente.getNumero());

      clientesDTO.add(clienteDTO);
    }

    return clientesDTO;
  }

  public ClientesEnderecoDTO getClientesByCidade(String cidade) {
    List<EnderecoDTO> enderecos = enderecoClient.getByCidade(cidade);
    List<Cliente> clientes = new ArrayList<>();

    for (EnderecoDTO endereco : enderecos) {
      clientes.addAll(0, clienteRepository.findByEndereco(endereco.getId()));
    }

    if (enderecos.isEmpty()) {
      return null;
    }

    EnderecoDTO endereco = enderecos.get(0);

    List<ClienteDTO> clientesDTO = new ArrayList<>();

    for (Cliente cliente : clientes) {
      clientesDTO.add(new ClienteDTO(cliente.getId(), cliente.getNome()));
    }

    return new ClientesEnderecoDTO(endereco.getCidade(), endereco.getUf(), clientesDTO);
  }

  public ClienteDTO createCliente(ClienteDTO clienteDTO) {
    EnderecoDTO endereco = enderecoClient.addEndereco(clienteDTO.getEndereco());

    Cliente cliente = new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getNumero(),
        clienteDTO.getComplemento(),
        clienteDTO.getEndereco().getId());
    cliente.setEndereco_id(endereco.getId());

    Cliente newCliente = clienteRepository.save(cliente);

    return new ClienteDTO(newCliente.getId(), newCliente.getNome(), endereco, newCliente.getComplemento(),
        newCliente.getNumero());

  }
}
