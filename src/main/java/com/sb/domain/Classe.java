package com.sb.domain;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table (name="Classe")
public class Classe {
	
	@Id
	@Column(name="CLASS_ID")
	@JsonView(View.Common.class)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JsonView(View.Common.class)
	private String name;
	
	@JsonView(View.Common.class)
	@Column(name="STUDENTS")
	private int size;
	
	@JsonView(View.Common.class)
	@OneToOne 
	private Prof pp;
	
	@JsonIgnore
	@Column(name="CLASSE_CRENOX")
	@OneToMany(mappedBy="classe", fetch=FetchType.EAGER)
	private Set<Creneau> creneauxClasse = new HashSet<Creneau>();

	public Classe(int id, String name, int size, Prof pp, Set<Creneau> creneauxClasse) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.pp = pp;
		this.creneauxClasse = creneauxClasse;
	}

	public Classe(String name, int size, Prof pp, Set<Creneau> creneauxClasse) {
		super();
		this.name = name;
		this.size = size;
		this.pp = pp;
		this.creneauxClasse = creneauxClasse;
	}


	public Classe(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}

	public Classe() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public Prof getPp() {
		return pp;
	}

	public Set<Creneau> getCreneauxClasse() {
		return creneauxClasse;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setPp(Prof pp) {
		this.pp = pp;
	}

	public void setCreneauxClasse(Set<Creneau> creneauxClasse) {
		this.creneauxClasse = creneauxClasse;
	}

	@Override
	public String toString() {
		return "Classe [id=" + id + ", name=" + name + ", size=" + size + ", pp=" + pp + ", creneauxClasse="
				+ creneauxClasse + "]";
	}

}
