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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table (name = "MATIERE")
public class Matiere {
	
	@Id
	@Column(name="MATIERE_ID")
	@JsonView(View.Common.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonView(View.Common.class)
	private String name;
	
	@JsonView(View.Common.class)
	private String color;
	
	@JsonIgnore
	@Column(name="MATIERE_CRENOX")
	@OneToMany(mappedBy="matiere", fetch=FetchType.EAGER)
	private Set<Creneau> creneauxMatiere = new HashSet<Creneau>();

	public Matiere(int id, String name, String color, Set<Creneau> creneauxMatiere) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.creneauxMatiere = creneauxMatiere;
	}

	public Matiere(String name, String color, Set<Creneau> creneauxMatiere) {
		super();
		this.name = name;
		this.color = color;
		this.creneauxMatiere = creneauxMatiere;
	}

	public Matiere(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	public Matiere() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public Set<Creneau> getCreneauxMatiere() {
		return creneauxMatiere;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setCreneauxMatiere(Set<Creneau> creneauxMatiere) {
		this.creneauxMatiere = creneauxMatiere;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", name=" + name + ", color=" + color + ", creneauxMatiere=" + creneauxMatiere
				+ "]";
	}

	
	

}
