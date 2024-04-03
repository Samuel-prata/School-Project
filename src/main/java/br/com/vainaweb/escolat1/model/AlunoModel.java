package br.com.vainaweb.escolat1.model;

import java.util.Objects;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat1.dto.DadosAtualizados;
import br.com.vainaweb.escolat1.dto.EnderecoDTO;
import br.com.vainaweb.escolat1.enums.Curso;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

//Anotação que diz que essa classe é uma entidade
@Entity
@Table(name = "tb_alunos")
// será a classe responsavel pela entidade
public class AlunoModel {

	@Id // Chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String foto;
	private String nome;

	@Column(unique = true) // Formata as colunas
	@Email(message = "Precisa ter o formato email") // Valida isso como um email
	private String email;

	@Column(unique = true)
	@CPF(message = "precisa ser um cpf válido") // Valida como um CPF
	private String cpf;
	
	private Curso curso;

	@Embedded // Incorpora a classe na entidade (OS ATRIBUTOS DESSA CLASSA SERÃO PARTE DA Minha tabela)
	private Endereco endereco;

	// |------------------------------------------CONSTRUTORES--------------------------------------|
	
	public AlunoModel() {
		
	}
	
	public AlunoModel(String foto, String nome, String email, String cpf, Curso curso, EnderecoDTO endereco) {
		this.foto = foto;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.curso = curso;
		this.endereco = new Endereco(endereco);
	}

	// |-----------------------------GETTER E
	// SETTER--------------------------------------|
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoModel other = (AlunoModel) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id);
	}

	public void atualizarInfo(@Valid DadosAtualizados dados) {
		this.foto = dados.foto() != null ? dados.foto(): this.foto;
		this.nome = dados.nome() != null ? dados.nome(): this.nome;
		this.email = dados.email() != null ? dados.email(): this.email;
		
	}
	
	
	
}
