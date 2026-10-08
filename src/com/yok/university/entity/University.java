package com.yok.university.entity;

import com.yok.university.utils.Validations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {
    //singleton

    public static final int ID = 101;
    public static final String NAME = "FSWEB0102 University";
    public static final String type = "Private";
    public static final int YEAR = 2026;
    private static University instance;
    private List<Faculty> faculties = new ArrayList<>();
    private Address address;

    private University(){

    }

    public static University getInstance() {
        if(instance == null){
            instance = new University();
        }
        return instance;
    }

    public List<Faculty> getFaculties() {
        return Collections.unmodifiableList(faculties);
    }

    public Address getAddress() {
        return address;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties.clear();
        this.faculties = new ArrayList<>(faculties); //defensive copy
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addFaculty(Faculty faculty) {
        /*
        if(faculty == null) {
            throw new IllegalArgumentException("Can not add null to faculty list");
        }
        */

        Validations.nullCheck(faculty, "Can not add null to faculty list");

        if(!faculties.contains(faculty)){
            faculties.add(faculty);
        }
    }

    public void removeFaculty(Faculty faculty){
        faculties.remove(faculty);
    }

    public Faculty getFacultyById(int id) {

        for(Faculty faculty: faculties){
            if(faculty.getId() == id){
                return faculty;
            }
        }
        return null;
    }

    public List<Faculty> searchFacultiesByName(String name) {
        //bir list oluştur
        //for döngüsü ile tüm fakülteleri gez
        //name'lerinde name içerir mi kotnrol et
        //varsa listeye ekle
        //listeyi dön

        List<Faculty> searchResult = new ArrayList<>();
        for(Faculty faculty: faculties){
            if(faculty.getName().toLowerCase().contains(name.toLowerCase())){
                searchResult.add(faculty);
            }
        }
        return searchResult;

    }

    public List<Faculty> searchFaculties(String text) {
        //bir list oluştur
        //for döngüsü ile tüm fakülteleri gez
        //name'lerinde name içerir mi kotnrol et
        //varsa listeye ekle
        //listeyi dön

        List<Faculty> searchResult = new ArrayList<>();
        for(Faculty faculty: faculties){
            if(faculty.getName().toLowerCase().contains(text.toLowerCase())
               || faculty.getDean().toLowerCase().contains(text.toLowerCase())){
                searchResult.add(faculty);
            }
        }
        return searchResult;

    }

    @Override
    public String toString() {
        return "University{" +
                "faculties=" + faculties +
                ", address=" + address +
                '}';
    }
}
