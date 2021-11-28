package br.unisul.aula.mscliente.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unisul.aula.mscliente.dto.EnderecoDTO;

@FeignClient("endereco")
@RequestMapping("end")
public interface EnderecoClient {

  @RequestMapping(method = RequestMethod.POST)
  EnderecoDTO addEndereco(@RequestBody EnderecoDTO enderecoDTO);

  @RequestMapping("/{enderecoId}")
  EnderecoDTO buscar(@PathVariable Long enderecoId);

  @RequestMapping("/cidade/{cidade}")
  List<EnderecoDTO> getByCidade(@PathVariable String cidade);

}
