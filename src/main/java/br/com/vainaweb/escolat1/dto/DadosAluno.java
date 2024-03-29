package br.com.vainaweb.escolat1.dto;

import br.com.vainaweb.escolat1.enums.Curso;
import jakarta.validation.Valid;

public record DadosAluno(String foto, String nome, String email, String cpf, Curso curso, @Valid EnderecoDTO endereco) {

}
