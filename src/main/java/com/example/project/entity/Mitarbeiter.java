package com.example.project.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mitarbeiter")
public class Mitarbeiter {


    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mitarbeiterid")
    private long id;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="geburtstag")
    @Temporal(TemporalType.DATE)
    private Date geburtstag;

    @Column(name="rolle")
    private String rolle;

    @Column(name="faehigkeiten")
    private String faehigkeiten;

    @Column(name="user")
    private String user;
    
    @ManyToMany(mappedBy = "mitarbeiter")
    private List<Projekt> projekt;

    public Mitarbeiter (){

    }

    public Mitarbeiter(long id, String firstName, String lastName, Date geburtstag, String rolle, String faehigkeiten, String user, List<Projekt> projekt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.geburtstag = geburtstag;
        this.rolle = rolle;
        this.faehigkeiten = faehigkeiten;
        this.user = user;
        this.projekt = projekt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(Date geburtstag) {
        this.geburtstag = geburtstag;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public String getFaehigkeiten() {
        return faehigkeiten;
    }

    public void setFaeigkeiten(String faehigkeiten) {
        this.faehigkeiten = faehigkeiten;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public List<Projekt> getProjekt() {
		return projekt;
	}

	public void setProjekt(List<Projekt> projekt) {
		this.projekt = projekt;
	}
}
