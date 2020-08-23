package br.com.igreja.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="PAROQUIA")
public class Paroquia implements Serializable{
	
	private static final long serialVersionUID = -3242341207055512512L;;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO_PAROQUIA")
	private Long codigo;
	
	@NotEmpty(message = "Descricao da paroquia não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Descricao da paroquia deve conter entre 3 e 200 caracteres.")
	@Column(name = "DESRICAO_PAROQUIA", nullable = false)
	private String descricao;
	
	@JsonManagedReference
	@OneToMany(mappedBy="paroquia", cascade = CascadeType.ALL)
	private List<ParoquiaTelefone> telefones;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ParoquiaTelefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<ParoquiaTelefone> telefones) {
		this.telefones = telefones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
