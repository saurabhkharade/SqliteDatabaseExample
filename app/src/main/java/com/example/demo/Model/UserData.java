package com.example.demo.Model;

public class UserData {

    private String name;
    private String email_id;
    private String contact_number;
    private String date_of_birth;
    private String image;

    public UserData( String name, String email_id, String contact_number, String date_of_birth, String image) {
        this.name = name;
        this.email_id = email_id;
        this.contact_number = contact_number;
        this.date_of_birth = date_of_birth;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
