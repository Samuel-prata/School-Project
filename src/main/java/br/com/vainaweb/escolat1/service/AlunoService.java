package br.com.vainaweb.escolat1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat1.dto.DadosAluno;
import br.com.vainaweb.escolat1.model.AlunoModel;
import br.com.vainaweb.escolat1.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository repository;

	public ResponseEntity<String> cadastrar(DadosAluno dados) {
		Optional<AlunoModel> cpfExistente = repository.findByCpf(dados.cpf());
		Optional<AlunoModel> emailExistente = repository.findByEmail(dados.email());
		
		if (cpfExistente.isPresent() || emailExistente.isPresent() ) {
			return ResponseEntity.badRequest().body("Colaborador Ja existente");
		} else {
			AlunoModel colaborador = new AlunoModel(dados.nome(), dados.email(), dados.cpf(), dados.curso());
			repository.save(colaborador);
			return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro feito com sucesso");
		}
	}
}
