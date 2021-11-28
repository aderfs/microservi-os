package br.unisul.aula.mscliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.unisul.aula.mscliente.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
  @Query("SELECT e FROM Cliente e WHERE e.endereco_id = :enderecoId")
  List<Cliente> findByEndereco(Long enderecoId);
}
