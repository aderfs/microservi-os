package br.unisul.aula.msendereco.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unisul.aula.msendereco.dto.EnderecoDTO;
import br.unisul.aula.msendereco.service.EnderecoService;

@RestController
@RequestMapping("/end")
public class EnderecoController {

  @Autowired
  EnderecoService enderecoService;

  @GetMapping
  @RequestMapping()
  public ResponseEntity<List<EnderecoDTO>> getEnderecos(@RequestParam(required = false) Integer cep) {
    List<EnderecoDTO> enderecosDTO = enderecoService.listEnderecos(cep);
    return ResponseEntity.status(HttpStatus.OK).body(enderecosDTO);
  }

  @GetMapping
  @RequestMapping("/{enderecoId}")
  public ResponseEntity<EnderecoDTO> getEnderecoById(@PathVariable Long enderecoId) {
    EnderecoDTO enderecoDTO = enderecoService.getEnderecoById(enderecoId);
    return ResponseEntity.status(HttpStatus.OK).body(enderecoDTO);
  }

  @GetMapping
  @RequestMapping("/cidade/{cidade}")
  public ResponseEntity<List<EnderecoDTO>> getEnderecoByCidade(@PathVariable String cidade) {
    List<EnderecoDTO> enderecoDTO = enderecoService.getEnderecoByCidade(cidade);
    return ResponseEntity.status(HttpStatus.OK).body(enderecoDTO);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<EnderecoDTO> createEndereco(@RequestBody EnderecoDTO enderecoDTO) {
    EnderecoDTO newEnderecoDTO = enderecoService.createEndereco(enderecoDTO);
    return ResponseEntity.status(HttpStatus.OK).body(newEnderecoDTO);
  }

}
