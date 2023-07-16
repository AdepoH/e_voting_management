package com.e_voting_system.e_voting_management.models;

import jakarta.persistence.*;

@Entity
public class Candidate {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String firstName;
    private String lastName;
    @OneToOne
    private Party partyName;
    @OneToOne
    private Post post;
    private String gender;
    private String dob;
    private String nin;
    private String userId;
    private boolean hasSubmitted;
    private boolean isVerified;
   

    public Candidate(){

    }


    public Candidate(String firstName, String lastName, Party partyName, Post post, String gender, String dob, String nin, String userId, boolean hasSubmitted, boolean isVerified) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.partyName = partyName;
        this.post = post;
        this.gender = gender;
        this.dob = dob;
        this.nin = nin;
        this.userId = userId;
        this.hasSubmitted = hasSubmitted;
        this.isVerified = isVerified;
     
    }

    
    public long getId() {
        return id;
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


    public Party getPartyName() {
        return partyName;
    }


    public void setPartyName(Party partyName) {
        this.partyName = partyName;
    }

    
    public Post getPost() {
        return post;
    }


    public void setPost(Post post) {
        this.post = post;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getDob() {
        return dob;
    }


    public void setDob(String dob) {
        this.dob = dob;
    }


    public String getNin() {
        return nin;
    }


    public void setNin(String nin) {
        this.nin = nin;
    }

    
    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public boolean isHasSubmitted() {
        return hasSubmitted;
    }


    public void setHasSubmitted(boolean hasSubmitted) {
        this.hasSubmitted = hasSubmitted;
    }


    public boolean isVerified() {
        return isVerified;
    }


    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    
}
