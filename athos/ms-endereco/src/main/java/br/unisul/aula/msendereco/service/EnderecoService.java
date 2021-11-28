package br.unisul.aula.msendereco.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.aula.msendereco.dto.EnderecoDTO;
import br.unisul.aula.msendereco.model.Endereco;
import br.unisul.aula.msendereco.repository.EnderecoRepository;

@Service
public class EnderecoService {

  @Autowired
  EnderecoRepository enderecoRepository;

  public List<EnderecoDTO> listEnderecos(Integer cep) {

    List<Endereco> enderecos = cep != null ? enderecoRepository.findByCep(cep)
        : (List<Endereco>) enderecoRepository.findAll();

    List<EnderecoDTO> enderecosDTO = new ArrayList<>();
    enderecos.forEach(endereco -> enderecosDTO
        .add(new EnderecoDTO(endereco.getId(), endereco.getCep(), endereco.getLogradouro(), endereco.getBairro(),
            endereco.getCidade(), endereco.getUf())));

    return enderecosDTO;
  }

  public EnderecoDTO getEnderecoById(Long id) {
    Optional<Endereco> endereco = enderecoRepository.findById(id);
    if (endereco.isEmpty()) {
      return null;
    }

    Endereco end = endereco.get();

    return new EnderecoDTO(end.getId(), end.getCep(), end.getLogradouro(), end.getBairro(),
        end.getCidade(), end.getUf());

  }

  public List<EnderecoDTO> getEnderecoByCidade(String cidade) {
    List<Endereco> enderecos = enderecoRepository.findByCidade(cidade);

    List<EnderecoDTO> enderecosDTO = new ArrayList<>();
    enderecos.forEach(endereco -> enderecosDTO
        .add(new EnderecoDTO(endereco.getId(), endereco.getCep(), endereco.getLogradouro(), endereco.getBairro(),
            endereco.getCidade(), endereco.getUf())));

    return enderecosDTO;
  }

  public EnderecoDTO createEndereco(EnderecoDTO enderecoDTO) {
    Endereco endereco = new Endereco(enderecoDTO.getId(), enderecoDTO.getCep(), enderecoDTO.getLogradouro(),
        enderecoDTO.getBairro(),
        enderecoDTO.getCidade(), enderecoDTO.getUf());

    Endereco end = enderecoRepository.save(endereco);

    return new EnderecoDTO(end.getId(), end.getCep(), end.getLogradouro(), end.getBairro(),
        end.getCidade(), end.getUf());

  }

  public List<EnderecoDTO> deleteEndereco(Long id) {
    List<Endereco> enderecos = (List<Endereco>) enderecoRepository.findAll();

    List<EnderecoDTO> enderecosDTO = new ArrayList<>();
    enderecos.forEach(endereco -> enderecosDTO
        .add(new EnderecoDTO(endereco.getId(), endereco.getCep(), endereco.getLogradouro(), endereco.getBairro(),
            endereco.getCidade(), endereco.getUf())));

    return enderecosDTO;
  }

}
