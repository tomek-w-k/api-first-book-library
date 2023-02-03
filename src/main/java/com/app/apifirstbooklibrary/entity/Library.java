package com.app.apifirstbooklibrary.entity;


public class Library {

    private String libraryName;
    private Owner owner;

    public Library() {
    }

    public Library(String libraryName, Owner owner) {
        this.libraryName = libraryName;
        this.owner = owner;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
