package br.com.vainaweb.escolat1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import br.com.vainaweb.escolat1.dto.DadosAluno;
import br.com.vainaweb.escolat1.dto.DadosColaborador;
import br.com.vainaweb.escolat1.model.AlunoModel;
import br.com.vainaweb.escolat1.model.ColaboradorModel;
import br.com.vainaweb.escolat1.repository.AlunoRepository;
import br.com.vainaweb.escolat1.service.AlunoService;
import br.com.vainaweb.escolat1.service.ColaboradorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")

// Classe responsavel por receber requisições e retornar respostas
public class AlunoController {

	@Autowired
	private AlunoService service;
	
	@Autowired
	private AlunoRepository repository;

	@GetMapping
	public List<AlunoModel> listarTodosColaboradores() {
		return service.encontrarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoModel> listarPorId(@PathVariable Long id) {
		return repository.findById(id).
				map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<String> cadastrar(@RequestBody  @Valid DadosAluno dados) {
		return service.cadastrar(dados);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable @Valid Long id) {
		repository.deleteById(id);
	}
	


}
