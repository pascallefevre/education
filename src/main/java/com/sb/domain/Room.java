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

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="Room")
public class Room {
	
	@Id
	@Column(name="ROOM_ID")
	@JsonView(View.Common.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonView(View.Common.class)
	private String name;
	
	@JsonView(View.Common.class)
	private int capacity;
	
	@JsonView(View.Common.class)
	@Column(name="ROOM_CRENOX")
	@OneToMany(mappedBy="room", fetch=FetchType.EAGER)
	private Set<Creneau> creneauxMatiere = new HashSet<Creneau>();

	public Room(int id, String name, int capacity, Set<Creneau> creneauxMatiere) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.creneauxMatiere = creneauxMatiere;
	}

	public Room(String name, int capacity, Set<Creneau> creneauxMatiere) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.creneauxMatiere = creneauxMatiere;
	}

	public Room(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}

	public Room() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
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

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setCreneauxMatiere(Set<Creneau> creneauxMatiere) {
		this.creneauxMatiere = creneauxMatiere;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", capacity=" + capacity + ", creneauxMatiere=" + creneauxMatiere
				+ "]";
	}

	

}
