package com.sb.domain;







import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table (name= "CRENEAU")
public class Creneau {
	
	@Id
	@Column(name="CRENEAU_ID")
	@JsonView(View.Common.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonView(View.Common.class)
	private String startdate;
	
	@JsonView(View.Common.class)
	private String enddate;
	
	//Chaque créneau pocède:
	@JsonView(View.Common.class)
	@ManyToOne(fetch=FetchType.EAGER)
	private Classe classe;
	
	@JsonView(View.Common.class)
	@ManyToOne(fetch=FetchType.EAGER)
	private Prof prof;
	
	@JsonView(View.Common.class)
	@ManyToOne(fetch=FetchType.EAGER)
	private Matiere matiere;
	
	@JsonView(View.Common.class)
	@ManyToOne(fetch=FetchType.EAGER)
	private Room room;

	public Creneau(int id, String startdate, String enddate, Classe classe, Prof prof, Matiere matiere, Room room) {
		super();
		this.id = id;
		this.startdate = startdate;
		this.enddate = enddate;
		this.classe = classe;
		this.prof = prof;
		this.matiere = matiere;
		this.room = room;
	}

	public Creneau(String startdate, String enddate, Classe classe, Prof prof, Matiere matiere, Room room) {
		super();
		this.startdate = startdate;
		this.enddate = enddate;
		this.classe = classe;
		this.prof = prof;
		this.matiere = matiere;
		this.room = room;
	}

	public Creneau(String startdate, String enddate) {
		super();
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public Creneau() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getStartdate() {
		return startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public Classe getClasse() {
		return classe;
	}

	public Prof getProf() {
		return prof;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public Room getRoom() {
		return room;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public void setProf(Prof prof) {
		this.prof = prof;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Creneau [id=" + id + ", startdate=" + startdate + ", enddate=" + enddate + ", classe=" + classe
				+ ", prof=" + prof + ", matiere=" + matiere + ", room=" + room + "]";
	}
	
	
}
