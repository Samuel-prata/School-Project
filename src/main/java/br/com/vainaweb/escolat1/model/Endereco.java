package br.com.vainaweb.escolat1.model;

import br.com.vainaweb.escolat1.dto.EnderecoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
public class Endereco {

	
	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String complemento;
	private Integer numero;
	
	
	//-------------------------CONSTRUTORES------------------------
	 public Endereco() {
		 
	 }
	 
	 public Endereco(EnderecoDTO dadosEndereco) {
		 this.cep = dadosEndereco.cep();
		 this.logradouro = dadosEndereco.logradouro();
		 this.bairro = dadosEndereco.bairro();
		 this.cidade = dadosEndereco.cidade();
		 this.complemento = dadosEndereco.complemento();
		 this.numero = dadosEndereco.numero();
	 }

	// --------------------GETTERS E SETTERS--------------------------
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	
}
