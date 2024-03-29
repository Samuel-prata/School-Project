package br.com.vainaweb.escolat1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat1.dto.DadosColaborador;
import br.com.vainaweb.escolat1.model.ColaboradorModel;
import br.com.vainaweb.escolat1.repository.ColaboradorRepository;

@Service // Classe de serviço gerenciada pelo Spring
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	public List<ColaboradorModel> encontrarTodos() {

		// Método da Repository que faz a query -> SELECT * FROM nome_da_tabela
		return repository.findAll();
	}

	public String cadastrar(DadosColaborador dados) {
		Optional<ColaboradorModel> cpfExistente = repository.findByCpf(dados.cpf());
		Optional<ColaboradorModel>  emailExistente = repository.findByEmail(dados.email());
		
		if (cpfExistente.isPresent() || emailExistente.isPresent() ) {
			return "Colaborador ja existente";
		} else {
			ColaboradorModel colaborador = new ColaboradorModel(dados.nome(), dados.email(), dados.cpf(), dados.cargo());
			repository.save(colaborador);
			return "Cadastro Feito";
		}
	}
}
