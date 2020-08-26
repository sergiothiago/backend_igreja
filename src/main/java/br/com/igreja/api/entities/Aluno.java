package br.com.igreja.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.igreja.api.enums.StatusEnum;

@Entity
@Table(name="ALUNO")
public class Aluno implements Serializable{

	private static final long serialVersionUID = -4342341207055512512L;;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO_ALUNO")
	private Long codigo;
	
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	@Column(name = "NOME_ALUNO", nullable = false)
	private String nome;
	
	@Column(name = "STATUS_ALUNO", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	@JsonManagedReference
	@OneToMany(mappedBy="aluno", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AlunoTelefone> telefones;
	
	@JsonManagedReference
	@OneToMany(mappedBy="aluno", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AlunoEndereco> enderecos;
	
	@PrePersist
    public void prePersist() {
		status = StatusEnum.CURSANDO;
    }
	
	public List<AlunoTelefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<AlunoTelefone> telefones) {
		this.telefones = telefones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
}
