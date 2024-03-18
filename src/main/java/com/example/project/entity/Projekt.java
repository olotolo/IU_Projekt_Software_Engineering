package com.example.project.entity;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "projekte")
public class Projekt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="projektid")
    private int projektid;

    @Column(name="projektname")
    private String projektname;

    @Column(name="erstelldatum")
    private String erstellDatum;

    @Column(name="status")
    private String status;

    @Column(name="beschreibung")
    private String beschreibung;

    @Column(name="deadline")
    //@Temporal(TemporalType.DATE)
    private String deadline;

    @Column(name="ersteller")
    private String ersteller;

    @Column(name="projektleiter")
    private String projektleiter;
    
    @ManyToMany
    @JoinTable(
	  name = "projekt_mitarbeiter", 
	  joinColumns = @JoinColumn(name = "projektid"), 
	  inverseJoinColumns = @JoinColumn(name = "mitarbeiterid"))
    private List<Mitarbeiter> mitarbeiter;

    public Projekt() {
    }

    public Projekt(int id, String projektName, String erstellDatum, String status, String beschreibung, String deadline, String ersteller, String projektleiter, List<Mitarbeiter> mitarbeiter) {
        this.projektid = id;
        this.projektname = projektName;
        this.erstellDatum = erstellDatum;
        this.status = status;
        this.beschreibung = beschreibung;
        this.deadline = deadline;
        this.ersteller = ersteller;
        this.projektleiter = projektleiter;
        this.mitarbeiter = mitarbeiter;
    }

    public int getProjektid() {
        return projektid;
    }

    public void setProjektid(int projektid) {
        this.projektid = projektid;
    }

    public String getProjektname() {
        return projektname;
    }

    public void setProjektname(String projektname) {
        this.projektname = projektname;
    }

    public String getErstellDatum() {
        return erstellDatum;
    }

    public void setErstellDatum(String erstellDatum) {
        this.erstellDatum = erstellDatum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String   deadline) {
        this.deadline = deadline;
    }

    public String getErsteller() {
        return ersteller;
    }

    public void setErsteller(String ersteller) {
        this.ersteller = ersteller;
    }

    public String getProjektleiter() {
        return projektleiter;
    }

    public void setProjektleiter(String projektleiter) {
        this.projektleiter = projektleiter;
    }
    
    public List<Mitarbeiter> getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(List<Mitarbeiter> mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}
}
