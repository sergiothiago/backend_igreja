package br.com.igreja.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.igreja.api.enums.PerfilEnum;

@Entity
@Table(name = "ADMINISTRADOR")
public class Administrador implements Serializable  {

	private static final long serialVersionUID = -5752341207015312512L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO_ADMINISTRADOR")
	private Long codigo;
	
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	@Column(name = "NOME_ADMINISTRADOR", nullable = false)
	private String nome;

	@NotEmpty(message = "email não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	@Email(message="Digite um formato de email")
	@Column(name = "EMAIL_ADMINISTRADOR", nullable = false)
	private String email;
	
	@NotEmpty(message = "senha não pode ser vazia.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	@Column(name = "SENHA_ADMINISTRADOR", nullable = false)
	private String senha;
	
	@Column(name = "PERFIL_ADMINISTRADOR", nullable = false)
	@Enumerated(EnumType.STRING)
	private PerfilEnum perfil;

	@PrePersist
    public void prePersist() {
        perfil = PerfilEnum.ROLE_ADMIN;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public PerfilEnum getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
