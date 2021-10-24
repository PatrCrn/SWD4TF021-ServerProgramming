package com.example.Bookstore;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByAuthorBook() {
        List<Book> students = repository.findByAuthor("J. K. Rowling");
        assertThat(students).hasSize(1);
        assertThat(students.get(0).getTitle()).isEqualTo("Harry Potter à l'école des sorciers");
    }
    
    @Test
    public void createNewBook() {
        Book book = new Book("9451212154541", "Joe Mama", "James Camry", 1999, 10.21, categoryRepository.findByName("Romance").get(0));
    	repository.save(book);
    	assertThat(book.getIsbn()).isNotNull();
    }

    @Test
    public void deleteOldBook() {
        Book book = new Book("9451212154541", "Joe Mama", "James Camry", 1999, 10.21, categoryRepository.findByName("Romance").get(0));
        repository.save(book);
        assertThat(book.getIsbn()).isNotNull();
    }

}