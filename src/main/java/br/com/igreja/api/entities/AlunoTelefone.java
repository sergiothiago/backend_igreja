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
@Table(name="ALUNO_TELEFONE")
public class AlunoTelefone implements Serializable {
	
	private static final long serialVersionUID = -5752341207055512512L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO_ALUNO_TELEFONE")
	private Long codigo;
	
	
	@NotEmpty(message = "ddd do telefone não pode ser vazio.")
	@Length(min = 2, max = 3, message = "ddd do telefone deve conter entre 2 e 3 caracteres.")
	@Column(name = "DDD_ALUNO_TELEFONE", nullable = false)
	private String ddd;
	
	@NotEmpty(message = "numero do telefone não pode ser vazio.")
	@Length(min = 8, max = 9, message = "numero do telefone deve conter entre 8 e 9 caracteres.")
	@Column(name = "NUMERO_ALUNO_TELEFONE", nullable = false)
	private String numero;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="CODIGO_ALUNO_ALUNO_TELEFONE")
	private Aluno aluno;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
}
