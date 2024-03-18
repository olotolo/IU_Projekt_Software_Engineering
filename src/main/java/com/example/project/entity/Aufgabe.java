package com.example.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aufgaben")
public class Aufgabe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @ManyToOne
	@JoinColumn(name="projektid")
    private Projekt projektid;

    @Column(name="titel")
    private String titel;

    @Column(name="beschreibung")
    private String beschreibung;

    @Column(name="status")
    private String status;

    @Column(name="deadline")
    private String deadline;

    @Column(name="mitarbeiter")
    private String mitarbeiter;

    @Column(name="projektleiter")
    private String projektleiter;
    
    @Column(name="bericht")
    private String bericht;

    public Aufgabe() {
    }

    public Aufgabe(int id, String titel, Projekt projektid, 
    			   String beschreibung, String status, String deadline, 
    			   String mitarbeiter, String projektleiter, String bericht) {
        this.id = id;
        this.projektid = projektid;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.status = status;
        this.deadline = deadline;
        this.mitarbeiter = mitarbeiter;
        this.projektleiter = projektleiter;
        this.bericht = bericht;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public Projekt getProjektid() {
		return projektid;
	}

	public void setProjektid(Projekt projektid) {
		this.projektid = projektid;
	}

	public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(String mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public String getProjektleiter() {
        return projektleiter;
    }

    public void setProjektleiter(String projektleiter) {
        this.projektleiter = projektleiter;
    }

	public String getBericht() {
		return bericht;
	}

	public void setBericht(String bericht) {
		this.bericht = bericht;
	}	
    
}
