package br.com.vainaweb.escolat1.model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat1.enums.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotação que diz que essa classe é uma entidade
@Entity
@Table(name = "tb_colaboradores")
public class ColaboradorModel {

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
	private Cargo cargo;

	@Embedded // Incorpora a classe na entidade (OS ATRIBUTOS DESSA CLASSA SERÃO PARTE DA
				// MINHA TABELA)
	private Endereco endereco;

	// |------------------------------------------CONSTRUTORES--------------------------------------|
	public ColaboradorModel() {

	}

	public ColaboradorModel(String nome, String email, String cpf, Cargo cargo) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cargo = cargo;
	}

	// |------------------------------------------GETTER E
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
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

}
