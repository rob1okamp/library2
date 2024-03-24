package ru.amang.springMVC.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty(message = "Название книги не должно быть пусты")
    @Size(min = 2, max = 100, message = "Название книги должно состоять от 2 до 100 символов длинной")
    private String title;

    @NotEmpty(message = "Имя автора не должно быть пусты")
    @Size(min = 2, max = 100, message = "Имя автора должно состоять от 2 до 100 символов длинной")
    private String author;

    @Min(value = 1500, message = "Год выпуска не может быть меньше 1500")
    private int year;

    public Book() {
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getAuthor() {return author;}

    public void setAuthor(String author) {this.author = author;}

    public int getYear() {return year;}

    public void setYear(int year) {this.year = year;}
}
