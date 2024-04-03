package br.com.vainaweb.escolat1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat1.dto.DadosAtualizados;
import br.com.vainaweb.escolat1.dto.DadosColaborador;
import br.com.vainaweb.escolat1.model.ColaboradorModel;
import br.com.vainaweb.escolat1.repository.ColaboradorRepository;
import br.com.vainaweb.escolat1.service.ColaboradorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaboradores")

// Classe responsavel por receber requisições e retornar respostas
public class ColaboradorController {

	@Autowired
	private ColaboradorService service;
	@Autowired
	private ColaboradorRepository repository;

	@GetMapping
	public List<ColaboradorModel> listarTodosColaboradores() {

		return service.encontrarTodos();
	}
	
	@GetMapping("/{id}")
	public Optional<ColaboradorModel> listarPorId(@PathVariable Long id) {
		return repository.findById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/cadastrar")
	public ResponseEntity<String> cadastrar(@RequestBody DadosColaborador dados) {
		return service.cadastrar(dados).map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body("Cadastro feito com sucesso!"))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro no Cadastro"));

	}


	@Transactional
	@PutMapping("/{id}")
	public String atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizados dados) {
		var colaborador = repository.getReferenceById(id);
		colaborador.atualizar(dados);
		repository.save(colaborador);
		return "ok";
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletar(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
	}
}
