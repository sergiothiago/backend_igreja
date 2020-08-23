package br.com.igreja.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.igreja.api.enums.StatusPresencaEnum;

@Entity
@Table(name="ALUNO_PRESENCA")
public class AlunoPresenca implements Serializable{
	
	private static final long serialVersionUID = -5678011207015312512L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO_ALUNO_PRESENCA")
	private Long codigo;
	
	@Column(name = "PRESENCA_ALUNO_PRESENCA", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private StatusPresencaEnum statusPresenca;
	
	@ManyToOne
	@JoinColumn(name="CODIGO_ALUNO_ALUNO_PRESENCA")
	private Aluno aluno;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ALUNO_PRESENCA", nullable = false)
	private Date dataAlunoPresenca;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public StatusPresencaEnum getStatusPresenca() {
		return statusPresenca;
	}

	public void setStatusPresenca(StatusPresencaEnum statusPresenca) {
		this.statusPresenca = statusPresenca;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Date getDataAlunoPresenca() {
		return dataAlunoPresenca;
	}

	public void setDataAlunoPresenca(Date dataAlunoPresenca) {
		this.dataAlunoPresenca = dataAlunoPresenca;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
