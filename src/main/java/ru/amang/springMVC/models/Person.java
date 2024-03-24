package ru.amang.springMVC.models;

import javax.validation.constraints.*;

public class Person {
    private int id;

    @NotEmpty(message = "Имя не должно быть пусты")
    @Size(min = 2, max = 100, message = "Имя должно состоять от 2 до 100 символов длинной")
    private String fullName;

    @Min(value = 1900, message = "Год рождения должен быть не меньше 1900 года")
    private int yearOfBirth;

    public Person(){

    }
    public Person(String fullName,int yearOfBirth) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getFullName() {return fullName;}

    public void setFullName(String fullName) {this.fullName = fullName;}

    public int getYearOfBirth() {return yearOfBirth;}

    public void setYearOfBirth(int yearOfBirth) {this.yearOfBirth = yearOfBirth;}

}
