package com.sb.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table (name = "PROF")
public class Prof {
	
	@Id
	@Column(name="PROF_ID")
	@JsonView(View.Common.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonView(View.Common.class)
	private String firstname;
	
	@JsonView(View.Common.class)
	private String lastname;
	
	@JsonView(View.Common.class)
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@JsonIgnore
	@OneToOne(mappedBy= "pp",  fetch = FetchType.LAZY)
	private Classe refclasse;
	
	
	@JsonIgnore
	@Column(name="PROF_CRENOX")
	@OneToMany(mappedBy="prof", fetch=FetchType.EAGER)
	private Set<Creneau> creneauxProf = new HashSet<Creneau>();


	public Prof(int id, String firstname, String lastname, Date birthdate, Classe refclasse, Set<Creneau> creneauxProf) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.refclasse = refclasse;
		this.creneauxProf = creneauxProf;
	}


	public Prof(String firstname, String lastname, Date birthdate, Classe refclasse, Set<Creneau> creneauxProf) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.refclasse = refclasse;
		this.creneauxProf = creneauxProf;
	}


	public Prof(String firstname, String lastname, Date birthdate) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
	}


	public Prof() {
		super();
	}


	public int getId() {
		return id;
	}


	public String getFirstname() {
		return firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public Classe getRefclasse() {
		return refclasse;
	}


	public Set<Creneau> getCreneauxProf() {
		return creneauxProf;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public void setRefclasse(Classe refclasse) {
		this.refclasse = refclasse;
	}


	public void setCreneauxProf(Set<Creneau> creneauxProf) {
		this.creneauxProf = creneauxProf;
	}


	@Override
	public String toString() {
		return "Prof [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate
				+ ", refclasse=" + refclasse + ", creneauxProf=" + creneauxProf + "]";
	}
	

}
