package com.e_voting_system.e_voting_management.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Election {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String electionName;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    private Candidate candidate;
    private String results;
    private boolean isDone;

    public Election(){

    }
    

    
    public Election(String electionName, Date startDate, Date endDate, Candidate candidate, String results, boolean isDone) {
        this.electionName = electionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.candidate = candidate;
        this.results = results;
        this.isDone = isDone;
    }


    public long getId() {
        return id;
    }


    public String getElectionName() {
        return electionName;
    }


    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }


    public Date getStartDate() {
        return startDate;
    }


    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getEndDate() {
        return endDate;
    }


    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    public Candidate getCandidate() {
        return candidate;
    }


    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }


    public String getResults() {
        return results;
    }


    public void setResults(String results) {
        this.results = results;
    }


    public boolean isDone() {
        return isDone;
    }


    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }  

    
}
