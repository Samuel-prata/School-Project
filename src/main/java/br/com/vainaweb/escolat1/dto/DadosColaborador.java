package br.com.vainaweb.escolat1.dto;

import br.com.vainaweb.escolat1.enums.Cargo;
import jakarta.validation.Valid;

public record DadosColaborador(String foto, String nome, String cpf, String email, Cargo cargo, @Valid EnderecoDTO endereco) {

}
