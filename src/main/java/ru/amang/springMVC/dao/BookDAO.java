package ru.amang.springMVC.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.amang.springMVC.models.Book;
import ru.amang.springMVC.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index (){
        return  jdbcTemplate.query("SELECT * FROM Books", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show (int id){
        return jdbcTemplate.query("SELECT * FROM Books WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save (Book book) {
        jdbcTemplate.update("INSERT INTO Books(title,author,year) VALUES (?,?,?)",
                book.getTitle(), book.getAuthor(), book.getYear());
    }

    public void update (int id, Book updateBook){
        jdbcTemplate.update("UPDATE Person SET title=?, author=?, year=? WHERE id=?",updateBook.getTitle(),
                updateBook.getAuthor(),updateBook.getYear(),id);
    }

    public void delete (int id){
        jdbcTemplate.update("DELETE FROM Books WHERE id=?",id);
    }


    public void release (int id){
        jdbcTemplate.update("UPDATE Books SET  person_id=NULL WHERE id=?",id);
    }

    public void assign (int id,Person selectedPerson){
        jdbcTemplate.update("UPDATE Books SET  person_id=? WHERE id=?",selectedPerson.getId(),id);
    }

    public Optional<Person> getBookOwner (int id){
        return jdbcTemplate.query("SELECT Person.* FROM Books JOIN Person ON Books.person_id = Person.id"
                + " WHERE Books.id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }
}
