package br.com.igreja.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="PAROQUIA_ENDERECO")
public class ParoquiaEndereco implements Serializable{

	private static final long serialVersionUID = -8538061758946866099L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO_PAROQUIA_ENDERECO")
	private Long codigo;
	
	@NotEmpty(message = "campo rua não pode ser vazio.")
	@Length(min = 2, max = 200, message = "campo rua deve conter entre 2 e 200 caracteres.")
	@Column(name = "RUA_PAROQUIA_ENDERECO", nullable = false)
	private String rua;
	
	@NotEmpty(message = "campo bairro não pode ser vazio.")
	@Length(min = 2, max = 200, message = "campo bairro deve conter entre 2 e 200 caracteres.")
	@Column(name = "BAIRRO_PAROQUIA_ENDERECO", nullable = false)
	private String bairro;
	
	@NotEmpty(message = "campo numero não pode ser vazio.")
	@Length(min = 2, max = 30, message = "campo numero deve conter entre 2 e 30 caracteres.")
	@Column(name = "NUMERO_PAROQUIA_ENDERECO", nullable = false)
	private String numero;

	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name="CODIGO_PAROQUIA_PAROQUIA_ENDERECO")
	private Paroquia paroquia;

	@ManyToOne
	@JoinColumn(name="CODIGO_CIDADE_PAROQUIA_ENDERECO")
	private Cidade cidade;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Paroquia getParoquia() {
		return paroquia;
	}

	public void setParoquia(Paroquia paroquia) {
		this.paroquia = paroquia;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
